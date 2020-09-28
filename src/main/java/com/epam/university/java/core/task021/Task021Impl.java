package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task021Impl implements Task021 {
    @Override
    public Point calculate(Collection<Point> minePositions) {
        if (minePositions == null || minePositions.size() == 0) {
            throw new IllegalArgumentException();
        }

        List<Point> points = new ArrayList<>(minePositions);

        Point a = new PointImpl(points.get(0).getX(), points.get(0).getY());
        Point b = new PointImpl(points.get(1).getX(), points.get(1).getY());
        Point c = new PointImpl(points.get(2).getX(), points.get(2).getY());

        Point abEquilateralVertex = findEquilateralVertex(a, b, c);
        Point acEquilateralVertex = findEquilateralVertex(a, c, b);
        Point fermatPoint = findIntersection(acEquilateralVertex, b, abEquilateralVertex, c);


        return fermatPoint;
    }

    private static Point findEquilateralVertex(Point p1, Point p2, Point contrary) {
        double lengthOfEdge = dist(p1, p2);
        double heightOfEqTriangle = lengthOfEdge * Math.sqrt(3) / 2.0f;
        Point heightVectorDirection = new PointImpl(p1.getY() - p2.getY(), p2.getX() - p1.getX());
        normalize(heightVectorDirection);
        Point heightVector = ((PointImpl) heightVectorDirection).multiply(heightOfEqTriangle);
        Point startOfHeight = new PointImpl((p1.getX() + p2.getX()) / 2.0f, (p1.getY() + p2.getY()) / 2.0f);
        Point pp1 = ((PointImpl) startOfHeight).add(heightVector);
        Point pp2 = ((PointImpl) startOfHeight).subtract(heightVector);
        double d1 = dist(pp1, contrary);
        double d2 = dist(pp2, contrary);
        if (d1 < d2)
            return pp2;
        return pp1;
    }

    private static Point findIntersection(Point equilateralVertex1, Point contrary1, Point equilateralVertex2, Point contrary2) {
        double a1, a2, b1, b2;
        a1 = getA(equilateralVertex1, contrary1);
        a2 = getA(equilateralVertex2, contrary2);

        b1 = getB(contrary1, a1);
        b2 = getB(contrary2, a2);

        double x;
        double y;
        if (Double.isInfinite(a1)) {
            x = contrary1.getX();
            y = a2 * x + b2;
            return new PointImpl(x,y);
        }
        if (Double.isInfinite(a2)) {
            x = contrary2.getX();
            y = a1 * x + b1;
            return new PointImpl(x,y);
        }
        x = (b2 - b1) / (a1 - a2);
        y = a1 * x + b1;
        return new PointImpl(x, y);
    }

    private static double getB(Point p, double a) {
        return p.getY() - a * p.getX();
    }

    private static double getA(Point p1, Point p2) {
        return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
    }

    public static double dist(Point p1, Point p2) {
        return Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX())+(p1.getY()-p2.getY())*(p1.getY()-p2.getY()));
    }

    private static void normalize(Point heightVectorDirection) {
        double len = dist(new PointImpl(0, 0), heightVectorDirection);
        if (len > 0) {
             double heightVectorDirectionX = heightVectorDirection.getX();
             double heightVectorDirectionY = heightVectorDirection.getY();

            heightVectorDirection.setX(heightVectorDirectionX /= len);
            heightVectorDirection.setY(heightVectorDirectionY /= len);
        }
    }
}
