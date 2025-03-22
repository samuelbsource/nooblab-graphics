package com.nooblab.util;

import java.awt.Color;

/**
 * Utility class for converting CSS color representations into ARGB integer values.
 * <p>
 * This class supports multiple CSS color formats, including named colors, hexadecimal,
 * RGB, RGBA, HSL, and HSLA. The converted ARGB values can be used for rendering or further processing.
 * </p>
 *
 * <p><b>Future Improvements:</b>
 * <ul>
 *   <li>Improve error handling for invalid or malformed color strings.</li>
 *   <li>Optimize parsing efficiency, especially for large-scale color processing.</li>
 *   <li>Extend support for additional CSS color formats (e.g., HWB).</li>
 * </ul>
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public class CSSColor {
    
    /**
     * Converts a CSS color string to an ARGB integer value.
     * <p>
     * Supports multiple CSS color formats, including:
     * <ul>
     *   <li>Named colors (e.g., "red", "blue")</li>
     *   <li>Hexadecimal (e.g., "#FF0000")</li>
     *   <li>RGB (e.g., "rgb(255, 0, 0)")</li>
     *   <li>RGBA (e.g., "rgba(255, 0, 0, 0.5)")</li>
     *   <li>HSL (e.g., "hsl(0, 100%, 50%)")</li>
     *   <li>HSLA (e.g., "hsla(0, 100%, 50%, 0.5)")</li>
     * </ul>
     * </p>
     *
     * @param color The CSS color string.
     * @return The ARGB integer representation of the color.
     */
    public static int toARGB(String color) {
        color = color.trim();
        if (color.startsWith("#")) {
            return hexToARGB(color);
        } else if (color.startsWith("rgb(")) {
            return rgbToARGB(color);
        } else if (color.startsWith("rgba(")) {
            return rgbaToARGB(color);
        } else if (color.startsWith("hsl(")) {
            return hslToARGB(color);
        } else if (color.startsWith("hsla(")) {
            return hslaToARGB(color);
        } else {
            return namedToARGB(color);
        }
    }

    private static int hexToARGB(String color) {
        return Integer.parseInt(color.substring(1), 16);
    }

    private static int rgbToARGB(String color) {
        String[] values = color.substring(4, color.length() - 1).split(",");
        int r = Integer.parseInt(values[0].trim());
        int g = Integer.parseInt(values[1].trim());
        int b = Integer.parseInt(values[2].trim());
        return 0xFF000000 | (r << 16) | (g << 8) | b;
    }

    private static int rgbaToARGB(String color) {
        String[] values = color.substring(5, color.length() - 1).split(",");
        int r = Integer.parseInt(values[0].trim());
        int g = Integer.parseInt(values[1].trim());
        int b = Integer.parseInt(values[2].trim());
        int a = (int) (Float.parseFloat(values[3].trim()) * 255);
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    private static int hslToARGB(String color) {
        String[] values = color.substring(4, color.length() - 1).split(",");
        float h = Float.parseFloat(values[0].trim());
        float s = Float.parseFloat(values[1].trim()) / 100.0f;
        float l = Float.parseFloat(values[2].trim()) / 100.0f;
        
        Color awtColor = Color.getHSBColor(h / 360.0f, s, l);
        int red = awtColor.getRed();
        int green = awtColor.getGreen();
        int blue = awtColor.getBlue();

        return 0xFF000000 | (red << 16) | (green << 8) | blue;
    }

    private static int hslaToARGB(String color) {
        String[] values = color.substring(5, color.length() - 1).split(",");
        float h = Float.parseFloat(values[0].trim());
        float s = Float.parseFloat(values[1].trim()) / 100.0f;
        float l = Float.parseFloat(values[2].trim()) / 100.0f;
        float a = Float.parseFloat(values[3].trim());

        Color awtColor = Color.getHSBColor(h / 360.0f, s, l);
        int red = awtColor.getRed();
        int green = awtColor.getGreen();
        int blue = awtColor.getBlue();
        int alpha = (int) (a * 255);

        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    private static int namedToARGB(String color) {
        CSSNamedColor namedColor = CSSNamedColor.fromName(color);
        if (namedColor == null) {
            return 0;
        }
        return namedColor.getValue();
    }
}
