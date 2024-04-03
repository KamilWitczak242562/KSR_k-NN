package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        List<Object> data1 = new ArrayList<>(Arrays.asList(
//                "Statue of Liberty", "Toronto", Arrays.asList(0, 5, 3, 0, 2, 1), "USD",
//                "George Washington", Arrays.asList(0, 1, 0, 0, 1, 0), "John",
//                "Thanksgiving", Arrays.asList(0, 3, 0, 0, 1, 0), "yard", "Texas"
//        ));
//        List<Object> additionalData = Arrays.asList(
//                "Tower of London", "Berlin", Arrays.asList(4, 2, 3, 0, 0, 1), "marks",
//                "Albert Einstein", Arrays.asList(1, 0, 1, 0, 0, 0), "Paul",
//                "Labour Day", Arrays.asList(2, 0, 1, 0, 0, 0), "kg", "Berlin"
//        );
//        double test = Utils.urban(data1, additionalData);
//        System.out.println(test);

        List<Article> allArticles;

        try {
            allArticles = ArticlesLoader.loadData(20000, "all");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int index = 0;
        for (Article article: allArticles) {
            if (index % 2 == 0) {
                article.setFoundPlace(article.getPlace());
            } else {
                article.setFoundPlace("uk");
            }
            index +=1;
        }
        double test = Utils.f_1(Utils.precision(allArticles, "usa"), Utils.recall(allArticles, "usa"));
        System.out.println(test);
    }
}