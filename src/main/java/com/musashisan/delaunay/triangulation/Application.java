package com.musashisan.delaunay.triangulation;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Application extends PApplet {

    int numberOfPoints = 12;
    List<PVector> points = new ArrayList<>();

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
        this.initPoints();
    }

    @Override
    public void draw() {
        points.forEach(p -> point(p.x, p.y));
    }

    @Override
    public void keyPressed() {
        if (key == ' ') {
            this.setup();
        }
    }

    private void initPoints() {
        points.clear();
        for (int i = 0; i < numberOfPoints; i++) {
            points.add(new PVector(random(width), random(height)));
        }
    }
}
