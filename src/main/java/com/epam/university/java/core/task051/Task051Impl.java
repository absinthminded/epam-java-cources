package com.epam.university.java.core.task051;

public class Task051Impl implements Task051 {
    @Override
    public String replace(String source) {
        if (source == null || source.matches("\\s+") || source.contains("THE")) {
            throw new IllegalArgumentException();
        }

        String[] sourceArr = source.split(" ");

        if (sourceArr.length == 1) {
            throw new IllegalArgumentException();
        }

        int indexOfThe = -1;
        for (int i = 0; i < sourceArr.length; i++) {
            if ("the".equals(sourceArr[i])) {
                indexOfThe = i;
                continue;
            }
            if (indexOfThe != -1) {
                if (String.valueOf(sourceArr[i].charAt(0))
                        .matches("[^aeuio]")) {
                    sourceArr[indexOfThe] = "a";
                } else {
                    sourceArr[indexOfThe] = "an";
                }
            }
            indexOfThe = -1;
        }

        return String.join(" ", sourceArr);
    }
}
