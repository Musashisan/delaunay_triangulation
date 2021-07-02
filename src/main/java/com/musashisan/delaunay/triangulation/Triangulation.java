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

        return this.triangulate(sortedPoints);
    }

    private Mesh triangulate(List<Point> sortedPoints) {
        int size = sortedPoints.size();
        if (size > 3) {
            Mesh leftMesh = this.triangulate(sortedPoints.subList(0, size / 2));
            Mesh rightMesh = this.triangulate(sortedPoints.subList(size / 2, size));
            return this.merge(leftMesh, rightMesh);
        }
        return this.initialMesh(sortedPoints);
    }

    private Mesh initialMesh(List<Point> sortedPoints) {
        Mesh mesh = new Mesh();
        mesh.getPoints().addAll(sortedPoints);
        if (sortedPoints.size() == 2) {
            mesh.getEdges().add(new Edge(sortedPoints.get(0), sortedPoints.get(1)));
        } else {
            Triangle triangle = new Triangle(sortedPoints.get(0), sortedPoints.get(1), sortedPoints.get(2));
            mesh.getEdges().addAll(triangle.getEdges());
            mesh.getTriangles().add(triangle);
        }
        return mesh;
    }

    private Mesh merge(Mesh leftMesh, Mesh rightMesh) {
        Mesh mesh = new Mesh();
        mesh.getPoints().addAll(leftMesh.getPoints());
        mesh.getPoints().addAll(rightMesh.getPoints());

        mesh.getEdges().addAll(leftMesh.getEdges());
        mesh.getEdges().addAll(rightMesh.getEdges());

        mesh.getTriangles().addAll(leftMesh.getTriangles());
        mesh.getTriangles().addAll(rightMesh.getTriangles());

        return mesh;
    }
}
