package com.nooblab.element;

import com.nooblab.adapter.GraphicsAdapter;

public class Polygon extends AbstractElement {
    
    private int[] xPoints;
    private int[] yPoints;
    private String color;
    private String strokeColor;
    private int strokeWidth;

    public Polygon(int[] xPoints, int[] yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.color = "black";
        this.strokeColor = "black";
        this.strokeWidth = 0;
    }

    public Polygon(int[] xPoints, int[] yPoints, String color, String strokeColor, int strokeWidth) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.color = color == null ? "black" : color;
        this.strokeColor = strokeColor == null ? "black" : strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public int[] getXPoints() {
        return xPoints;
    }

    public int[] getYPoints() {
        return yPoints;
    }

    public void setPoints(int[] xPoints, int[] yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
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
    protected void drawElement(GraphicsAdapter graphicsAdapter) {
        graphicsAdapter.setFill(color);
        graphicsAdapter.fillPolygon(xPoints, yPoints, xPoints.length);

        if (strokeWidth > 0) {
            graphicsAdapter.setStroke(strokeColor);
            graphicsAdapter.setLineWidth(strokeWidth);
            graphicsAdapter.strokePolygon(xPoints, yPoints, xPoints.length);
        }
    }
}
