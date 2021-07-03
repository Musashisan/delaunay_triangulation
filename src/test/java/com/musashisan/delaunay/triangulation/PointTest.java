package com.musashisan.delaunay.triangulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest
{
    @Test
    void points_are_collinear()
    {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(2, 0);

        Orientation orientation = a.getOrientation(b, c);

        assertThat(orientation).isEqualTo(Orientation.COLLINEAR);
    }

    @Test
    void points_are_clockWise()
    {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(2, 0);

        Orientation orientation = a.getOrientation(b, c);

        assertThat(orientation).isEqualTo(Orientation.CLOCKWISE);
    }

    @Test
    void points_are_counter_clockWise()
    {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 1);

        Orientation orientation = a.getOrientation(b, c);

        assertThat(orientation).isEqualTo(Orientation.COUNTERCLOCKWISE);
    }
}
