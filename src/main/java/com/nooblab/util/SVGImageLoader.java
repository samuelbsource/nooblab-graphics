package com.nooblab.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import io.sf.carte.echosvg.transcoder.TranscoderException;
import io.sf.carte.echosvg.transcoder.TranscoderInput;
import io.sf.carte.echosvg.transcoder.TranscoderOutput;
import io.sf.carte.echosvg.transcoder.image.PNGTranscoder;

/**
 * A utility class for loading and converting SVG images into raster format.
 * <p>
 * This class provides a method to load an SVG image from a given URL and transcode it
 * into a raster image at a specified width and height.
 * </p>
 * <p>
 * <b>Future Improvements:</b>
 * <ul>
 *   <li>Implement asynchronous SVG loading using {@code java.util.concurrent}.</li>
 * </ul>
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public class SVGImageLoader {

    /**
     * Loads an SVG image from a specified URL and converts it to a PNG format.
     * <p>
     * The output PNG image will be scaled to the specified width and height.
     * This method fetches the SVG data, processes it using the EchoSVG library,
     * and returns the PNG image as a byte array.
     * </p>
     *
     * @param url    The URL of the SVG image.
     * @param width  The desired width of the output PNG image.
     * @param height The desired height of the output PNG image.
     * @return A byte array containing the PNG image data, or {@code null} if an error occurs.
     */
    public static byte[] loadAsPNG(String url, int width, int height) {
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

        // Configure the PNG transcoder
        PNGTranscoder transcoder = new PNGTranscoder();
        transcoder.addTranscodingHint(PNGTranscoder.KEY_WIDTH, (float) width);
        transcoder.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, (float) height);

        // Convert the SVG to PNG
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(bytes));
        TranscoderOutput output = new TranscoderOutput(outputStream);

        try {
            transcoder.transcode(input, output);
        } catch (TranscoderException e) {
            return null;
        }

        return outputStream.toByteArray();
    }
}
