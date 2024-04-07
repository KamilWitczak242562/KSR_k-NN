package logic;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Article> allArticles;
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
        for (int i = 3; i <= 9; i += 2) {
            kNN kNNE = new kNN(newArticles, i, "Euklidesowa", 80);
            kNNE.predict();
            List<Article> testE = kNNE.getTestArticles();
            kNN kNNC = new kNN(newArticles, i, "Czebyszewa", 80);
            kNNC.predict();
            List<Article> testC = kNNC.getTestArticles();
            kNN kNNM = new kNN(newArticles, i, "Miejska", 80);
            kNNM.predict();
            List<Article> testM = kNNM.getTestArticles();
            double accE = Utils.accuracy(testE);
            double accC = Utils.accuracy(testC);
            double accM = Utils.accuracy(testM);
            System.out.println("Acc dla Euklidesa, k = " + i + ", acc = " + accE);
            System.out.println("Acc dla Czebyszewa, k = " + i + ", acc = " + accC);
            System.out.println("Acc dla Miejskiej, k = " + i + ", acc = " + accM);
        }


    }
}