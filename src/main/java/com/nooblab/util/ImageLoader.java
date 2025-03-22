package com.nooblab.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Load images from the web.
 */
public class ImageLoader {
    public static byte[] load(String url, int width, int height) {
        URI svgUri;
        byte[] bytes;

        // Validate and parse the provided URL
        try {
            svgUri = new URI(url);
        } catch (URISyntaxException e) {
            return null;
        }

        // Load the SVG image data into a byte array
        try (java.io.InputStream inputStream = svgUri.toURL().openStream()) {
            bytes = inputStream.readAllBytes();
        } catch (IOException e) {
            return null;
        }

        return bytes;
    }
}
