package com.musashisan.delaunay.triangulation;

import lombok.Data;

import java.util.List;

@Data
public class Triangle {

    private List<Edge> edges;

    private List<Point> points;
}
