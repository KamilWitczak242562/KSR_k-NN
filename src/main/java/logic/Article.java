package logic;

import java.util.*;

public class Article {
    private String body;
    private String place;
    private String title;
    private List<Object> vector;
    private String foundPlace;

    public Article(String body, String place, String title) {
        this.body = body;
        this.place = place;
        this.title = title;
        this.vector = new ArrayList<>();
    }


    public void addFirstChar() {
        Map<String, Integer> indexes = new HashMap<>();
        for (List<String> list : Dictionaries.getDictionaries().getCharacteristicPlaces()) {
            for (String place : list) {
                if (body.contains(place)) {
                    int index = body.indexOf(place);
                    indexes.put(place, index);
                }
            }
        }
        String result = checkMinMax(false, indexes);
        this.vector.add(result);
    }

    /**
     * Add checking title
     */
    public void addSecondChar() {
        Map<String, Integer> occurrence = new HashMap<>();
        for (List<String> list : Dictionaries.getDictionaries().getTowns()) {
            for (String town : list) {
                int index = 0;
                int townLength = town.length();
                while ((index = body.indexOf(town, index)) != -1) {
                    if (body.contains(town)) {
                        if (occurrence.containsKey(town)) {
                            int occ = occurrence.get(town);
                            occurrence.put(town, occ + 1);
                        } else {
                            occurrence.put(town, 1);
                        }
                        index += townLength;
                    }
                }
            }
        }
        String result = checkMinMax(true, occurrence);
        this.vector.add(result);
    }

    /**
     * To implement
     */
    public void addThirdChar() {

    }

    public void addFourthChar() {
        Map<String, Integer> occurrence = new HashMap<>();
        for (String currency : Dictionaries.getDictionaries().getCurrency()) {
            int index = 0;
            int townLength = currency.length();
            while ((index = body.indexOf(currency, index)) != -1) {
                if (body.contains(currency)) {
                    if (occurrence.containsKey(currency)) {
                        int occ = occurrence.get(currency);
                        occurrence.put(currency, occ + 1);
                    } else {
                        occurrence.put(currency, 1);
                    }
                    index += townLength;
                }
            }
        }
        String result = checkMinMax(true, occurrence);
        this.vector.add(result);
    }

    public void addFifthChar() {
        Map<String, Integer> indexes = new HashMap<>();
        for (List<String> list : Dictionaries.getDictionaries().getFamousPeople()) {
            for (String person : list) {
                if (body.contains(person)) {
                    int index = body.indexOf(person);
                    indexes.put(person, index);
                }
            }
        }
        String result = checkMinMax(false, indexes);
        this.vector.add(result);
    }

    /**
     * To implement
     */
    public void addSixthChar() {

    }

    public void addSeventhChar() {
        Map<String, Integer> occurrence = new HashMap<>();
        for (List<String> list : Dictionaries.getDictionaries().getNames()) {
            for (String name : list) {
                int index = 0;
                int townLength = name.length();
                while ((index = body.indexOf(name, index)) != -1) {
                    if (body.contains(name)) {
                        if (occurrence.containsKey(name)) {
                            int occ = occurrence.get(name);
                            occurrence.put(name, occ + 1);
                        } else {
                            occurrence.put(name, 1);
                        }
                        index += townLength;
                    }
                }
            }
        }
        String result = checkMinMax(true, occurrence);
        this.vector.add(result);
    }

    public void addEighthChar() {
        Map<String, Integer> indexes = new HashMap<>();
        for (List<String> list : Dictionaries.getDictionaries().getHolidays()) {
            for (String holiday : list) {
                if (body.contains(holiday)) {
                    int index = body.indexOf(holiday);
                    indexes.put(holiday, index);
                }
            }
        }
        String result = checkMinMax(false, indexes);
        this.vector.add(result);
    }

    /**
     * To implement
     */
    public void addNinthChar() {

    }

    public void addTenthChar() {
        Map<String, Integer> occurrence = new HashMap<>();
        for (String standard : Dictionaries.getDictionaries().getStandards()) {
                int index = 0;
                int townLength = standard.length();
                while ((index = body.indexOf(standard, index)) != -1) {
                    if (body.contains(standard)) {
                        if (occurrence.containsKey(standard)) {
                            int occ = occurrence.get(standard);
                            occurrence.put(standard, occ + 1);
                        } else {
                            occurrence.put(standard, 1);
                        }
                        index += townLength;
                    }
                }
        }
        String result = checkMinMax(true, occurrence);
        this.vector.add(result);
    }

    public void addEleventhChar() {
        Map<String, Integer> occurrence = new HashMap<>();
        for (List<String> list : Dictionaries.getDictionaries().getAdministration()) {
            for (String adm : list) {
                int index = 0;
                int townLength = adm.length();
                while ((index = body.indexOf(adm, index)) != -1) {
                    if (body.contains(adm)) {
                        if (occurrence.containsKey(adm)) {
                            int occ = occurrence.get(adm);
                            occurrence.put(adm, occ + 1);
                        } else {
                            occurrence.put(adm, 1);
                        }
                        index += townLength;
                    }
                }
            }
        }
        String result = checkMinMax(true, occurrence);
        this.vector.add(result);
    }

    private String checkMinMax(boolean max, Map<String, Integer> maptoCheck) {
        int value = 0;
        String output = null;
        if (max) {
            value = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> entry : maptoCheck.entrySet()) {
                if (entry.getValue() > value) {
                    value = entry.getValue();
                    output = entry.getKey();
                }
            }
        } else {
            value = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : maptoCheck.entrySet()) {
                if (entry.getValue() < value) {
                    value = entry.getValue();
                    output = entry.getKey();
                }
            }
        }
        return output;
    }

    @Override
    public String toString() {
        return "Article{" +
                "body='" + body + '\'' +
                ", place='" + place + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getBody() {
        return body;
    }

    public String getPlace() {
        return place;
    }

    public String getTitle() {
        return title;
    }

    public List<Object> getVector() {
        return vector;
    }

    public String getFoundPlace() {
        return foundPlace;
    }
}
