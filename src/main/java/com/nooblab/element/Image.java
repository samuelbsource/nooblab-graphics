package com.nooblab.element;

import com.nooblab.adapter.GraphicsAdapter;

public class Image extends AbstractResizable {

    private byte[] data;
    private boolean invalidated;

    public Image(byte[] data, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
        invalidated = true;
    }

    @Override
    public void drawElement(GraphicsAdapter graphicsAdapter) {
        if (invalidated) {
            graphicsAdapter.purgeRasterImage(getId());
            invalidated = false;
        }
        graphicsAdapter.drawRasterImage(getId(), data, getX(), getY(), getWidth(), getHeight());
    }
}
