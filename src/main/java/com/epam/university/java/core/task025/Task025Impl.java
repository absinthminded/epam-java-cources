package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        int amountOfAlteredLetters = 0;

        if (sourceMessage == null) {
            throw new IllegalArgumentException();
        } else if (sourceMessage.length() == 0) {
            return amountOfAlteredLetters;
        }

        boolean containsFull = sourceMessage.contains("SOS");
        boolean containsFullAltered = sourceMessage.contains("SAS");

        if (containsFull || containsFullAltered) {
            amountOfAlteredLetters = sourceMessage.replaceAll("[SO]", "").length();
        } else {
            amountOfAlteredLetters = sourceMessage.replaceAll("[O]", "").length();
        }


        return amountOfAlteredLetters;
    }
}
