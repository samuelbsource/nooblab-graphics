package com.nooblab.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A utility class for loading images represented as a 2D array of color names
 * and converting them into a raster format suitable for rendering.
 * <p>
 * This class processes an image defined in a {@code String[][]} format where each
 * string represents a color keyword. The colors are mapped to their corresponding
 * ARGB integer values and converted into a byte array containing pixel data.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public class StringImageLoader {

    /**
     * Converts a 2D string-based image representation into a PNG-compatible byte array.
     * <p>
     * Each string in the input array corresponds to a predefined color keyword or a CSS 
     * The resulting byte array contains pixel data in ARGB format, where each pixel
     * consists of four bytes (alpha, red, green, blue).
     * </p>
     *
     * @param data A 2D array of strings representing color names.
     * @return A byte array containing the corresponding pixel data in ARGB format.
     * @throws IOException 
     */
    public static byte[] loadAsPNG(String[][] data) throws IOException {
        int height = data.length;
        int width = data[0].length;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Fill the image with pixel data
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = CSSColor.toARGB(data[y][x]);
                image.setRGB(x, y, argb);
            }
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);

        return outputStream.toByteArray();
    }
}
