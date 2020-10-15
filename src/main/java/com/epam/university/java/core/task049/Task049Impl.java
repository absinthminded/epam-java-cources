package com.epam.university.java.core.task049;

public class Task049Impl implements Task049 {
    @Override
    public String getResultList(String first, String second) {
        if (first == null || second == null || second.contains(" ") || first.contains(" ")) {
            throw new IllegalArgumentException();
        }

        int max = 0;
        String maxSequence = "";

        for (int i = 0; i < first.length(); ++i) {
            for (int j = i + 1; j <= first.length(); ++j) {
                String subString = first.substring(i, j);
                if (second.contains(subString) && subString.length() > max) {
                    max = subString.length();
                    maxSequence = subString;
                }
            }
        }

        return maxSequence;

    }
}
