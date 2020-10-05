package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph {
    public Map<Integer, List<Integer>> getMatrix() {
        return matrix;
    }

    public List<VertexImpl> getVertices() {
        return vertices;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    private Map<Integer, List<Integer>> matrix;
    private List<VertexImpl> vertices;
    private int vertexCount;

    public GraphImpl(){}

    /**
     * Parameterized constructor.
     * @param vertexCount amount of vertices.
     */
    public GraphImpl(int vertexCount) {
        this.vertexCount = vertexCount;
        this.vertices = new ArrayList<>(vertexCount);
        this.matrix = new HashMap<>();
    }


    @Override
    public void createVertex(int id, int x, int y) {
        vertices.add(new VertexImpl(id, x, y));
        matrix.put(id, new ArrayList<>());
    }

    @Override
    public void connectVertices(int fromId, int toId) {
        matrix.get(fromId).add(toId);
    }


}
