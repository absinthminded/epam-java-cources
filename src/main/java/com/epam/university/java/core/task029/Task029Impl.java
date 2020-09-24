package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Task029Impl implements Task029 {
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        if (rows == null || words == null) {
            throw new IllegalArgumentException();
        }

        List<String> crossword = new ArrayList<>(rows);
        List<String> wordsToFill = new ArrayList<>(words);

        char[][] resultArray = new char[crossword.size()][crossword.get(0).length()];

        for (int i = 0; i < crossword.size(); i++) {
            for (int j = 0; j < crossword.get(0).length(); j++) {
                resultArray[i][j] = crossword.get(i).charAt(j);
            }
        }
        char[][] result = recur(resultArray, wordsToFill, 0);

        String[] resInString = new String[crossword.size()];

        for (int i = 0; i < result.length; i++) {
            resInString[i] = new String(result[i]);
        }

        return Arrays.asList(resInString);

    }

    private static boolean found = false;

    private static char[][] recur(char[][] crossword, List<String> words, int i) {

        if (i == words.size()) {
            found = true;
            return crossword;
        }

        for (int j = 0; j < crossword.length; j++) {

            for (int k = 0; k < crossword[j].length; k++) {

                if (crossword[j][k] == '+') {
                    continue;
                }

                boolean addToRow = canBeAddedToRow(words.get(i), crossword[j], k);

                if (addToRow) {
                    char[][] newCross = addToRow(words.get(i), crossword,j, k);
                    char[][] ifAddedToRow = recur(newCross, words, i + 1);

                    if (found) {
                        return ifAddedToRow;
                    }
                }

                boolean addToColumn = canBeAddedToCol(words.get(i), crossword, j, k);

                if (addToColumn) {
                    char[][] newCross = addToCol(words.get(i), crossword,j, k);

                    char[][] ifAddedToCol =  recur(newCross, words, i + 1);
                    if (found) {
                        return ifAddedToCol;
                    }
                }
            }
        }
        return crossword;
    }

    private static char[][] addToCol(String string, char[][] crossword, int j, int k) {
        char[][] nv = deepCopy(crossword);

        for (int i = 0; i < string.length(); i++) {
            nv[j + i][k] = string.charAt(i);
        }
        return nv;
    }

    private static char[][] addToRow(String string, char[][] crossword, int j, int k) {

        char[][] nv = deepCopy(crossword);

        for (int i = 0; i < string.length(); i++) {
            nv[j][k + i] = string.charAt(i);
        }
        return nv;
    }

    private static char[][] deepCopy(char[][] crossword) {
        char[][] nv = new char[crossword.length][crossword[0].length];
        for (int i = 0; i < nv.length; i++) {
            nv[i] = Arrays.copyOf(crossword[i], crossword[i].length);
        }
        return nv;
    }

    private static boolean canBeAddedToCol(String string, char[][] crossword, int j, int k) {
        int wordCounter = 0;
        for (int i = j; i < crossword.length; i++) {
            if (wordCounter == string.length()
                    || string.charAt(wordCounter) != crossword[i][k] && crossword[i][k] != '-') {
                break;
            }
            wordCounter++;
        }
        return (wordCounter == string.length());
    }

    private static boolean canBeAddedToRow(String string, char[] cs, int k) {
        int wordCounter = 0;
        for (int i = k; i < cs.length; i++) {
            if (wordCounter == string.length()
                    || string.charAt(wordCounter) != cs[i] && cs[i] != '-') {
                break;
            }
            wordCounter++;
        }
        return (wordCounter == string.length());

    }

}
