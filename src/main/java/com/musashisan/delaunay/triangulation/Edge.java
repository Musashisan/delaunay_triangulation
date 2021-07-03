package com.musashisan.delaunay.triangulation;

import lombok.Getter;

@Getter
public class Edge {

    private final Point origin;

    private final Point destination;

    public Edge(Point origin, Point destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public boolean pointIsLeft(Point p) {
        return p.getOrientation(origin, destination) == Orientation.COUNTERCLOCKWISE;
    }

    public boolean pointIsRight(Point p) {
        return p.getOrientation(origin, destination) == Orientation.CLOCKWISE;
    }
}
