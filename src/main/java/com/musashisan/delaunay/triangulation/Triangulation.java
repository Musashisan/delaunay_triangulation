package com.musashisan.delaunay.triangulation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Triangulation {
    public Mesh calculate(List<Point> points) {
        List<Point> sortedPoints = points.stream()
                .sorted(Comparator.comparing(Point::getX).thenComparing(Point::getY))
                .collect(Collectors.toCollection(ArrayList::new));

        Mesh mesh = this.triangulate(sortedPoints);
        //mesh.setPoints(sortedPoints);
        return mesh;
    }

    private Mesh triangulate(List<Point> sortedPoints) {
        int size = sortedPoints.size();
        if (size > 3) {
            Mesh leftMesh = this.triangulate(sortedPoints.subList(0, size / 2 - 1));
            Mesh rightMesh = this.triangulate(sortedPoints.subList(size / 2, size - 1));
            return this.merge(leftMesh, rightMesh);
        }
        return this.initialMesh(sortedPoints);
    }

    private Mesh initialMesh(List<Point> sortedPoints) {
        Mesh mesh = new Mesh();
        List<Point> points = new ArrayList<>();
        mesh.setPoints(points);
        points.addAll(sortedPoints);
        return mesh;
    }

    private Mesh merge(Mesh leftMesh, Mesh rightMesh) {
        Mesh mesh = new Mesh();
        List<Point> points = new ArrayList<>();
        mesh.setPoints(points);
        points.addAll(leftMesh.getPoints());
        points.addAll(rightMesh.getPoints());

        return mesh;
    }
}
