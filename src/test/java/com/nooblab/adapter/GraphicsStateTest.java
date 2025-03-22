package com.nooblab.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nooblab.text.FontStyle;
import com.nooblab.text.FontWeight;
import com.nooblab.text.TextAlign;

/**
 * Unit tests for the {@link GraphicsState} class.
 * <p>
 * This test suite verifies that setting and retrieving state properties
 * works as expected.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public final class GraphicsStateTest {

    /**
     * Tests setting and getting fill color.
     */
    @Test
    public void testFillColor() {
        GraphicsState state = new GraphicsState();
        state.setFillColor("blue");
        assertEquals("blue", state.getFillColor());
    }

    /**
     * Tests setting and getting stroke color.
     */
    @Test
    public void testStrokeColor() {
        GraphicsState state = new GraphicsState();
        state.setStrokeColor("red");
        assertEquals("red", state.getStrokeColor());
    }

    /**
     * Tests setting and getting line width.
     */
    @Test
    public void testLineWidth() {
        GraphicsState state = new GraphicsState();
        state.setLineWidth(2);
        assertEquals(2, state.getLineWidth());
    }

    /**
     * Tests setting and getting font family.
     */
    @Test
    public void testFontFamily() {
        GraphicsState state = new GraphicsState();
        state.setFontFamily("Arial");
        assertEquals("Arial", state.getFontFamily());
    }

    /**
     * Tests setting and getting font size.
     */
    @Test
    public void testFontSize() {
        GraphicsState state = new GraphicsState();
        state.setFontSize(16);
        assertEquals(16, state.getFontSize());
    }

    /**
     * Tests setting and getting font weight.
     */
    @Test
    public void testFontWeight() {
        GraphicsState state = new GraphicsState();
        state.setFontWeight(FontWeight.BOLD);
        assertEquals(FontWeight.BOLD, state.getFontWeight());
    }

    /**
     * Tests setting and getting font style.
     */
    @Test
    public void testFontStyle() {
        GraphicsState state = new GraphicsState();
        state.setFontStyle(FontStyle.ITALIC);
        assertEquals(FontStyle.ITALIC, state.getFontStyle());
    }

    /**
     * Tests setting and getting text alignment.
     */
    @Test
    public void testTextAlign() {
        GraphicsState state = new GraphicsState();
        state.setTextAlign(TextAlign.CENTER);
        assertEquals(TextAlign.CENTER, state.getTextAlign());
    }

    /**
     * Tests cloning the state object.
     */
    @Test
    public void testClone() {
        GraphicsState state = new GraphicsState();
        state.setFillColor("blue");
        state.setFontSize(16);
        GraphicsState clonedState = state.clone();
        assertEquals(state.getFillColor(), clonedState.getFillColor());
        assertEquals(state.getFontSize(), clonedState.getFontSize());
    }

    /**
     * Tests applying one GraphicsState to another.
     */
    @Test
    public void testApply() {
        GraphicsState source = new GraphicsState();
        source.setFillColor("blue");
        source.setFontSize(16);
        
        GraphicsState target = new GraphicsState();
        target.apply(source);
        
        assertEquals("blue", target.getFillColor());
        assertEquals(16, target.getFontSize());
    }

    /**
     * Tests resetting the state to default values.
     */
    @Test
    public void testReset() {
        GraphicsState state = new GraphicsState();
        state.setFillColor("blue");
        state.setFontSize(16);
        state.reset();
        
        assertEquals("black", state.getFillColor());
        assertEquals(12, state.getFontSize());
    }
}