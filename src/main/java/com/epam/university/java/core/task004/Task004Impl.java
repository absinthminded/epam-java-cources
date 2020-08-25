package com.epam.university.java.core.task004;

import com.epam.university.java.core.task003.Task003Impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Task004Impl implements Task004 {

    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        List<String> alist = Arrays.asList(first);
        List<String> blist = Arrays.asList(second);

        HashSet<String> aset =  new HashSet<>(alist);
        aset.retainAll(blist);

        String[] arrayWithCommonElements = aset.toArray(new String[aset.size()]);

        if (arrayWithCommonElements.length == 0) {
            System.out.println("No common elements.");
        }

        System.out.println(Arrays.toString(arrayWithCommonElements));

        return arrayWithCommonElements;
    }

    @Override
    public String[] union(String[] first, String[] second) {

        Task003Impl instance = new Task003Impl();

        String[] concatenationResult = instance.join(first, second);

        List<String> listOfStrings = Arrays.stream(concatenationResult)
                .map(word -> word.split(","))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        String[] finalResult = new String[listOfStrings.size()];
        int index = 0;
        for (Object value : listOfStrings) {
            finalResult[index] = (String) value;
            index++;
        }

        return finalResult;

    }
}
