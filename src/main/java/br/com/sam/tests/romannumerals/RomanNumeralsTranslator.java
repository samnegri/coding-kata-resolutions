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

        public Integer getValue() {
            return value;
        }
    }

    String toRoman(Integer num) {
        Integer acum = 0;
        StringBuilder roman = new StringBuilder();

        Optional<RomanNumerals> maybeMax = getMaxNumeralPossibleEnum(num);

        while(maybeMax.isPresent()) {
            RomanNumerals max = maybeMax.get();
            acum += max.value;
            roman.append(max);
            maybeMax = getMaxNumeralPossibleEnum(num - acum);
        }

        return roman.toString();
    }

    Integer toInteger(String roman) {
        Integer value = 0;
        for (int i = 0; i < roman.length(); i++) {
            if (roman.length() >= i + 2 && getCorrespondingValue(roman.substring(i, i + 2)).isPresent()) {
                value += getCorrespondingValue(roman.substring(i, i + 2)).get();
                i++;
            } else {
                value += getCorrespondingValue(roman.substring(i, i + 1))
                    .orElseThrow(() -> new RuntimeException("Invalid Number"));
            }
        }
        return value;
    }

    private Optional<Integer> getCorrespondingValue(String romanValue) {
        return Arrays.stream(RomanNumerals.values())
            .map(Enum::toString)
            .filter(numeral -> numeral.equals(romanValue))
            .map(RomanNumerals::valueOf)
            .map(RomanNumerals::getValue)
            .max(Integer::compareTo);
    }

    private Optional<RomanNumerals> getMaxNumeralPossibleEnum(int limit) {
        return Arrays.stream(RomanNumerals.values())
            .filter(romanNumerals -> romanNumerals.value <= limit)
            .max(Enum::compareTo);

    }
}
