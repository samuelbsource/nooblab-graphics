package com.nooblab.style;

import com.nooblab.adapter.GraphicsAdapter;
import com.nooblab.text.FontStyle;
import com.nooblab.text.FontWeight;
import com.nooblab.text.TextAlign;

/**
 * Utility class for applying {@link Style} to a {@link GraphicsAdapter}.
 * <p>
 * This class provides a way to configure a graphics adapter using a familiar
 * interface similar to CSS stylesheets.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public final class StyleApplier {

    /**
     * Private constructor to prevent instantiation.
     */
    private StyleApplier() {
        // Utility class; should not be instantiated.
    }

    /**
     * Applies the given {@link Style} to the specified {@link GraphicsAdapter}.
     * <p>
     * This method updates the adapter's properties based on the provided style.
     * </p>
     *
     * @param adapter The graphics adapter to which the style will be applied.
     * @param style   The style containing the settings to be applied.
     * @throws NullPointerException  if either {@code adapter} or {@code style} is {@code null}.
     * @throws NumberFormatException if {@code style.getFontSize()} contains an invalid number format.
     */
    public static void applyStyle(GraphicsAdapter adapter, Style style) {
        if (adapter == null || style == null) {
            throw new NullPointerException("GraphicsAdapter and Style must not be null.");
        }

        if (style.getColor() != null) {
            adapter.setFill(style.getColor());
        }
        if (style.getTextAlign() != null) {
            adapter.setTextAlign(TextAlign.fromValue(style.getTextAlign()));
        }
        if (style.getFontFamily() != null) {
            adapter.setFontFamily(style.getFontFamily());
        }
        if (style.getFontSize() != null) {
            adapter.setFontSize(getFontSize(style.getFontSize()));
        }
        if (style.getFontWeight() != null) {
            adapter.setFontWeight(FontWeight.fromValue(style.getFontWeight()));
        }
        if (style.getFontStyle() != null) {
            adapter.setFontStyle(FontStyle.fromValue(style.getFontStyle()));
        }
    }

    /**
     * Parses a font size value from a CSS-like string format.
     * <p>
     * This method supports pixel values ("px") and percentage values ("%"), where
     * percentages are calculated as a fraction of 16px. If no unit is provided,
     * pixels are assumed. Other units will cause an exception.
     * </p>
     *
     * @param fontSize The font size value as a string.
     * @return The parsed font size as an integer.
     * @throws NumberFormatException if the font size is not a valid number.
     */
    private static int getFontSize(String fontSize) {
        String trimmedSize = fontSize.trim().toLowerCase();

        if (trimmedSize.endsWith("px")) {
            trimmedSize = trimmedSize.substring(0, trimmedSize.length() - 2).trim();
            return Integer.parseInt(trimmedSize, 10);
        }
        
        if (trimmedSize.endsWith("%")) {
            trimmedSize = trimmedSize.substring(0, trimmedSize.length() - 1).trim();
            double percentage = Double.parseDouble(trimmedSize) / 100.0;
            return (int) Math.round(percentage * 16);
        }

        return Integer.parseInt(trimmedSize, 10);
    }
}
