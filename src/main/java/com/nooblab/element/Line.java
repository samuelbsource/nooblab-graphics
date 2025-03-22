package com.nooblab.element;

import com.nooblab.adapter.GraphicsAdapter;

public class Line extends AbstractPositionable {

    private int x2;
    private int y2;
    private String strokeColor;
    private int strokeWeight;

    public Line(int x, int y, int x2, int y2) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        this.strokeColor = "black";
        this.strokeWeight = 1;
    }

    public Line(int x, int y, int x2, int y2, String strokeColor, int strokeWeight) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        this.strokeColor = strokeColor == null ? "black" : strokeColor;
        this.strokeWeight = strokeWeight;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public String getstrokeColor() {
        return strokeColor;
    }

    public void setstrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getStrokeWeight() {
        return strokeWeight;
    }

    public void setStrokeWeight(int strokeWeight) {
        this.strokeWeight = strokeWeight;
    }

    @Override
    public void drawElement(GraphicsAdapter graphicsAdapter) {
        graphicsAdapter.setStroke(this.strokeColor);
        graphicsAdapter.setLineWidth(this.strokeWeight);
        graphicsAdapter.strokeLine(this.getX(), this.getY(), this.x2, this.y2);
    }
}
