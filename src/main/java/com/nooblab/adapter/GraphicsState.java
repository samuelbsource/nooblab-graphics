package com.nooblab.adapter;

import com.nooblab.text.FontStyle;
import com.nooblab.text.FontWeight;
import com.nooblab.text.TextAlign;

/**
 * Represents the state of a {@link GraphicsAdapter}.
 * <p>
 * This class stores the rendering attributes such as colors, line width, and font settings.
 * A saved state can be applied to a different adapter or used to restore a previous state.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public class GraphicsState {
    private String fillColor;
    private String strokeColor;
    private int lineWidth;
    private String fontFamily;
    private int fontSize;
    private FontWeight fontWeight;
    private FontStyle fontStyle;
    private TextAlign textAlign;

    /**
     * Creates a new {@code GraphicsState} with default values.
     * <p>
     * Default values:
     * <ul>
     *   <li>Fill color: black</li>
     *   <li>Stroke color: black</li>
     *   <li>Line width: 1.0</li>
     *   <li>Font family: Arial</li>
     *   <li>Font size: 12.0</li>
     *   <li>Font weight: NORMAL</li>
     *   <li>Font style: NORMAL</li>
     * </ul>
     * </p>
     */
    public GraphicsState() {
        this.fillColor = "black";
        this.strokeColor = "black";
        this.lineWidth = 0;
        this.fontFamily = "Arial";
        this.fontSize = 12;
        this.fontWeight = FontWeight.NORMAL;
        this.fontStyle = FontStyle.NORMAL;
        this.textAlign = TextAlign.LEFT;
    }

    /**
     * Gets the current fill color.
     *
     * @return the fill color as a string.
     */
    public String getFillColor() {
        return fillColor;
    }

    /**
     * Sets the fill color.
     *
     * @param fillColor The new fill color.
     */
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    /**
     * Gets the current stroke color.
     *
     * @return the stroke color as a string.
     */
    public String getStrokeColor() {
        return strokeColor;
    }

    /**
     * Sets the stroke color.
     *
     * @param strokeColor The new stroke color.
     */
    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    /**
     * Gets the current line width.
     *
     * @return the line width.
     */
    public int getLineWidth() {
        return lineWidth;
    }

    /**
     * Sets the line width.
     *
     * @param lineWidth The new line width.
     */
    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    /**
     * Gets the current font family.
     *
     * @return the font family name.
     */
    public String getFontFamily() {
        return fontFamily;
    }

    /**
     * Sets the font family.
     *
     * @param fontFamily The new font family name.
     */
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    /**
     * Gets the current font size.
     *
     * @return the font size.
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * Sets the font size.
     *
     * @param fontSize The new font size.
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * Gets the current font weight.
     *
     * @return the font weight.
     */
    public FontWeight getFontWeight() {
        return fontWeight;
    }

    /**
     * Sets the font weight.
     *
     * @param fontWeight The new font weight.
     */
    public void setFontWeight(FontWeight fontWeight) {
        this.fontWeight = fontWeight;
    }

    /**
     * Gets the current font style.
     *
     * @return the font style.
     */
    public FontStyle getFontStyle() {
        return fontStyle;
    }

    /**
     * Sets the font style.
     *
     * @param fontStyle The new font style.
     */
    public void setFontStyle(FontStyle fontStyle) {
        this.fontStyle = fontStyle;
    }

    /**
     * Gets the current text alignment.
     *
     * @return the text alignment.
     */
    public TextAlign getTextAlign() {
        return textAlign;
    }

    /**
     * Sets the text alignment.
     *
     * @param textAlign The new text alignment.
     */
    public void setTextAlign(TextAlign textAlign) {
        this.textAlign = textAlign;
    }

    /**
     * Clone this {@code GraphicsState} object.
     * 
     * @return a new {@code GraphicsState} object with the same attributes as this object.
     */
    public GraphicsState clone() {
        GraphicsState clone = new GraphicsState();
        clone.fillColor = this.fillColor;
        clone.strokeColor = this.strokeColor;
        clone.lineWidth = this.lineWidth;
        clone.fontFamily = this.fontFamily;
        clone.fontSize = this.fontSize;
        clone.fontWeight = this.fontWeight;
        clone.fontStyle = this.fontStyle;
        return clone;
    }

    /**
     * Apply the attributes of another {@code GraphicsState} object into this object.
     * <p>
     * The attributes of the other object will overwrite the attributes of this object.
     * </p>
     */
    public void apply(GraphicsState other) {
        this.fillColor = other.fillColor;
        this.strokeColor = other.strokeColor;
        this.lineWidth = other.lineWidth;
        this.fontFamily = other.fontFamily;
        this.fontSize = other.fontSize;
        this.fontWeight = other.fontWeight;
        this.fontStyle = other.fontStyle;
    }

    /**
     * Reset all attributes to their default values.
     * 
     * @see #GraphicsState()
     */
    public void reset() {
        this.fillColor = "black";
        this.strokeColor = "black";
        this.lineWidth = 0;
        this.fontFamily = "Arial";
        this.fontSize = 12;
        this.fontWeight = FontWeight.NORMAL;
        this.fontStyle = FontStyle.NORMAL;
    }
}
