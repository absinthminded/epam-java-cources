package com.epam.university.java.core.task012;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class GraphImpl implements Graph {

    private final Map<Integer, ArrayList<Integer>> map;

    public GraphImpl(Map<Integer, ArrayList<Integer>> map) {
        this.map = map;
    }


    @Override
    public void createEdge(int from, int to) {

        if (!map.containsKey(from) || !map.containsKey(to)) {
            throw new IllegalArgumentException();
        }

        map.get(from).add(to);
        map.get(to).add(from);

    }

    @Override
    public boolean edgeExists(int from, int to) {

        if (!map.containsKey(from) || !map.containsKey(to)) {
            throw new IllegalArgumentException();
        }

        return map.get(from).contains(to);
    }

    @Override
    public void removeEdge(int from, int to) {

        if (!map.containsKey(from) || !map.containsKey(to)) {
            throw new IllegalArgumentException();
        }

        map.get(from).remove(Integer.valueOf(to));
        map.get(to).remove(Integer.valueOf(from));

    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        if (!map.containsKey(from)) {
            throw new IllegalArgumentException();
        }
        return map.get(from);
    }
}
