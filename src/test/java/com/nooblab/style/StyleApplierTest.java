package com.nooblab.style;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nooblab.adapter.GraphicsAdapter;

/**
 * Unit tests for the {@link StyleApplier} class.
 * <p>
 * This test suite verifies that styles are correctly applied to a {@link GraphicsAdapter}.
 * Uses a mock implementation of {@link GraphicsAdapter} to ensure proper method calls.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public final class StyleApplierTest {

    private GraphicsAdapter mockAdapter;
    private Style style;

    @BeforeEach
    void setUp() {
        mockAdapter = mock(GraphicsAdapter.class);
        style = new Style();
    }

    /**
     * Tests applying a style with all properties set.
     */
    @Test
    public void testApplyFullStyle() {
        style.setColor("red");
        style.setTextAlign("center");
        style.setFontFamily("Arial");
        style.setFontSize("16px");
        style.setFontWeight("bold");
        style.setFontStyle("italic");

        StyleApplier.applyStyle(mockAdapter, style);

        verify(mockAdapter).setFill("red");
        verify(mockAdapter).setFontFamily("Arial");
        verify(mockAdapter).setFontSize(16);
        verify(mockAdapter).setFontWeight(any());
        verify(mockAdapter).setFontStyle(any());
    }

    /**
     * Tests applying a font size without px specified.
     */
    @Test
    public void testApplySizeWithoutScale() {
        style.setFontSize("16px");

        StyleApplier.applyStyle(mockAdapter, style);

        verify(mockAdapter).setFontSize(16);
    }

    /**
     * Tests applying a font size with invalid scale.
     */
    @Test
    public void testApplySizeWithInvalidScale() {
        style.setFontSize("16rem");

        assertThrows(NumberFormatException.class, () -> {
            StyleApplier.applyStyle(mockAdapter, style);
        });
    }

    /**
     * Tests applying a style with no properties set (should not invoke any methods on adapter).
     */
    @Test
    public void testApplyEmptyStyle() {
        StyleApplier.applyStyle(mockAdapter, style);
        verify(mockAdapter, never()).setFill(any());
        verify(mockAdapter, never()).setFontFamily(any());
        verify(mockAdapter, never()).setFontSize(anyInt());
        verify(mockAdapter, never()).setFontWeight(any());
        verify(mockAdapter, never()).setFontStyle(any());
    }

    /**
     * Tests applying a null style should throw an exception.
     */
    @Test
    public void testApplyNullStyle() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            StyleApplier.applyStyle(mockAdapter, null);
        });
        assertEquals("GraphicsAdapter and Style must not be null.", exception.getMessage());
    }

    /**
     * Tests applying a null adapter should throw an exception.
     */
    @Test
    public void testApplyNullAdapter() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            StyleApplier.applyStyle(null, style);
        });
        assertEquals("GraphicsAdapter and Style must not be null.", exception.getMessage());
    }
}
