package com.epam.university.java.core.task038;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Task038Impl implements Task038 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction action: actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public Collection<Vertex> getShortestPath(Graph graph, int startId, int endId) {

        List<VertexImpl> vertices = ((GraphImpl)graph).getVertices();
        List<Integer> path = ((GraphImpl)graph).getMatrix().get(startId);

        Set<Vertex> shortestPath = new LinkedHashSet<>();

        shortestPath.add(vertices.stream()
                .filter(x -> startId == x.getId())
                .findFirst()
                .orElse(null));

        if (path.contains(endId)) {
            shortestPath.add(vertices.stream()
                    .filter(x -> endId == x.getId())
                    .findFirst()
                    .orElse(null));
            return shortestPath;
        }

        Set<Vertex> tempSet = new LinkedHashSet<>();

        if (path.isEmpty()) {
            return new LinkedHashSet<>();
        } else {
            for (Integer id : path) {
                tempSet.addAll(shortestPath);

                shortestPath.addAll(getShortestPath(graph, id, endId));

                if (shortestPath.contains(vertices.stream()
                                        .filter(x -> endId == x.getId())
                                        .findFirst()
                                        .orElse(null))) {
                    break;
                }
            }
        }

        if (tempSet.containsAll(shortestPath)) {
            shortestPath.remove(vertices.stream()
                    .filter(x -> startId == x.getId())
                    .findFirst()
                    .orElse(null));
        }

        return shortestPath;
    }
}
