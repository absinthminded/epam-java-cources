package com.epam.university.java.core.task048;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

public class Task048Impl implements Task048 {
    @Override
    public Collection<Integer> getArmstrongNumbers(Integer from, Integer to) {
        if (from == null || to == null || from < 0 || to < 0) {
            throw new IllegalArgumentException();
        }

        return IntStream.range(from, to)
                .filter((n) -> {
                    final String number = Integer.toString(n);
                    return number.chars()
                            .mapToDouble(v -> Math.pow(v - '0', number.length()))
                            .sum() == n;
                }).collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);
    }
}
