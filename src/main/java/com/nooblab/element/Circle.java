package com.nooblab.element;

import com.nooblab.adapter.GraphicsAdapter;

public class Circle extends AbstractPositionable {

    private int radius;
    private String color;
    private String strokeColor;
    private int strokeWidth;

    public Circle(int x, int y, int r) {
        super(x, y);
        this.radius = r;
        this.color = "black";
        this.strokeColor = "black";
        this.strokeWidth = 0;
    }

    public Circle(int x, int y, int r, String color, String strokeColor, int strokeWidth) {
        super(x, y);
        this.radius = r;
        this.color = color == null ? "black" : color;
        this.strokeColor = strokeColor == null ? "black" : strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    @Override
    public void drawElement(GraphicsAdapter graphicsAdapter) {
        graphicsAdapter.setFill(color);
        graphicsAdapter.fillOval(this.getX() - radius, this.getY() - radius, radius * 2, radius * 2);

        if (strokeWidth > 0) {
            graphicsAdapter.setStroke(strokeColor);
            graphicsAdapter.setLineWidth(strokeWidth);
            graphicsAdapter.strokeOval(this.getX() - radius, this.getY() - radius, radius * 2, radius * 2);
        }
    }
}
