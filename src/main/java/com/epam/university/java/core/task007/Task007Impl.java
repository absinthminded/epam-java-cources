package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;


public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        int m = first.size();
        int n = second.size();

        Integer[] firstP = first.toArray(new Integer[first.size()]);
        Integer[] secondP = second.toArray(new Integer[second.size()]);

        int[] prod = new int[m + n - 1];

        for (int i = 0; i < m + n - 1; i++) {
            prod[i] = 0;
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                prod[i + j] += firstP[i] * secondP[j];
            }
        }

        Collection<Integer> result = new ArrayList<>(prod.length);
        for (int value : prod) {
            result.add(value);
        }

        return result;
    }
}
