package com.nooblab.element;

import com.nooblab.adapter.GraphicsAdapter;

public interface Element {
    String getId();
    
    void show();
    void hide();
    void toggle();

    void draw(GraphicsAdapter graphicsAdapter);
}
