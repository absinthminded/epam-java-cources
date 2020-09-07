package com.epam.university.java.core.task012;

import java.util.Collection;

public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (sourceGraph == null || actions == null || actions.size() == 0) {
            throw new IllegalArgumentException();
        }
        for (GraphAction a : actions) {
            a.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        if (graph == null) {
            throw new IllegalArgumentException();
        }

        if (graph.edgeExists(from, to)) {
            return true;
        }

        Collection<Integer> edgesList = graph.getAdjacent(from);

        if (edgesList.size() == 0) {
            return false;
        }

        for (Integer edge : edgesList) {
            graph.removeEdge(from, edge);

            if (pathExists(graph, edge, to)) {
                return true;
            } else {
                graph.createEdge(from, edge);
                return false;
            }
        }

        return false;
    }
}
