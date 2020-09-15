package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.Collections;


public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        validateParams(numbers);
        int minVal = Collections.min(numbers);
        int maxSum = 0;

        for (Integer integer : numbers) {
            if (integer != minVal) {
                maxSum += integer;
            }
        }

        return maxSum;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        validateParams(numbers);
        int maxVal = Collections.max(numbers);
        int minSum = 0;

        for (Integer integer : numbers) {
            if (integer != maxVal) {
                minSum += integer;
            }
        }

        return minSum;
    }

    /**
     * Method to validate parameters.
     * @param numbers Collection of numbers to validate.
     */
    public void validateParams(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
