package com.nooblab.element;

import java.util.UUID;

import com.nooblab.adapter.GraphicsAdapter;

/**
 * An abstract base class for graphical elements.
 * <p>
 * This class provides a common structure for elements that can be drawn
 * using a {@link GraphicsAdapter}. Each element has a unique ID and
 * visibility control.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public abstract class AbstractElement implements Element {

    private String id;
    private boolean visible;

    /**
     * Constructs an {@code AbstractElement} with a unique ID and default visibility set to {@code true}.
     */
    public AbstractElement() {
        this.id = UUID.randomUUID().toString();
        this.visible = true;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void show() {
        this.visible = true;
    }

    @Override
    public void hide() {
        this.visible = false;
    }

    @Override
    public void toggle() {
        this.visible = !this.visible;
    }

    @Override
    public final void draw(GraphicsAdapter graphicsAdapter) {
        if (this.visible) {
            graphicsAdapter.resetState();
            this.drawElement(graphicsAdapter);
        }
    }

    /**
     * Draws the specific element using the given {@link GraphicsAdapter}.
     * <p>
     * This method is called internally by {@link #draw(GraphicsAdapter)} only if the element is visible.
     * Subclasses must implement this method to define their own rendering logic.
     * </p>
     *
     * @param graphicsAdapter The graphics adapter used to render the element.
     */
    protected abstract void drawElement(GraphicsAdapter graphicsAdapter);
}
