package com.musashisan.delaunay.triangulation;

import lombok.Getter;

@Getter
public class Edge {

    private final Point a;

    private final Point b;

    public Edge(Point a, Point b) {
        this.a = a;
        this.b = b;
    }
}
