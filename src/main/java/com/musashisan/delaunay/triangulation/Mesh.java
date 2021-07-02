package com.musashisan.delaunay.triangulation;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Mesh {

    private List<Point> points = new ArrayList<>();

    private List<Edge> edges = new ArrayList<>();

    private List<Triangle> triangles = new ArrayList<>();
}
