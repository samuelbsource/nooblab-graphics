package com.nooblab.style;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for parsing style definitions into {@link Style} objects.
 * <p>
 * This class provides methods to interpret and convert string-based style
 * definitions (such as CSS-like syntax) into a structured {@link Style} object.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public final class StyleParser {

    private static final Pattern STYLE_PATTERN = Pattern.compile("([a-zA-Z0-9-]+)\\s*[:=]\\s*(\\\"[^\\\"]*\\\"|'[^']*'|[^;\n]*)");

    /**
     * Private constructor to prevent instantiation.
     */
    private StyleParser() {
        // Utility class; should not be instantiated.
    }

    /**
     * Parses a string-based style definition and returns a corresponding {@link Style} object.
     * <p>
     * The input format is expected to follow a CSS-like structure, where key-value
     * pairs define style attributes (e.g., "color: red; font-size: 14px;").
     * </p>
     *
     * @param styleDefinition The string representation of the style.
     * @return A {@link Style} object with parsed values.
     */
    public static Style parse(String styleDefinition) {
        if (styleDefinition == null || styleDefinition.trim().isEmpty()) {
            return new Style();
        }

        Matcher matcher = STYLE_PATTERN.matcher(styleDefinition);
        Style style = new Style();

        while (matcher.find()) {
            String key = matcher.group(1).trim();
            String value = removeQuotes(matcher.group(2).trim());

            switch (key) {
                case "color":
                case "colour":
                    style.setColor(value);
                    break;
                case "font-size":
                    style.setFontSize(value);
                    break;
                case "font-weight":
                    style.setFontWeight(value);
                    break;
                case "font-family":
                    style.setFontFamily(value);
                    break;
                case "font-style":
                    style.setFontStyle(value);
                    break;
                case "text-align":
                    style.setTextAlign(value);
                    break;
                default:
                    break;
            }
        }

        return style;
    }

    /**
     * Helper to remove surrounding quotes from a string.
     * 
     * @param value The string to remove quotes from.
     * @return The string without surrounding quotes.
     */
    private static String removeQuotes(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        if ((value.startsWith("\"") && value.endsWith("\"")) || (value.startsWith("'") && value.endsWith("'"))) {
            return value.substring(1, value.length() - 1);
        }

        return value;
    }
}
