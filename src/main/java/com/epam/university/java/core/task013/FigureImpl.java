package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FigureImpl implements Figure {
    private List<Vertex> vertices;
    private int vertexCount;

    public FigureImpl(int vertexCount) {
        vertices = new ArrayList<>();
        this.vertexCount = vertexCount;
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (vertices.size() < vertexCount) {
            vertices.add(vertex);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Collection<Vertex> getVertexes() {

        return vertices;
    }
}
