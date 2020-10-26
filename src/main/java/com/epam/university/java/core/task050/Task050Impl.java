package com.epam.university.java.core.task050;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task050Impl implements Task050 {
    @Override
    public double calculate(int size, Map<Double, Double> items) {
        if (size == 0 || items == null) {
            throw new IllegalArgumentException();
        }

        List<Double> prices = items.entrySet().stream().sorted(
                new Comparator<>() {
                    @Override
                    public int compare(Map.Entry<Double, Double> o1,
                                       Map.Entry<Double, Double> o2) {
                        return Double.compare(o2.getKey() / o2.getValue(),
                                o1.getKey() / o1.getValue());
                    }
                }).map(Map.Entry::getKey).collect(Collectors.toList());

        double maxCost = 0;

        for (Double price : prices) {
            double weight = items.get(price);
            size -= weight;
            maxCost += price;

            if (size == 0) {
                break;
            }

            if (size < 0) {
                maxCost -= price;
                size += weight;
                maxCost += (size / weight) * price;
                break;
            }
        }
        return Math.round(maxCost * 1000) / 1000d;
    }
}
