package com.epam.university.java.core.task046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task046Impl implements Task046 {
    @Override
    public List<String> assembleMatryoshka(Integer k, Integer n) {
        if (k == null || n == null ) {
            throw new IllegalArgumentException();
        }
        if (k == 1 && n == 1) {
            return new ArrayList<String>(Arrays.asList("0"));
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    result.add(list.get(i) + " " + list.get(j));
                    System.out.println(list.get(i) + " " + list.get(j));
                }
            }
        }
        return result;
    }
}
