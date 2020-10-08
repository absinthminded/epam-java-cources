package com.epam.university.java.core.task011;


import java.util.ArrayList;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        if (collection == null || collection.length == 0) {
            throw new IllegalArgumentException();
        } else if (collection.length == 1) {
            return collection[0];
        }
        String lastMember;
        String[] newArray = new String[collection.length];

        for (int i = 0; i < collection.length - 1; i++) {
            if (i % 2 == 0) {
                newArray[i] = collection[i + 1];
            }
        }

        if (collection.length % 2 == 1) {
            lastMember = newArray[0];
        } else {
            lastMember = newArray[2];
        }

        return lastMember;
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        } else if (collection.size() == 1) {
            return collection.get(0);
        }

        int i = 0;
        int evenOrOdd = collection.size() % 2;

        while (i < collection.size()) {
            collection.remove(i);
            i++;
        }

        String lastMember;

        if (evenOrOdd == 1) {
            lastMember = collection.get(0);
        } else {
            lastMember = collection.get(1);
        }

        return lastMember;
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        } else if (collection.size() == 1) {
            return collection.get(0);
        }

        int i = 0;
        int evenOrOdd = collection.size() % 2;

        while (i < collection.size()) {
            collection.remove(i);
            i++;
        }

        String lastMember;

        if (evenOrOdd == 1) {
            lastMember = collection.get(0);
        } else {
            lastMember = collection.get(1);
        }

        return lastMember;
    }
}
