package com.musashisan.delaunay.triangulation;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Triangle {

    private List<Edge> edges = new ArrayList<>();

    private List<Point> points = new ArrayList<>();

    // counter-clockwise triangle
    public Triangle(Point a, Point b, Point c) {
        this.points.add(a);
        this.points.add(b);
        this.points.add(c);
        Orientation orientation = a.getOrientation(b, c);
        switch (orientation) {
            case COLLINEAR:
                this.edges.add(new Edge(a, b));
                this.edges.add(new Edge(b, c));
                return;
            case COUNTERCLOCKWISE:
                this.edges.add(new Edge(a, b));
                this.edges.add(new Edge(b, c));
                this.edges.add(new Edge(c, a));
                return;
            case CLOCKWISE:
                this.edges.add(new Edge(a, c));
                this.edges.add(new Edge(c, b));
                this.edges.add(new Edge(b, a));
        }
    }
}
