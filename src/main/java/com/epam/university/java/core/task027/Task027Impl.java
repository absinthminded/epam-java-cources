package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        } else if (sourceString.length() == 1) {
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        String source = sourceString;

        int first = Character.getNumericValue(source.charAt(0));
        int second = Character.getNumericValue(source.charAt(1));
        int third = Character.getNumericValue(source.charAt(2));


        if (first == 1 && second != 0) {
            String[] newOne = source.split("");
            for (String s : newOne) {
                resultList.add(Integer.parseInt(s));
            }
        }

        if (first == 1 && second == 0) {
            String[] newOne = source.split("(?<=\\G.{2})");
            for (String s : newOne) {
                resultList.add(Integer.parseInt(s));
            }
        }

        if (first == second && third != 9) {
            resultList.add(Integer.parseInt(source.substring(0, 2)));
            resultList.add(Integer.parseInt(source.substring(2,5)));
            resultList.add(Integer.parseInt(source.substring(5)));
        }

        int fourth = Character.getNumericValue(source.charAt(3));

        if (first == second && third == 9 && fourth != 8) {
            resultList.add(Integer.parseInt(source.substring(0, 3)));
            resultList.add(Integer.parseInt(source.substring(3,7)));
            resultList.add(Integer.parseInt(source.substring(7)));
        }

        if (first == second && third == 9 && fourth == 8) {
            if (Integer.parseInt(source.substring(8)) > Integer.parseInt(source.substring(4,8))) {
                resultList.add(Integer.parseInt(source.substring(0,4)));
                resultList.add(Integer.parseInt(source.substring(4,8)));
                resultList.add(Integer.parseInt(source.substring(8)));
            } else {
                return new ArrayList<>();
            }

        }

        return resultList;
    }
}
