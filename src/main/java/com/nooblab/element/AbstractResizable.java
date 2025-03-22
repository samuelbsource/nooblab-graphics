package com.nooblab.element;

public abstract class AbstractResizable extends AbstractPositionable implements Resizable {

    private int width;
    private int height;

    public AbstractResizable() {
        super();
        this.width = 0;
        this.height = 0;
    }

    public AbstractResizable(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
}
