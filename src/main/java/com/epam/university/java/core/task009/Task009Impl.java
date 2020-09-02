package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Task009Impl implements Task009 {


    @Override
    public Collection<String> countWords(File sourceFile) {

        if (sourceFile == null) {
            throw new IllegalArgumentException();
        }

        Pattern pattern =
                Pattern.compile("[a-zA-Z]+(?:'[a-zA-Z]+)*+(?:-[a-zA-Z]+)*",
                        Pattern.UNICODE_CHARACTER_CLASS
                        | Pattern.CASE_INSENSITIVE);

        List<String> fromSourceFile = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(sourceFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                fromSourceFile.add(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        TreeSet<String> words = new TreeSet<>();

        Matcher matcher = pattern.matcher(fromSourceFile.toString());

        while (matcher.find()) {
            words.add(matcher.group().toLowerCase());
        }

        return words;
    }
}
