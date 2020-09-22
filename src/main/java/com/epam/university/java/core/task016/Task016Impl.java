package com.epam.university.java.core.task016;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class Task016Impl implements Task016 {


    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius < 1) {
            throw new IllegalArgumentException();
        }

        Set<Coordinate> coordinates = new HashSet<>();
        int maxCoordinate = radius * 2 - 1;

        if (maxCoordinate - radius > 1) {
            coordinates.add(new CoordinateImpl(maxCoordinate - 1, maxCoordinate - 1));
        }

        for (int i = 1; i <= maxCoordinate; i++) {
            for (int j = 1; j <= radius; j++) {
                coordinates.add(new CoordinateImpl(i, j));
                coordinates.add(new CoordinateImpl(j, i));
            }
        }

        Set<Coordinate> result = new HashSet<>();

        for (Coordinate p : coordinates) {
            result.add(new CoordinateImpl(p.getX(), p.getY()));
            result.add(new CoordinateImpl(-p.getX(), p.getY()));
            result.add(new CoordinateImpl(-p.getX(), -p.getY()));
            result.add(new CoordinateImpl(p.getX(), -p.getY()));
        }

        return result;
    }
}
