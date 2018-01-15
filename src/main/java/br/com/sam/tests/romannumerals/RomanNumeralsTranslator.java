package br.com.sam.tests.romannumerals;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Samuel Negri Morais on 1/14/18.
 */
public class RomanNumeralsTranslator {

    enum RomanNumerals {
        I(1),IV(4),V(5),IX(9),X(10),XL(40),L(50),XC(90),C(100),CD(400),D(500),CM(900),M(1000);

        private final int value;

        RomanNumerals(int value) {
            this.value = value;
        }
    }

    String toRoman(Integer num) {
        Integer acum = 0;
        StringBuilder roman = new StringBuilder();

        Optional<RomanNumerals> max2 = getMaxNumeralPossibleEnum(num);

        while(max2.isPresent()) {
            RomanNumerals max = max2.get();
            acum += max.value;
            roman.append(max);
            max2 = getMaxNumeralPossibleEnum(num - acum);
        }

        return roman.toString();


    }

    private Optional<RomanNumerals> getMaxNumeralPossibleEnum(int limit) {
        return Arrays.stream(RomanNumerals.values())
            .filter(romanNumerals -> romanNumerals.value <= limit)
            .max(Enum::compareTo);

    }
}
