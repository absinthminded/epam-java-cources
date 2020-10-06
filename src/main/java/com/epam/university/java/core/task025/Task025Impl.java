package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage == null) {
            throw new IllegalArgumentException();
        }

        int amountOfAlteredLetters = 0;

        String originalSignal = "SOS".repeat(Math.max(0, (sourceMessage.length() + 1) / 2));

        for (int i = 0; i < sourceMessage.length(); i++) {
            if (sourceMessage.charAt(i) != originalSignal.charAt(i)) {
                amountOfAlteredLetters++;
            }
        }

        return amountOfAlteredLetters;
    }
}
