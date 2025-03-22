package com.nooblab.text;

/**
 * Defines the possible text rendering styles.
 * <p>
 * This enumeration provides different styles that can be applied to text
 * in a graphical rendering system.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public enum FontStyle {
    NORMAL("normal"),
    ITALIC("italic"),
    UNDERLINE("underline"),
    STRIKETHROUGH("strikethrough");

    private final String value;

    /**
     * @param value The name of the text style.
     */
    FontStyle(String value) {
        this.value = value;
    }

    /**
     * Returns the name of the text style.
     *
     * @return The style name as a string.
     */
    public String getValue() {
        return value;
    }

    public static FontStyle fromValue(String fontStyle) {
        fontStyle = fontStyle.trim();
        for (FontStyle fStyle : FontStyle.values()) {
            if (fStyle.getValue().equalsIgnoreCase(fontStyle)) {
                return fStyle;
            }
        }
        return null;
    }
}