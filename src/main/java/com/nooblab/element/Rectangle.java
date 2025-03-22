package com.nooblab.element;

import com.nooblab.adapter.GraphicsAdapter;

public class Rectangle extends AbstractResizable {

    private String fillColor;
    private String strokeColor;
    private int strokeWidth;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.fillColor = "black";
        this.strokeColor = "black";
        this.strokeWidth = 0;
    }

    public Rectangle(int x, int y, int width, int height, String fillColor, String strokeColor, int strokeWidth) {
        super(x, y, width, height);
        this.fillColor = fillColor == null ? "black" : fillColor;
        this.strokeColor = strokeColor == null ? "black" : strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
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
        graphicsAdapter.setFill(fillColor);
        graphicsAdapter.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if (this.strokeWidth > 0) {
            graphicsAdapter.setStroke(strokeColor);
            graphicsAdapter.setLineWidth(strokeWidth);
            graphicsAdapter.strokeRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        }
    }
}