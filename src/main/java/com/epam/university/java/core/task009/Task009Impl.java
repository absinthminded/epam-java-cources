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

        Pattern pattern =
                Pattern.compile("[a-zA-Z]+(?:'[a-zA-Z]+)*+(?:-[a-zA-Z]+)*",
                        Pattern.UNICODE_CHARACTER_CLASS
                        | Pattern.CASE_INSENSITIVE);

        List<String> fromSourceFile = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(sourceFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fromSourceFile.add(data);
            }
            myReader.close();
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
