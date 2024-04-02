package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class Utils {

    public static Double euklides(List<Object> vec1, List<Object> vec2) {
        double distance = 0.0;
        for (int i =0; i <vec1.size();i++){
            if (vec1.get(i).getClass() == String.class) {
                distance += bi_gram(vec1.get(i).toString(), vec2.get(i).toString());
            } else {
                List<Integer> vecInside1 = (List<Integer>) vec1.get(i);
                List<Integer> vecInside2 = (List<Integer>) vec2.get(i);
                double sum = 0.0;
                for (int j = 0; j < vecInside1.size(); j++) {
                    sum += Math.pow(vecInside1.get(j) - vecInside2.get(j), 2);
                }
                distance += Math.sqrt(sum);
            }
        }
        BigDecimal sqrtValue = BigDecimal.valueOf(Math.sqrt(distance));

        BigDecimal roundedValue = sqrtValue.setScale(2, RoundingMode.HALF_UP);

        return roundedValue.doubleValue();
    }

    public static Double czebyszew(List<Object> vec1, List<Object> vec2) {
        double distance = 0.0;
        for (int i =0; i <vec1.size();i++){
            if (vec1.get(i).getClass() == String.class) {

            } else {

            }
        }
        return 0.0;
    }

    public static Double urban(List<Object> vec1, List<Object> vec2) {
        double distance = 0.0;
        for (int i =0; i <vec1.size();i++){
            if (vec1.get(i).getClass() == String.class) {

            } else {

            }
        }
        return 0.0;
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

        BigDecimal result = BigDecimal.ONE.subtract(similarityBigDecimal.divide(lenBigDecimal, 2, RoundingMode.HALF_UP));
        return result.doubleValue();
    }
}
