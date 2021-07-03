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

    /**
     * Calculate the orientation of the triangle a(self)->b->c.
     *
     * @param b The second point
     * @param c The 3rd point
     * @return The current orientation of sequence a->b->c
     */
    public Orientation getOrientation(Point b, Point c) {
        double twiceEnclosedArea = (b.getX() - this.x) * (c.getY() - this.y) - (c.getX() - this.x) * (b.getY() - this.y);
        if (twiceEnclosedArea < 0) return Orientation.CLOCKWISE;
        else if (twiceEnclosedArea > 0) return Orientation.COUNTERCLOCKWISE;
        else return Orientation.COLLINEAR;
    }
}
