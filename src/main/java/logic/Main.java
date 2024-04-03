package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Article> allArticles;
        try {
            allArticles = ArticlesLoader.loadData(3000, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Article article : allArticles) {
            article.addFirstChar();
            article.addSecondChar();
            article.addThirdChar();
            article.addFourthChar();
            article.addFifthChar();
            article.addSixthChar();
            article.addSeventhChar();
            article.addEighthChar();
            article.addNinthChar();
            article.addTenthChar();
            article.addEleventhChar();
        }
//        int t = 0;
//        for (Article article : allArticles) {
//            if (article.getPlace().equals("japan")) {
//                t += 1;
//            }
//        }
//        List<List<Article>> ar = new ArrayList<>(){{
//            add(new ArrayList<>()); add(new ArrayList<>()); add(new ArrayList<>()); add(new ArrayList<>());
//            add(new ArrayList<>()); add(new ArrayList<>()); add(new ArrayList<>());
//        }};
//        for (Article article: allArticles){
//            switch (article.getPlace()){
//                case "usa":
//                    if (ar.get(0).size() < t){
//                        ar.get(0).add(article);
//                    }
//                    break;
//                case "uk":
//                    if (ar.get(1).size() < t){
//                        ar.get(1).add(article);
//                    }
//                    break;
//                case "canada":
//                    if (ar.get(2).size() < t){
//                        ar.get(2).add(article);
//                    }
//                    break;
//                case "west-germany":
//                    if (ar.get(3).size() < t){
//                        ar.get(3).add(article);
//                    }
//                    break;
//                case "france":
//                    if (ar.get(4).size() < t){
//                        ar.get(4).add(article);
//                    }
//                    break;
//                case "japan":
//                    if (ar.get(5).size() < t){
//                        ar.get(5).add(article);
//                    }
//                    break;
//            }
//        }
//        List<Article> ab = new ArrayList<>();
//        for (int i = 0; i < ar.size(); i++) {
//            ab.addAll(ar.get(i));
//        }
        kNN kNN = new kNN(allArticles, 5, "test", 20);
        kNN.predict();
        List<Article> test = kNN.getTestArticles();
        for (Article article : test) {
            if (article.getFoundPlace() == null) System.out.println(article.getFoundPlace());
        }

        double acc = Utils.accuracy(test);
        int k = 0;
        int n = 0;
        for (Article article : test) {
            if (article.getPlace().equals(article.getFoundPlace())) {
                k += 1;
            }
            if (!article.getFoundPlace().equals("usa")) {
                System.out.println(article.getPlace() + "    " + article.getFoundPlace());
                System.out.println();
            }
            if (article.getPlace().equals("usa")) {
                n += 1;
            }
        }
        System.out.println(acc);
        System.out.println(k);
        System.out.println(test.size());
        System.out.println(n);
    }
}