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

    @Override
    public String toString() {
        return "Point{x=" + x + ", y=" + y + '}';
    }

    // is a(self)->b->c a counter-clockwise turn?
    // 1 if counter-clockwise, -1 if clockwise, 0 if collinear
    public int isCounterClockWise(Point b, Point c) {
        double twiceEnclosedArea = (b.getX() - this.x) * (c.getY() - this.y) - (c.getX() - this.x) * (b.getY() - this.y);
        if (twiceEnclosedArea < 0) return -1;
        else if (twiceEnclosedArea > 0) return 1;
        else return 0;
    }
}
