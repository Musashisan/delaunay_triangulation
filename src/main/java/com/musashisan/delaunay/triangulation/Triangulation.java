package com.musashisan.delaunay.triangulation;

import java.util.List;

public class Triangulation {
    public Mesh calculate(List<Point> points) {
        Mesh mesh = new Mesh();
        mesh.setPoints(points);
        return mesh;
    }
}
