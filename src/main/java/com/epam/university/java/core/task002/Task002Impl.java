package com.epam.university.java.core.task002;

import java.util.Arrays;
import java.util.List;

public class    Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            throw new IllegalArgumentException();
        }

        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        if (number > sourceString.length() - 1) {
            return sourceString;
        }

        return sourceString.substring(0, number);
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        int separatorNumber = sourceString.indexOf(separator);

        return left(sourceString, separatorNumber);
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        } else if (number > sourceString.length() - 1) {
            return sourceString;
        }

        return sourceString.substring(sourceString.length() - number);
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        int separatorNumber = sourceString.indexOf(separator);

        if (separatorNumber == -1) {
            return sourceString;
        }

        return right(sourceString, separatorNumber);

    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }

        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null || sourceCollection.length == 0 || glue == null) {
            throw new IllegalArgumentException();
        }

        for (String str : sourceCollection) {
            if (str == null) {
                throw new IllegalArgumentException();
            }
        }

        List<String> stringList = Arrays.asList(sourceCollection);
        String joinedCollection = String.join(glue, stringList);

        return joinedCollection;
    }

}
