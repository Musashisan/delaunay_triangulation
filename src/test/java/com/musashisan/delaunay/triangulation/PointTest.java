package com.musashisan.delaunay.triangulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest
{
    @Test
    void pointsAreCollinear()
    {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(2, 0);

        int counterClockWise = a.isCounterClockWise(b, c);

        assertThat(counterClockWise).isEqualTo(0);
    }

    @Test
    void pointsAreClockWise()
    {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(2, 0);

        int clockWise = a.isCounterClockWise(b, c);

        assertThat(clockWise).isEqualTo(-1);
    }

    @Test
    void pointsAreCounterClockWise()
    {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 1);

        int counterClockWise = a.isCounterClockWise(b, c);

        assertThat(counterClockWise).isEqualTo(1);
    }
}
