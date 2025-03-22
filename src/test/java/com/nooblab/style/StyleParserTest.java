package com.nooblab.style;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link StyleParser} class.
 * <p>
 * This test suite verifies the correct parsing of CSS-like style definitions
 * into {@link Style} objects.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public final class StyleParserTest {

    /**
     * Tests parsing of a valid style definition.
     * Ensures that only specified properties are set, and others remain null.
     */
    @Test
    public void testValidStyleParsing() {
        String styleDefinition = "color: red; font-size: 14px; font-weight: bold;";
        Style style = StyleParser.parse(styleDefinition);

        assertNotNull(style);
        assertEquals("red", style.getColor());
        assertEquals("14px", style.getFontSize());
        assertEquals("bold", style.getFontWeight());
        assertNull(style.getFontFamily());
        assertNull(style.getFontStyle());
        assertNull(style.getTextAlign());
    }

    /**
     * Tests parsing of an empty style definition.
     */
    @Test
    public void testEmptyStyleParsing() {
        Style style = StyleParser.parse("");
        assertNotNull(style);
        assertNull(style.getColor());
        assertNull(style.getFontSize());
        assertNull(style.getFontWeight());
        assertNull(style.getFontFamily());
        assertNull(style.getFontStyle());
        assertNull(style.getTextAlign());
    }

    /**
     * Tests parsing of a null style definition.
     */
    @Test
    public void testNullStyleParsing() {
        Style style = StyleParser.parse(null);
        assertNotNull(style);
        assertNull(style.getColor());
        assertNull(style.getFontSize());
        assertNull(style.getFontWeight());
        assertNull(style.getFontFamily());
        assertNull(style.getFontStyle());
        assertNull(style.getTextAlign());
    }

    /**
     * Tests parsing of a style definition with unknown properties.
     * Ensures that only recognized properties are set, and unknown ones are ignored.
     */
    @Test
    public void testUnknownProperties() {
        String styleDefinition = "unknown-property: value; color: blue;";
        Style style = StyleParser.parse(styleDefinition);

        assertNotNull(style);
        assertEquals("blue", style.getColor());
        assertNull(style.getFontSize());
        assertNull(style.getFontWeight());
        assertNull(style.getFontFamily());
        assertNull(style.getFontStyle());
        assertNull(style.getTextAlign());
    }

    /**
     * Tests that "colour" is correctly interpreted as "color".
     */
    @Test
    public void testBritishSpellingOfColor() {
        String styleDefinition = "colour: green;";
        Style style = StyleParser.parse(styleDefinition);

        assertNotNull(style);
        assertEquals("green", style.getColor());
        assertNull(style.getFontSize());
        assertNull(style.getFontWeight());
        assertNull(style.getFontFamily());
        assertNull(style.getFontStyle());
        assertNull(style.getTextAlign());
    }
}
