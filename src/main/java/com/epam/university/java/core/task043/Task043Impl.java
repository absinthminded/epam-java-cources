package com.epam.university.java.core.task043;


import java.util.HashMap;
import java.util.Map;

public class Task043Impl implements Task043 {

    public static final Map<String, String> MorseCode;

    static {
        MorseCode = new HashMap<>();
        MorseCode.put("-.-.--", "!");
        MorseCode.put(".-..-.", "\"");
        MorseCode.put("...-..-", "$");
        MorseCode.put(".-...", "&");
        MorseCode.put(".----.", "'");
        MorseCode.put("-.--.", "(");
        MorseCode.put("-.--.-", ")");
        MorseCode.put(".-.-.", "+");
        MorseCode.put("--..--", ",");
        MorseCode.put("-....-", "-");
        MorseCode.put(".-.-.-", ".");
        MorseCode.put("-..-.", "/");
        MorseCode.put("-----", "0");
        MorseCode.put(".----", "1");
        MorseCode.put("..---", "2");
        MorseCode.put("...--", "3");
        MorseCode.put("....-", "4");
        MorseCode.put(".....", "5");
        MorseCode.put("-....", "6");
        MorseCode.put("--...", "7");
        MorseCode.put("---..", "8");
        MorseCode.put("----.", "9");
        MorseCode.put("---...", ":");
        MorseCode.put("-.-.-.", ";");
        MorseCode.put("-...-", "=");
        MorseCode.put("..--..", "?");
        MorseCode.put(".--.-.", "@");
        MorseCode.put(".-", "A");
        MorseCode.put("-...", "B");
        MorseCode.put("-.-.", "C");
        MorseCode.put("-..", "D");
        MorseCode.put(".", "E");
        MorseCode.put("..-.", "F");
        MorseCode.put("--.", "G");
        MorseCode.put("....", "H");
        MorseCode.put("..", "I");
        MorseCode.put(".---", "J");
        MorseCode.put("-.-", "K");
        MorseCode.put(".-..", "L");
        MorseCode.put("--", "M");
        MorseCode.put("-.", "N");
        MorseCode.put("---", "O");
        MorseCode.put(".--.", "P");
        MorseCode.put("--.-", "Q");
        MorseCode.put(".-.", "R");
        MorseCode.put("...", "S");
        MorseCode.put("-", "T");
        MorseCode.put("..-", "U");
        MorseCode.put("...-", "V");
        MorseCode.put(".--", "W");
        MorseCode.put("-..-", "X");
        MorseCode.put("-.--", "Y");
        MorseCode.put("--..", "Z");
        MorseCode.put("..--.-", "_");
        MorseCode.put("...---...", "SOS");
        MorseCode.put(" ", " ");
    }

    @Override
    public String encode(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        char[] sourceArray = sourceString.toUpperCase().toCharArray();
        StringBuilder str = new StringBuilder();

        for (Character s : sourceArray) {
            String letter = String.valueOf(s);
            for (Map.Entry<String, String> entry : MorseCode.entrySet()) {
                if (entry.getValue().equals(letter)) {
                    str.append(entry.getKey());
                    str.append(' ');
                }
            }
        }

        return str.toString().trim();
    }

    @Override
    public String decode(String sourceString) {

        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        String[] sourceArray = sourceString.split(" {2}");
        StringBuilder str = new StringBuilder();

        for (String s : sourceArray) {
            String[] letters = s.split(Character.toString(' '));
            for (String letter : letters) {
                str.append(MorseCode.get(letter));
            }
            str.append(' ');
        }

        return str.toString().trim().replaceAll("null", "");
    }

}

