package com.nooblab.text;

/**
 * Defines the possible font weights for text rendering.
 * <p>
 * This enumeration provides standard font weights that can be applied
 * in a graphical rendering system, including named weights and numeric values
 * following the CSS font-weight specification.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public enum FontWeight {
    NORMAL("normal"),
    BOLD("bold"),
    BOLDER("bolder"),
    LIGHTER("lighter"),
    WEIGHT_100("100"),
    WEIGHT_200("200"),
    WEIGHT_300("300"),
    WEIGHT_400("400"),
    WEIGHT_500("500"),
    WEIGHT_600("600"),
    WEIGHT_700("700"),
    WEIGHT_800("800"),
    WEIGHT_900("900");

    private final String value;

    /**
     * Constructs a {@code FontWeight} with the specified weight value.
     *
     * @param value The font weight value as a string.
     */
    FontWeight(String value) {
        this.value = value;
    }

    /**
     * Returns the font weight value.
     *
     * @return The font weight as a string.
     */
    public String getValue() {
        return value;
    }

    public static FontWeight fromValue(String fontWeight) {
        fontWeight = fontWeight.trim();
        for (FontWeight fWeight : FontWeight.values()) {
            if (fWeight.getValue().equalsIgnoreCase(fontWeight)) {
                return fWeight;
            }
        }
        return null;
    }
}