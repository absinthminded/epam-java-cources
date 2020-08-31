package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Scanner;


public class Task010Impl implements Task010 {

    @Override
    public Map<String, Integer> countWordNumbers(File source) {

        List<String> fromSourceFile = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(source);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (String word : line.toLowerCase().split("\\s")) {
                    if (!word.isEmpty()) {
                        fromSourceFile.add(word);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        Map<String, Integer> frequency = fromSourceFile.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        return frequency;

    }

}
