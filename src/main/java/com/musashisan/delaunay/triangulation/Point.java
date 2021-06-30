package com.musashisan.delaunay.triangulation;

import lombok.Getter;

@Getter
public class Point {

    private final float x;
    private final float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
