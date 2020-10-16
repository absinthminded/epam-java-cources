package com.epam.university.java.core.task045;

public class Task045Impl implements Task045 {
    @Override
    public String doAnagram(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        } else if (input.length() == 1) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        String[] words = input.split(" ");
        for (String word : words) {
            sb.append(reverse(word));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * function for word reversion.
     * @param word a word to reverse.
     * @return reversed word.
     */
    public String reverse(String word) {

        char[] str = word.toCharArray();
        int r = str.length - 1;
        int l = 0;

        while (l < r) {
            if (!Character.isAlphabetic(str[l])) {
                l++;
            } else if (!Character.isAlphabetic(str[r])) {
                r--;
            } else {
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb1.append(str[i]);
        }
        return sb1.toString();
    }
}


