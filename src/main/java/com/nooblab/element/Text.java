package com.nooblab.element;

import com.nooblab.adapter.GraphicsAdapter;
import com.nooblab.style.Style;
import com.nooblab.style.StyleApplier;
import com.nooblab.style.StyleParser;

public class Text extends AbstractPositionable {
    
    private String text;
    private Style style;

    public Text(int x, int y, String text) {
        super(x, y);
        this.text = text;
        this.style = new Style();
    }

    public Text(int x, int y, String text, String style) {
        super(x, y);
        this.text = text;
        this.style = StyleParser.parse(style);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = StyleParser.parse(style);
    }

    @Override
    protected void drawElement(GraphicsAdapter graphicsAdapter) {
        StyleApplier.applyStyle(graphicsAdapter, style);
        graphicsAdapter.fillText(getX(), getY(), text);
    }
}
