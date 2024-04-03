package logic;

import java.util.*;

public class kNN {
    private List<Article> testArticles;
    private List<Article> trainArticles;
    private Integer k;
    private String classification;

    public kNN(List<Article> articles, Integer k, String classification, double percentage) {
        this.k = k;
        this.classification = classification;
        createLists(articles, percentage);
    }

    /**
     * TODO classification
     */
    public void predict() {
        Map<Article, Double> articlesWithDistances = new LinkedHashMap<>();
        for (Article article : this.testArticles) {
            for (Article articleTrain : this.trainArticles) {
                articlesWithDistances.put(articleTrain, Utils.euklides(article.getVector(), articleTrain.getVector()));
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
        Collections.shuffle(articles);

        int totalSize = articles.size();
        int firstListSize = (int) (totalSize * percentage/100.0);

        this.trainArticles = new ArrayList<>(articles.subList(0, firstListSize));
        this.testArticles = new ArrayList<>(articles.subList(firstListSize, totalSize));
    }

    /**
     * TODO implement
     */
    public void normalize(List<Article> articles) {
        List<List<Double>> features = new ArrayList<>();
        List<Double> featuresMax = new ArrayList<>();
        for (Article article : articles) {
            for (int i = 0; i < article.getVector().size(); i++) {
                if (article.getVector().get(i).getClass() != String.class) {

                }
            }
        }

    }

    public List<Article> getTestArticles() {
        return testArticles;
    }
}
