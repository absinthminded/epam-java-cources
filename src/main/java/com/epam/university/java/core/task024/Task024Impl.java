package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

public class Task024Impl implements Task024 {
   
   
    @Override
    public Collection<String> getWordsCount(String source) {
        
        if (source == null) {
            throw new IllegalArgumentException();
        } else if (source.length() == 0) {
            return new ArrayList<>(0);
        }

        Collection<String> separatedWords;

        if (Pattern.matches(".*\\p{InCyrillic}.*", source)) {
            separatedWords = Arrays.asList(source.split("(?<=[а-я])(?=[А-Я])"));
        } else {
            separatedWords = Arrays.asList(source.split("(?<=[a-z])(?=[A-ZäöüÄÖÜß])"));
        }

        Collection<String> resultList = new ArrayList<>();

        for (String s : separatedWords
             ) {
            resultList.add(s.toLowerCase());
        }

        return resultList;
    }
}
