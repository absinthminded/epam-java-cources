package com.epam.university.java.core.task014;

import java.util.HashSet;
import java.util.Collection;
import java.util.Arrays;


public class Task014Impl implements Task014 {

    @Override
    public Collection<VampireNumber> getVampireNumbers() {

        Collection<VampireNumber> vampireNumbers = new HashSet<>();

        for (long first = 10; first < 99; first++) {

            String stringValFirst = String.valueOf(first);

            int max = (int) Math.min(99, Math.pow(10, stringValFirst.length()));

            for (long second = first; second < max; second++) {

                long multiplication = first * second;
                if (multiplication % 9 == (first + second) % 9) {

                    String stringValMultiplication = String.valueOf(multiplication);
                    String stringValSecond = String.valueOf(second);

                    if (!(stringValFirst.endsWith("0") && stringValSecond.endsWith("0"))) {

                        char[] cVampire = stringValMultiplication.toCharArray();
                        Arrays.sort(cVampire);

                        char[] cFangs = (stringValFirst + stringValSecond).toCharArray();
                        Arrays.sort(cFangs);

                        if (Arrays.equals(cVampire, cFangs)) {
                            if (Arrays.equals(cVampire, cFangs)) {
                                vampireNumbers.add(new VampireNumberImpl(Integer.parseInt(stringValMultiplication)
                                        , Integer.parseInt(stringValFirst)
                                        , Integer.parseInt(stringValSecond)));
                            }
                        }
                    }
                }
            }
        }

        return vampireNumbers;
    }
}
