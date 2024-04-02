package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {
    public static Double bi_gram(String firstWord, String secondWord) {
        double len = Math.max(firstWord.length(), secondWord.length());
        double similarity = 0;
        for (int i = 0; i < firstWord.length() - 1; i++) {
            String check = firstWord.substring(i, i + 2);
            System.out.println(check);
            if (secondWord.contains(check)){
                similarity += 1;
            }
        }
        System.out.println(similarity);
        System.out.println(len);
        BigDecimal similarityBigDecimal = BigDecimal.valueOf(similarity);
        BigDecimal lenBigDecimal = BigDecimal.valueOf(len - 1);

        if (len == 1) return 0.0;

        BigDecimal result = BigDecimal.ONE.subtract(similarityBigDecimal.divide(lenBigDecimal, 2, RoundingMode.HALF_UP));
        return result.doubleValue();
    }
}
