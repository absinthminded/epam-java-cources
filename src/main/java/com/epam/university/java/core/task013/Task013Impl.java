package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        if (figure == null || actions == null || actions.size() == 0) {
            throw new IllegalArgumentException();
        }
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        if (figure == null) {
            throw new IllegalArgumentException();
        }

        int countOfVertices = figure.getVertexes().size();
        int firstCrossProduct = 0;

        List<Vertex> vertices = (List<Vertex>) figure.getVertexes();

        Vertex startVertex = vertices.stream()
                .min(Comparator.comparing(Vertex::getX))
                .get();

        vertices.sort(new SortVertices(startVertex.getX(), startVertex.getY()));

        for (int i = 0; i < countOfVertices; i++) {
            Vertex one = vertices.get(i);
            Vertex two = vertices.get((i + 1) % countOfVertices);
            Vertex three = vertices.get((i + 2) % countOfVertices);

            Vertex firstVector = new VertexImpl(two.getX() - one.getX(),
                                                two.getY() - one.getY());
            Vertex secondVector = new VertexImpl(three.getX() - two.getX(),
                                                three.getY() - two.getY());

            if (i == 0) {
                firstCrossProduct = firstVector.getX() * secondVector.getY()
                                    - secondVector.getX() * firstVector.getY();
            } else {
                int currentCrossProduct = firstVector.getX() * secondVector.getY()
                                        - secondVector.getX() * firstVector.getY();
                if (currentCrossProduct * firstCrossProduct < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static class SortVertices implements Comparator<Vertex> {
        private final int x;
        private final int y;

        public SortVertices(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compare(Vertex first, Vertex second) {
            if (first.getX() - x == 0 && first.getY() - y == 0) {
                return -1;
            }
            if (second.getX() - x == 0 && second.getY() - y == 0) {
                return 1;
            }
            double firstTangent = (double) (first.getY() - y) / (double) (first.getX() - x);
            double secondTangent = (double) (second.getY() - y) / (double) (second.getX() - x);
            if (firstTangent > secondTangent) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
