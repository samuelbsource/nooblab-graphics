package com.nooblab.text;

/**
 * Represents text alignment options for rendering text.
 * <p>
 * This enumeration defines standard alignment values that can be used to control
 * the horizontal positioning of text within a graphical rendering system.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public enum TextAlign {
    LEFT("left"),
    CENTER("center"),
    RIGHT("right");

    private final String value;

    /**
     * Constructs a {@code TextAlign} with the specified alignment value.
     *
     * @param value The text alignment value as a string.
     */
    TextAlign(String value) {
        this.value = value;
    }

    /**
     * Returns the text alignment value as a string.
     *
     * @return The string representation of the text alignment.
     */
    public String getValue() {
        return value;
    }

    /**
     * Converts a string value into a corresponding {@code TextAlign} enum.
     * <p>
     * This method performs a case-insensitive match against known alignment values.
     * If the provided value does not match any known alignment, {@code null} is returned.
     * </p>
     *
     * @param textAlign The alignment value as a string.
     * @return The corresponding {@code TextAlign} enum, or {@code null} if the value is invalid.
     */
    public static TextAlign fromValue(String textAlign) {
        if (textAlign == null) {
            return null;
        }
        textAlign = textAlign.trim();
        for (TextAlign tAlign : TextAlign.values()) {
            if (tAlign.getValue().equalsIgnoreCase(textAlign)) {
                return tAlign;
            }
        }
        return null;
    }
}
