package com.epam.university.java.core.task026;


import java.util.Arrays;

public class Task026Impl implements Task026 {

    static int AMOUNT_OF_LETTERS = 26;

    @Override
    public String encrypt(String sourceString, int shift) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        } else if (shift == 0) {
            return sourceString;
        }

        char[] charsToEncrypt = sourceString.toCharArray();
        char[] alphabetLowered = new char[AMOUNT_OF_LETTERS];
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabetLowered[ch - 'a'] = ch;
        }

        char[] alphabetUpper = new char[AMOUNT_OF_LETTERS];
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            alphabetUpper[ch - 'A'] = ch;
        }

        for (int i = 0; i < charsToEncrypt.length; i++) {
            int index = 0;
            boolean isNotLetter = Character.isWhitespace(charsToEncrypt[i]);
            if (!isNotLetter) {
                if (Character.isLowerCase(charsToEncrypt[i])) {
                    for (int j = 0; j < alphabetLowered.length; j++) {
                        if (charsToEncrypt[i] != alphabetLowered[index]) {
                            index++;
                        }
                    }
                    index += shift;
                    while (index >= AMOUNT_OF_LETTERS) {
                        index -= AMOUNT_OF_LETTERS;
                    }
                    charsToEncrypt[i] = alphabetLowered[index];

                } else if (Character.isUpperCase(charsToEncrypt[i])) {
                    for (int j = 0; j < alphabetUpper.length; j++) {
                        if (charsToEncrypt[i] != alphabetUpper[index]) {
                            index++;
                        }
                    }
                    index += shift;
                    while (index >= AMOUNT_OF_LETTERS) {
                        index -= AMOUNT_OF_LETTERS;
                    }
                    charsToEncrypt[i] = alphabetUpper[index];
                }
            }
        }

        StringBuilder encryptedString = new StringBuilder();
        for (char c : charsToEncrypt) {
            encryptedString.append(c);
        }

        return encryptedString.toString();
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        if (encryptedString == null) {
            throw new IllegalArgumentException();
        } else if (shift == 0) {
            return encryptedString;
        }
        char[] charsToEncrypt = encryptedString.toCharArray();
        char[] alphabetLowered = new char[AMOUNT_OF_LETTERS];
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabetLowered[ch - 'a'] = ch;
        }

        char[] alphabetUpper = new char[AMOUNT_OF_LETTERS];
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            alphabetUpper[ch - 'A'] = ch;
        }

        for (int i = 0; i < charsToEncrypt.length; i++) {
            int index = 0;
            boolean isNotLetter = Character.isWhitespace(charsToEncrypt[i]);
            if (!isNotLetter) {
                if (Character.isLowerCase(charsToEncrypt[i])) {
                    for (int j = 0; j < alphabetLowered.length; j++) {
                        if (charsToEncrypt[i] != alphabetLowered[index]) {
                            index++;
                        }
                    }
                    index -= shift;
                    while (index < 0) {
                        index += AMOUNT_OF_LETTERS;
                    }
                    charsToEncrypt[i] = alphabetLowered[index];

                } else if (Character.isUpperCase(charsToEncrypt[i])) {
                    for (int j = 0; j < alphabetUpper.length; j++) {
                        if (charsToEncrypt[i] != alphabetUpper[index]) {
                            index++;
                        }
                    }
                    index -= shift;
                    while (index < 0) {
                        index += AMOUNT_OF_LETTERS;
                    }
                    charsToEncrypt[i] = alphabetUpper[index];
                }
            }
        }

        StringBuilder decryptedString = new StringBuilder();
        for (char c : charsToEncrypt) {
            decryptedString.append(c);

        }


        return decryptedString.toString();
    }


}
