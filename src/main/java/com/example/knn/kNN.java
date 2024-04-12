package com.example.logic;

import java.util.*;

public class kNN {
    private List<Article> testArticles;
    private List<Article> trainArticles;
    private Integer k;
    private String classification;

    public kNN(List<Article> articles, Integer k, String classification, double percentage) {
        this.k = k;
        this.classification = classification;
        normalize(articles);
        createLists(articles, percentage);
    }

    public void predict() {
        Map<Article, Double> articlesWithDistances = new LinkedHashMap<>();
        for (Article article : this.testArticles) {
            for (Article articleTrain : this.trainArticles) {
                switch (this.classification){
                    case "Euklidesowa":
                        articlesWithDistances.put(articleTrain, Utils.euklides(article.getVector(), articleTrain.getVector()));
                        break;
                    case "Czebyszewa":
                        articlesWithDistances.put(articleTrain, Utils.czebyszew(article.getVector(), articleTrain.getVector()));
                        break;
                    case "Miejska":
                        articlesWithDistances.put(articleTrain, Utils.urban(article.getVector(), articleTrain.getVector()));
                        break;
                }
            }
            articlesWithDistances = sortMap(articlesWithDistances);
            Set<Map.Entry<Article, Double>> entrySet = articlesWithDistances.entrySet();
            Iterator<Map.Entry<Article, Double>> iterator = entrySet.iterator();
            int count = 0;
            List<Integer> countries= new ArrayList<>() {{
                add(0); add(0); add(0); add(0); add(0); add(0);
            }};
            while (iterator.hasNext() && count < this.k) {
                Map.Entry<Article, Double> entry = iterator.next();
                switch (entry.getKey().getPlace()){
                    case "usa":
                        countries.set(0, countries.get(0) + 1);
                        break;
                    case "uk":
                        countries.set(1, countries.get(1) + 1);
                        break;
                    case "canada":
                        countries.set(2, countries.get(2) + 1);
                        break;
                    case "west-germany":
                        countries.set(3, countries.get(3) + 1);
                        break;
                    case "france":
                        countries.set(4, countries.get(4) + 1);
                        break;
                    case "japan":
                        countries.set(5, countries.get(5) + 1);
                        break;
                }
                if (countries.size() > 6) System.out.println(countries.size());
                count++;
            }
            int max = Collections.max(countries);
            int maxIndex = countries.indexOf(max);
            switch (maxIndex){
                case 0:
                    article.setFoundPlace("usa");
                    break;
                case 1:
                    article.setFoundPlace("uk");
                    break;
                case 2:
                    article.setFoundPlace("canada");
                    break;
                case 3:
                    article.setFoundPlace("west-germany");
                    break;
                case 4:
                    article.setFoundPlace("france");
                    break;
                case 5:
                    article.setFoundPlace("japan");
                    break;
            }
        }
    }

    private Map<Article, Double> sortMap(Map<Article, Double> mapToSort) {
        List<Map.Entry<Article, Double>> list = new ArrayList<>(mapToSort.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Article, Double>>() {
            @Override
            public int compare(Map.Entry<Article, Double> o1, Map.Entry<Article, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Map<Article, Double> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Article, Double> entry : list) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    private void createLists(List<Article> articles, double percentage) {
        Collections.shuffle(articles, new Random(5));

        int totalSize = articles.size();
        int firstListSize = (int) (totalSize * percentage/100.0);

        this.trainArticles = new ArrayList<>(articles.subList(0, firstListSize));
        this.testArticles = new ArrayList<>(articles.subList(firstListSize, totalSize));
    }

    public void normalize(List<Article> articles) {
        List<List<Double>> features = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            features.add(new ArrayList<>());
        }

        int j = 0;
        for (Article article : articles) {
            for (Object vectorElement : article.getVector()) {
                if (vectorElement instanceof List) {
                    List<Double> vector = (List<Double>) vectorElement;
                    for (int k = 0; k < Math.min(6, vector.size()); k++, j++) {
                        features.get(j % features.size()).add(vector.get(k));
                    }
                }
            }
        }

        j = 0;
        for (Article article : articles) {
            for (Object vectorElement : article.getVector()) {
                if (vectorElement instanceof List) {
                    List<Double> vector = (List<Double>) vectorElement;
                    for (int k = 0; k < Math.min(6, vector.size()); k++, j++) {
                        double min = Collections.min(features.get(j % features.size()));
                        double max = Collections.max(features.get(j % features.size()));
                        double value = (vector.get(k) - min) / (max - min);
                        if (Double.isNaN(value)) {
                            value = 0.0;
                        }
                        vector.set(k, value);
                    }
                }
            }
        }
    }

    public List<Article> getTestArticles() {
        return testArticles;
    }
}
