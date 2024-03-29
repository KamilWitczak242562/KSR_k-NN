package org.example;

import java.io.IOException;
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
        List<Article> ar;
        try {
            ar = ArticlesLoader.loadData("reut2-001.sgm", 2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Article article : ar) {
            System.out.println(article.toString());
        }
    }
}