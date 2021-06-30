package com.musashisan.delaunay.triangulation;

import lombok.Data;

import java.util.List;

@Data
public class Mesh {

    private List<Point> points;

    private List<Edge> edges;

    private List<Triangle> triangles;
}
