package br.com.sam.tests.romainnumerals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Samuel Negri Morais on 1/14/18.
 */
public class RomainNumeralsTranslator {

    enum RomainNumerals {
        I(1),IV(4),V(5),IX(9),X(10),XL(40),L(50),XC(90),C(100),CD(400),D(500),CM(900),M(1000);

        private final int value;

        RomainNumerals(int value) {
            this.value = value;
        }
    }

    String toRomain(Integer num) {
        Integer acum = 0;
        StringBuilder romain = new StringBuilder();

        Optional<RomainNumerals> max2 = getMaxNumeralPossibleEnum(num);

        while(max2.isPresent()) {
            RomainNumerals max = max2.get();
            acum += max.value;
            romain.append(max);
            max2 = getMaxNumeralPossibleEnum(num - acum);
        }

        return romain.toString();


    }

    private Optional<RomainNumerals> getMaxNumeralPossibleEnum(int limit) {
        return Arrays.stream(RomainNumerals.values())
            .filter(romainNumerals -> romainNumerals.value <= limit)
            .max(Enum::compareTo);

    }
}
