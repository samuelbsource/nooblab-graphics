package com.nooblab.style;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Style} class.
 * <p>
 * This test suite verifies that setting and retrieving style properties
 * works as expected.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public final class StyleTest {

    /**
     * Tests setting and getting color.
     */
    @Test
    public void testColor() {
        Style style = new Style();
        style.setColor("blue");
        assertEquals("blue", style.getColor());
    }

    /**
     * Tests setting and getting text alignment.
     */
    @Test
    public void testTextAlign() {
        Style style = new Style();
        style.setTextAlign("center");
        assertEquals("center", style.getTextAlign());
    }

    /**
     * Tests setting and getting font family.
     */
    @Test
    public void testFontFamily() {
        Style style = new Style();
        style.setFontFamily("Arial");
        assertEquals("Arial", style.getFontFamily());
    }

    /**
     * Tests setting and getting font size.
     */
    @Test
    public void testFontSize() {
        Style style = new Style();
        style.setFontSize("16px");
        assertEquals("16px", style.getFontSize());
    }

    /**
     * Tests setting and getting font weight.
     */
    @Test
    public void testFontWeight() {
        Style style = new Style();
        style.setFontWeight("bold");
        assertEquals("bold", style.getFontWeight());
    }

    /**
     * Tests setting and getting font style.
     */
    @Test
    public void testFontStyle() {
        Style style = new Style();
        style.setFontStyle("italic");
        assertEquals("italic", style.getFontStyle());
    }
}
