package com.epam.university.java.core.task020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        if (stones == null || stones.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int count = 0;

        int maxCharAmount = 26;

        int numCount = 0;

        String containsNum = null;

        List<String> str = new ArrayList<>();

        for (String s : stones) {
            containsNum = s.replaceAll("[A-Za-z]","");
            if (containsNum.length() >= 1) {
                numCount++;
            }
            s = s.replaceAll("[0-9]", "");
            str.add(s);
        }

        int n = str.size();

        Boolean[] prim = new Boolean[maxCharAmount];

        Arrays.fill(prim, Boolean.TRUE);


        for (String s : str) {
            Boolean[] sec = new Boolean[maxCharAmount];
            Arrays.fill(sec, Boolean.FALSE);

            for (int j = 0; j < s.length(); j++) {
                if (prim[s.charAt(j) - 'a']) {
                    sec[s.charAt(j) - 'a'] = true;
                }
            }

            System.arraycopy(sec, 0, prim, 0, maxCharAmount);
        }

        for (int i = 0; i < 26; i++) {
            if (prim[i]) {
                count++;
            }
        }

        System.out.println(numCount);
        if (numCount == str.size()) {
            count++;
        }

        return count;
    }
}
