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
            allArticles = ArticlesLoader.loadData(1000, null);
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
        kNN kNN = new kNN(allArticles, 5, "Miejska", 20);
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