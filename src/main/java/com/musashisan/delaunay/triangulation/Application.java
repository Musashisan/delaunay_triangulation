package com.musashisan.delaunay.triangulation;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Application extends PApplet {

    int numberOfPoints = 12;
    Triangulation triangulation = new Triangulation();
    Mesh mesh;

    public static void main(String[] args) {
        PApplet.main("com.musashisan.delaunay.triangulation.Application");
    }

    @Override
    public void settings() {
        this.size(640, 360, P2D);
    }

    @Override
    public void setup() {
        background(0.0F);
        stroke(255);

        List<Point> points = this.generateRandomPoints(numberOfPoints);
        this.mesh = this.triangulation.calculate(points);
    }

    @Override
    public void draw() {
        this.mesh.getPoints().forEach(p -> point(p.getX(), p.getY()));
    }

    @Override
    public void keyPressed() {
        if (key == ' ') {
            this.setup();
        }
    }

    private List<Point> generateRandomPoints(int numberOfPoints) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < numberOfPoints; i++) {
            points.add(new Point(random(width), random(height)));
        }
        return points;
    }
}
