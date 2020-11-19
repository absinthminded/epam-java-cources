package com.epam.university.java.core.task022;

import java.util.Collection;


public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        validateParams(numbers);

        int[] arr = new int[numbers.size()];
        int index = 0;
        for (Integer number : numbers
        ) {
            arr[index] = number;
            index++;
        }

        int minElement = 0;
        int maxElement = 0;
        int sum = 0;

        minElement = arr[0];
        maxElement = minElement;
        sum = minElement;

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] < minElement) {
                minElement = arr[i];
            }
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }

        return sum - minElement;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        validateParams(numbers);

        int[] arr = new int[numbers.size()];
        int index = 0;
        for (Integer number : numbers
        ) {
            arr[index] = number;
            index++;
        }

        int minElement = 0;
        int maxElement = 0;
        int sum = 0;

        minElement = arr[0];
        maxElement = minElement;
        sum = minElement;

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] < minElement) {
                minElement = arr[i];
            }
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }

        return sum - maxElement;
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
