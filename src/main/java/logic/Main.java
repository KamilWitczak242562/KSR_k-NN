package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//       Dictionaries dictionaries = new Dictionaries();
//       dictionaries.loadDictionary("places.txt", dictionaries.getCharacteristicPlaces());
//       dictionaries.loadDictionary("administration.txt", dictionaries.getAdministration());
//       dictionaries.loadDictionary("dates.txt", dictionaries.getYears());
//       dictionaries.loadDictionary("famous.txt", dictionaries.getFamousPeople());
//       dictionaries.loadDictionary("geographical.txt", dictionaries.getGeographical());
//       dictionaries.loadDictionary("holidays.txt", dictionaries.getHolidays());
//       dictionaries.loadDictionary("names.txt", dictionaries.getNames());
//       dictionaries.loadDictionary("towns.txt", dictionaries.getTowns());
//       System.out.println(dictionaries.getAdministration());
//       System.out.println(dictionaries.getGeographical());
//       System.out.println(dictionaries.getFamousPeople());
//       System.out.println(dictionaries.getHolidays());
//       System.out.println(dictionaries.getFamousPeople());
//       System.out.println(dictionaries.getCharacteristicPlaces());
//       System.out.println(dictionaries.getNames());
//       System.out.println(dictionaries.getYears());
//       dictionaries.initCurrency();
//       dictionaries.initStandards();
//       dictionaries.initCountries();
//       System.out.println(dictionaries.getCurrency());
//       System.out.println(dictionaries.getStandards());
//       System.out.println(dictionaries.getCountries());
//        List<Article> ar;
//        try {
//            ar = ArticlesLoader.loadData(10, "all");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        for (Article article: ar) {
//            System.out.println(article.toString());
//        }
//        System.out.println(ar.size());
//        double test = Utils.bi_gram("kaczka", "kaczy");
//        System.out.println(test);
        List<Object> data1 = new ArrayList<>(Arrays.asList(
                "Statue of Liberty", "Toronto", Arrays.asList(0, 5, 3, 0, 2, 1), "USD",
                "George Washington", Arrays.asList(0, 1, 0, 0, 1, 0), "John",
                "Thanksgiving", Arrays.asList(0, 3, 0, 0, 1, 0), "yard", "Texas"
        ));
        List<Object> additionalData = Arrays.asList(
                "Tower of London", "Berlin", Arrays.asList(4, 2, 3, 0, 0, 1), "marks",
                "Albert Einstein", Arrays.asList(1, 0, 1, 0, 0, 0), "Paul",
                "Labour Day", Arrays.asList(2, 0, 1, 0, 0, 0), "kg", "Berlin"
        );
        double test = Utils.euklides(data1, additionalData);
        System.out.println(test);
    }
}