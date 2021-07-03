package com.musashisan.delaunay.triangulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EdgeTest {
    /**
     * Point a, Edge b->c.
     *
     *        * c
     *       / \
     *      /   \
     *   a * --- * b
     */
    @Test
    void point_is_at_the_left_of_the_edge_then_left_returns_true()
    {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 1);

        Edge edge = new Edge(b, c);

        boolean result = edge.pointIsLeft(a);

        assertThat(result).isTrue();
    }

    /**
     * Point a, Edge b->c.
     *
     *        * c
     *       / \
     *      /   \
     *   b * --- * a
     */
    @Test
    void point_is_at_the_right_of_the_edge_then_left_returns_false()
    {
        Point b = new Point(0, 0);
        Point a = new Point(2, 0);
        Point c = new Point(1, 1);

        Edge edge = new Edge(b, c);

        boolean result = edge.pointIsLeft(a);

        assertThat(result).isFalse();
    }

    /**
     * Point a, Edge b->c.
     *
     *   a * --- * b ---- * c
     */
    @Test
    void point_is_collinear_then_left_returns_false()
    {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(2, 0);

        Edge edge = new Edge(b, c);

        boolean result = edge.pointIsLeft(a);

        assertThat(result).isFalse();
    }

    /**
     * Point a, Edge b->c.
     *
     *        * c
     *       / \
     *      /   \
     *   b * --- * a
     */
    @Test
    void point_is_at_the_right_of_the_edge_then_right_returns_true()
    {
        Point b = new Point(0, 0);
        Point a = new Point(2, 0);
        Point c = new Point(1, 1);

        Edge edge = new Edge(b, c);

        boolean result = edge.pointIsRight(a);

        assertThat(result).isTrue();
    }

    /**
     * Point a, Edge b->c
     *
     *        * c
     *       / \
     *      /   \
     *   a * --- * b
     */
    @Test
    void point_is_at_the_left_of_the_edge_then_right_returns_false()
    {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        Point c = new Point(1, 1);

        Edge edge = new Edge(b, c);

        boolean result = edge.pointIsRight(a);

        assertThat(result).isFalse();
    }

    /**
     * Point a, Edge b->c.
     *
     *   a * --- * b ---- * c
     */
    @Test
    void point_is_collinear_then_right_returns_false()
    {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(2, 0);

        Edge edge = new Edge(b, c);

        boolean result = edge.pointIsRight(a);

        assertThat(result).isFalse();
    }

}
