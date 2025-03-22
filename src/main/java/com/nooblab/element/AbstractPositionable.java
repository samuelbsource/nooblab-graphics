package com.nooblab.element;

public abstract class AbstractPositionable extends AbstractElement implements Positionable {

    private int x;
    private int y;

    public AbstractPositionable() {
        this.x = 0;
        this.y = 0;
    }

    public AbstractPositionable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
