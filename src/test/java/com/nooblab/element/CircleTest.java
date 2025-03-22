package com.nooblab.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nooblab.adapter.GraphicsAdapter;

/**
 * Unit tests for the {@link Circle} class.
 * <p>
 * This test suite verifies that the circle's properties are correctly set
 * and that it properly interacts with the {@link GraphicsAdapter} when drawn.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public class CircleTest {

    private GraphicsAdapter mockAdapter;
    private Circle circle;

    @BeforeEach
    void setUp() {
        mockAdapter = mock(GraphicsAdapter.class);
        circle = new Circle(50, 50, 20);
    }

    /**
     * Tests setting and getting the radius.
     */
    @Test
    public void testSetAndGetRadius() {
        circle.setRadius(30);
        assertEquals(30, circle.getRadius());
    }

    /**
     * Tests setting and getting the fill color.
     */
    @Test
    public void testSetAndGetColor() {
        circle.setColor("red");
        assertEquals("red", circle.getColor());
    }

    /**
     * Tests setting and getting the stroke color.
     */
    @Test
    public void testSetAndGetStrokeColor() {
        circle.setStrokeColor("blue");
        assertEquals("blue", circle.getStrokeColor());
    }

    /**
     * Tests setting and getting the stroke width.
     */
    @Test
    public void testSetAndGetStrokeWidth() {
        circle.setStrokeWidth(5);
        assertEquals(5, circle.getStrokeWidth());
    }

    /**
     * Tests the draw method to ensure proper method calls on the {@link GraphicsAdapter}.
     */
    @Test
    public void testDraw() {
        circle.draw(mockAdapter);

        verify(mockAdapter).resetState();
        verify(mockAdapter).setFill("black");
        verify(mockAdapter).fillOval(30, 30, 40, 40);
        verify(mockAdapter, never()).setStroke(anyString());
        verify(mockAdapter, never()).setLineWidth(anyInt());
        verify(mockAdapter, never()).strokeOval(anyInt(), anyInt(), anyInt(), anyInt()); // Should never be called
    }

    /**
     * Tests the draw method when stroke width is greater than zero.
     */
    @Test
    public void testDrawWithStroke() {
        circle.setStrokeWidth(5);
        circle.draw(mockAdapter);

        verify(mockAdapter).resetState();
        verify(mockAdapter).setFill("black");
        verify(mockAdapter).setStroke("black");
        verify(mockAdapter).setLineWidth(5);
        verify(mockAdapter).fillOval(30, 30, 40, 40);
        verify(mockAdapter).strokeOval(30, 30, 40, 40); // Should be called
    }
}
