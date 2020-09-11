package com.epam.university.java.core.task023;


public class Task023Impl implements Task023 {

    @Override
    public String extract(String phoneString) {

        String operatorCode;

        if (phoneString != null && phoneString.length() > 10) {
            try {
                operatorCode = phoneString.replaceAll("[\\+(|)/\\s]", "").substring(1, 4);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }  else {
            throw new IllegalArgumentException();
        }

        return operatorCode;
    }
}


