package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        } else if (sourceString.length() == 1 || (int) sourceString.charAt(0) == 0) {
            return new ArrayList<>();
        }

        List<Integer> toInspect = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            toInspect = splitEqually(sourceString, i);
            System.out.println(toInspect.toString());
            int toCompare = toInspect.get(i + 1)- 1;
            if (toInspect.get(i) == toCompare) {
                result = toInspect;
            } else {
                result = new ArrayList<>();
            }

            
        }


         return result;
    }

    public static List<Integer> splitEqually(String text, int size) {
        // Give the list the right capacity to start with. You could use an array
        // instead if you wanted.
        List<Integer> ret = new ArrayList<Integer>((text.length() + size - 1) / size);

        for (int start = 0; start < text.length(); start += size) {
            ret.add(Integer.valueOf(text.substring(start, Math.min(text.length(), start + size))));
        }
        System.out.println(ret.toString());

        return ret;
    }
}


