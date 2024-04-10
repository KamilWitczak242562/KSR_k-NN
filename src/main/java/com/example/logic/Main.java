package com.example.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Article> allArticles;
        List<String> countries = new ArrayList<>() {{
            add("usa");
            add("uk");
            add("canada");
            add("west-germany");
            add("france");
            add("japan");
        }};
        try {
            allArticles = ArticlesLoader.loadData(20000, "all");
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
        List<Article> newArticles = Utils.articlesAlignment(allArticles, "france");
        kNN kNNE = new kNN(newArticles, 5, "Euklidesowa", 80);
        kNNE.predict();
        List<Article> testE = kNNE.getTestArticles();
        System.out.println(Utils.accuracy(testE));
        for (String country: countries) {
            System.out.println(country);
            System.out.println("Precision: " + Utils.precision(testE, country));
            System.out.println("Recall: " + Utils.recall(testE, country));
            System.out.println("F1: " + Utils.f_1(Utils.precision(testE, country), Utils.recall(testE, country)));
        }
        System.out.println(Utils.averagePrecision(testE));
        System.out.println(Utils.averageRecall(testE));
        System.out.println(Utils.averageF1(testE));
    }
}