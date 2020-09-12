package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        if (phoneString == null || phoneString.length() < 11) {
            throw new IllegalArgumentException();
        }

        String operatorCode = "";

        Pattern phonePattern = Pattern.compile("(?<=[78( ])(\\d{3})((?<=\\)|))");
        Matcher matcher = phonePattern.matcher(phoneString);

        if (matcher.find()) {
            operatorCode = matcher.group(1);
        }


        return operatorCode;
    }
}
