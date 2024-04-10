package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Utils {
    public static List<Article> articlesAlignment(List<Article> articles, String country) {
        int t = 0;
        for (Article article : articles) {
            if (article.getPlace().equals(country)) {
                t += 1;
            }
        }
        List<List<Article>> ar = new ArrayList<>(){{
            add(new ArrayList<>()); add(new ArrayList<>()); add(new ArrayList<>()); add(new ArrayList<>());
            add(new ArrayList<>()); add(new ArrayList<>()); add(new ArrayList<>());
        }};
        for (Article article: articles){
            switch (article.getPlace()){
                case "usa":
                    if (ar.get(0).size() < t){
                        ar.get(0).add(article);
                    }
                    break;
                case "uk":
                    if (ar.get(1).size() < t){
                        ar.get(1).add(article);
                    }
                    break;
                case "canada":
                    if (ar.get(2).size() < t){
                        ar.get(2).add(article);
                    }
                    break;
                case "west-germany":
                    if (ar.get(3).size() < t){
                        ar.get(3).add(article);
                    }
                    break;
                case "france":
                    if (ar.get(4).size() < t){
                        ar.get(4).add(article);
                    }
                    break;
                case "japan":
                    if (ar.get(5).size() < t){
                        ar.get(5).add(article);
                    }
                    break;
            }
        }
        List<Article> output = new ArrayList<>();
        for (List<Article> articleList : ar) {
            output.addAll(articleList);
        }
        return output;
    }
    public static Double accuracy(List<Article> articles) {
        double amount = 0.0;
        for (Article article : articles) {
            if (article.getPlace().equals(article.getFoundPlace())) {
                amount += 1.0;
            }
        }
        BigDecimal bigAmount = BigDecimal.valueOf(amount);
        BigDecimal size = BigDecimal.valueOf(articles.size());
        BigDecimal result = bigAmount.divide(size, 3, RoundingMode.HALF_UP);
        return result.doubleValue();
    }

    public static Double precision(List<Article> articles, String country) {
        double amount = 0.0;
        double meter = 0.0;
        for (Article article : articles) {
            if (article.getFoundPlace().equals(country) && article.getPlace().equals(country)) {
                meter += 1.0;
            }
            if (article.getFoundPlace().equals(country)) {
                amount += 1.0;
            }
        }
        if (amount != 0) {
            BigDecimal bigAmount = BigDecimal.valueOf(amount);
            BigDecimal bigMeter = BigDecimal.valueOf(meter);
            BigDecimal result = bigMeter.divide(bigAmount, 3, RoundingMode.HALF_UP);
            return result.doubleValue();
        } else {
            return 0.0;
        }
    }

    public static Double recall(List<Article> articles, String country) {
        double amount = 0.0;
        double meter = 0.0;
        for (Article article : articles) {
            if (article.getFoundPlace().equals(country) && article.getPlace().equals(country)) {
                meter += 1.0;
            }
            if (article.getPlace().equals(country)) {
                amount += 1.0;
            }
        }
        BigDecimal bigAmount = BigDecimal.valueOf(amount);
        BigDecimal bigMeter = BigDecimal.valueOf(meter);
        BigDecimal result = bigMeter.divide(bigAmount, 3, RoundingMode.HALF_UP);
        return result.doubleValue();
    }

    public static Double f_1(double precision, double recall) {
        if (precision != 0) {
            BigDecimal bigPrecision = BigDecimal.valueOf(precision);
            BigDecimal bigRecall = BigDecimal.valueOf(recall);
            BigDecimal result = BigDecimal.TWO.multiply(bigPrecision.multiply(bigRecall).divide(bigPrecision.add(bigRecall), 3, RoundingMode.HALF_UP));
            return result.doubleValue();
        } else {
            return 0.0;
        }
    }

    public static Double euklides(List<Object> vec1, List<Object> vec2) {
        double distance = 0.0;
        for (int i = 0; i < vec1.size(); i++) {
            if (vec1.get(i).getClass() == String.class) {
                distance += bi_gram(vec1.get(i).toString(), vec2.get(i).toString());
            } else {
                List<Double> vecInside1 = (List<Double>) vec1.get(i);
                List<Double> vecInside2 = (List<Double>) vec2.get(i);
                double sum = 0.0;
                for (int j = 0; j < vecInside1.size(); j++) {
                    sum += Math.pow(vecInside1.get(j) - vecInside2.get(j), 2);
                }
                distance += Math.sqrt(sum);
            }
        }
        BigDecimal sqrtValue = BigDecimal.valueOf(Math.sqrt(distance));

        BigDecimal roundedValue = sqrtValue.setScale(3, RoundingMode.HALF_UP);

        return roundedValue.doubleValue();
    }

    public static Double czebyszew(List<Object> vec1, List<Object> vec2) {
        List<Double> distance = new ArrayList<>();
        for (int i = 0; i < vec1.size(); i++) {
            if (vec1.get(i).getClass() == String.class) {
                distance.add(bi_gram(vec1.get(i).toString(), vec2.get(i).toString()));
            } else {
                List<Double> vecInside1 = (List<Double>) vec1.get(i);
                List<Double> vecInside2 = (List<Double>) vec2.get(i);
                List<Double> sum = new ArrayList<>();
                for (int j = 0; j < vecInside1.size(); j++) {
                    sum.add((double) Math.abs(vecInside1.get(j) - vecInside2.get(j)));
                }
                distance.add(Collections.max(sum));
            }
        }
        BigDecimal result = BigDecimal.valueOf(Collections.max(distance));

        BigDecimal roundedValue = result.setScale(3, RoundingMode.HALF_UP);

        return roundedValue.doubleValue();
    }

    public static Double urban(List<Object> vec1, List<Object> vec2) {
        double distance = 0.0;
        for (int i = 0; i < vec1.size(); i++) {
            if (vec1.get(i).getClass() == String.class) {
                distance += bi_gram(vec1.get(i).toString(), vec2.get(i).toString());
            } else {
                List<Double> vecInside1 = (List<Double>) vec1.get(i);
                List<Double> vecInside2 = (List<Double>) vec2.get(i);
                double sum = 0.0;
                for (int j = 0; j < vecInside1.size(); j++) {
                    sum += Math.abs(vecInside1.get(j) - vecInside2.get(j));
                }
                distance += sum;
            }
        }
        BigDecimal result = BigDecimal.valueOf(distance);

        BigDecimal roundedValue = result.setScale(3, RoundingMode.HALF_UP);

        return roundedValue.doubleValue();
    }

    public static Double bi_gram(String firstWord, String secondWord) {
        firstWord = firstWord.replaceAll("\s", "");
        secondWord = secondWord.replaceAll("\s", "");
        double len = Math.max(firstWord.length(), secondWord.length());
        double similarity = 0;
        for (int i = 0; i < firstWord.length() - 1; i++) {
            String check = firstWord.substring(i, i + 2);
            if (secondWord.contains(check)) {
                similarity += 1;
            }
        }
        BigDecimal similarityBigDecimal = BigDecimal.valueOf(similarity);
        BigDecimal lenBigDecimal = BigDecimal.valueOf(len - 1);

        if (len == 1) return 0.0;

        BigDecimal result = BigDecimal.ONE.subtract(similarityBigDecimal.divide(lenBigDecimal, 3, RoundingMode.HALF_UP));
        return result.doubleValue();
    }
}
