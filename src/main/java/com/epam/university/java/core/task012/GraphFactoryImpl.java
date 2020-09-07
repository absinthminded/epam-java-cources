package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphFactoryImpl implements GraphFactory {

    @Override
    public Graph newInstance(int vertexesCount) {
        if (vertexesCount == 0) {
            throw new IllegalArgumentException();
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < vertexesCount; i++) {
            map.put(i + 1, new ArrayList<>());
        }

        return new GraphImpl(map);
    }
}
