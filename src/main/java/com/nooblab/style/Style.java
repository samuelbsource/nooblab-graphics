package com.nooblab.style;

/**
 * Represents a CSS like style configuration.
 * <p>
 * This class stores various style properties, such as color, text alignment,
 * font attributes, and text decorations. It allows setting and retrieving
 * these properties to be applied in a graphical rendering context.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public class Style {
    
    private String color;
    private String textAlign;
    private String fontFamily;
    private String fontSize;
    private String fontWeight;
    private String fontStyle;

    /**
     * Creates a new {@code Style} instance with default values set to {@code null}.
     */
    public Style() {
        this.color = null;
        this.textAlign = null;
        this.fontFamily = null;
        this.fontSize = null;
        this.fontWeight = null;
        this.fontStyle = null;
    }

    /**
     * Gets the text color.
     *
     * @return The text color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the text color.
     *
     * @param color The new text color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the text alignment.
     *
     * @return The text alignment.
     */
    public String getTextAlign() {
        return textAlign;
    }

    /**
     * Sets the text alignment.
     *
     * @param textAlign The new text alignment (e.g., "left", "center", "right").
     */
    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    /**
     * Gets the font family.
     *
     * @return The font family.
     */
    public String getFontFamily() {
        return fontFamily;
    }

    /**
     * Sets the font family.
     *
     * @param fontFamily The new font family.
     */
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    /**
     * Gets the font size.
     *
     * @return The font size.
     */
    public String getFontSize() {
        return fontSize;
    }

    /**
     * Sets the font size.
     *
     * @param fontSize The new font size.
     */
    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * Gets the font weight.
     *
     * @return The font weight.
     */
    public String getFontWeight() {
        return fontWeight;
    }

    /**
     * Sets the font weight.
     *
     * @param fontWeight The new font weight (e.g., "normal", "bold", "lighter", or numeric values like "400").
     */
    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }

    /**
     * Gets the font style.
     *
     * @return The font style.
     */
    public String getFontStyle() {
        return fontStyle;
    }

    /**
     * Sets the font style.
     *
     * @param fontStyle The new font style (e.g., "normal", "italic").
     */
    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }
}
