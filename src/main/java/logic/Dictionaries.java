package org.example;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.*;

public class Dictionaries {
    private List<List<String>> characteristicPlaces;
    private List<List<String>> years;
    private List<List<String>> towns;
    private Map<String, List<String>> countries;
    private List<String> currency;
    private List<List<String>> famousPeople;
    private List<List<String>> names;
    private List<List<String>> holidays;
    private List<List<String>> administration;
    private List<List<String>> geographical;
    private List<String> standards;

    public Dictionaries() {
        this.characteristicPlaces = new ArrayList<>();
        this.years = new ArrayList<>();
        this.towns = new ArrayList<>();
        this.countries = new HashMap<>();
        this.currency = new ArrayList<>();
        this.famousPeople = new ArrayList<>();
        this.names = new ArrayList<>();
        this.holidays = new ArrayList<>();
        this.geographical = new ArrayList<>();
        this.administration = new ArrayList<>();
        this.standards = new ArrayList<>();
    }

    public void loadDictionary(String filePath, List<List<String>> list) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            boolean lineAfterBlank = false;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine){
                    isFirstLine = false;
                    continue;
                }
                if (index >= list.size()) {
                    list.add(new ArrayList<>());
                }
                if (line.trim().isEmpty()) {
                    lineAfterBlank = true;
                    continue;
                }
                if (lineAfterBlank) {
                    lineAfterBlank = false;
                    index += 1;
                    continue;
                }
                list.get(index).add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<List<String>> getAdministration() {
        return administration;
    }


    public List<List<String>> getCharacteristicPlaces() {
        return characteristicPlaces;
    }

    public List<List<String>> getYears() {
        return years;
    }

    public List<List<String>> getTowns() {
        return towns;
    }

    public Map<String, List<String>> getCountries() {
        return countries;
    }

    public List<String> getCurrency() {
        return currency;
    }

    public void initCurrency() {
        this.currency.add("USD");
        this.currency.add("Dollar");
        this.currency.add("dllrs");
        this.currency.add("dlr");
        this.currency.add("$");
        this.currency.add("francs");
        this.currency.add("franc");
        this.currency.add("stg");
        this.currency.add("mark");
        this.currency.add("marks");
        this.currency.add("pounds");
        this.currency.add("£");
        this.currency.add("GBP");
        this.currency.add("JPY");
        this.currency.add("Yen");
    }

    public void initStandards() {
        this.standards.add("unces");
        this.standards.add("pct");
        this.standards.add("cts");
        this.standards.add("tones");
        this.standards.add("metres");
        this.standards.add("kilos");
        this.standards.add("kg");
        this.standards.add("pound");
        this.standards.add("foot");
        this.standards.add("feet");
        this.standards.add("miles");
        this.standards.add("yards");
    }

    public void initCountries() {
        List<String> usa = new ArrayList<String>() {{
            add("America");
            add("American");
            add("USA");
            add("US");
            add("United States");
            add("United States of America");
        }};
        List<String> uk = new ArrayList<String>() {{
            add("United Kingdom");
            add("English");
            add("Scotish");
            add("British");
            add("UK");
            add("England");
            add("Great Britian");
            add("Scotland");
            add("Wales");
            add("Northern Irleand");
        }};
        List<String> ger = new ArrayList<String>() {{
            add("Germany");
            add("German");
            add("West Germany");
            add("East Germany");
            add("DE");
        }};
        List<String> jpn = new ArrayList<String>() {{
            add("Japan");
            add("Japanese");
            add("JPN");
        }};
        List<String> cnd = new ArrayList<String>() {{
            add("Canada");
            add("Canadian");
            add("CA");
        }};
        List<String> fr = new ArrayList<String>() {{
            add("France");
            add("French");
            add("FR");
        }};
        this.countries.put("USA", usa);
        this.countries.put("UK", uk);
        this.countries.put("GER", ger);
        this.countries.put("JPN", jpn);
        this.countries.put("CND", cnd);
        this.countries.put("FR", fr);
    }

    public List<List<String>> getFamousPeople() {
        return famousPeople;
    }

    public List<List<String>> getNames() {
        return names;
    }

    public List<List<String>> getHolidays() {
        return holidays;
    }

    public List<List<String>> getGeographical() {
        return geographical;
    }

    public List<String> getStandards() {
        return standards;
    }
}
