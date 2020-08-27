package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task003Impl implements Task003 {

    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }

        List<String> list = Arrays.asList(source);
        Collections.reverse(list);
        String[] arrayToReturn = new String[list.size()];
        list.toArray(arrayToReturn);

        return arrayToReturn;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        int a = first.length;
        int b = second.length;
        String[] arrayToReturn = new String[a + b];
        System.arraycopy(first, 0, arrayToReturn, 0, a);
        System.arraycopy(second, 0, arrayToReturn, a, b);
        return arrayToReturn;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException();
        }
        int maxElement = Arrays.stream(source).max().getAsInt();

        return maxElement;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }

        List<String> listToFilter = Arrays.asList(source);
        List<String> resultList = listToFilter.stream().filter(t -> t.length() > 3)
              .collect(Collectors.toList());
        String[] arrayToReturn = new String[resultList.size()];
        resultList.toArray(arrayToReturn);
        return arrayToReturn;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }

        ArrayList<String> sourceList = new ArrayList<String>(Arrays.asList(source));
        ArrayList<String> toRemoteList = new ArrayList<String>(Arrays.asList(toRemote));
        sourceList.removeAll(toRemoteList);
        String[] arrayToReturn = new String[sourceList.size()];
        sourceList.toArray(arrayToReturn);

        return arrayToReturn;
    }

    @Override
        public String[] map(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }

        String[] arrayToReturn = new String[source.length];

        for (int i = 0; i < source.length; i++) {
            arrayToReturn[i] = operation.map(source[i]);
        }

        return arrayToReturn;
    }

    @Override
        public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }

        List<String> listOfStrings = Arrays.stream(source)
              .map(word -> word.replaceAll("\\s", "").split(","))
              .flatMap(Arrays::stream)
              .distinct()
              .collect(Collectors.toList());

        String[] arrayToOrder = new String[listOfStrings.size()];
        int index = 0;
        for (Object value : listOfStrings) {
            arrayToOrder[index] = (String) value;
            index++;
        }

        int[] arrDesc = Arrays.stream(arrayToOrder)
              .mapToInt(Integer::parseInt).sorted()
              .boxed()
              .sorted(Collections.reverseOrder())
              .mapToInt(Integer::intValue)
              .toArray();

        String[] finalString = Arrays.stream(arrDesc)
                                      .mapToObj(String::valueOf)
                                      .toArray(String[]::new);

        return finalString;

    }
}
