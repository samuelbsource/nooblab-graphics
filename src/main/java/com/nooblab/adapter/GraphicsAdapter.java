package com.nooblab.adapter;

import com.nooblab.text.FontStyle;
import com.nooblab.text.FontWeight;
import com.nooblab.text.TextAlign;

/**
 * Represents an abstract graphics adapter interface for rendering 2D graphics.
 * <p>
 * This interface defines various methods for handling graphical operations, such as
 * setting colors, drawing shapes, and rendering text. Implementations of this
 * interface should provide the concrete rendering logic using a specific graphics
 * framework or API.
 * </p>
 * <p>
 * All graphical updates must occur within the {@code Runnable} callback provided
 * to either {@link #scheduleFrameUpdates} or {@link #requestAnimationFrame}.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public interface GraphicsAdapter {
    
    /**
     * Initializes the graphics adapter.
     * <p>
     * This method is responsible for initializing the necessary graphical components,
     * such as setting up a rendering context and preparing graphical resources.
     * Implementations should ensure that any errors during initialization are handled gracefully.
     * </p>
     */
    void init();

    /**
     * Disposes of the graphics adapter, releasing all resources.
     * <p>
     * This method should be called when the adapter is no longer needed,
     * allowing another adapter to be used or the application to close cleanly.
     * </p>
     */
    void dispose();

    /**
     * Checks if the graphics adapter is finished, indicating that it can be disposed.
     * 
     * @return {@code true} if the adapter is active, {@code false} otherwise.
     */
    boolean isFinished();

    /**
     * Clears the screen, removing all drawn content.
     */
    void clear();

    /**
     * Saves the current graphics state.
     * <p>
     * The saved state includes properties such as:
     * <ul>
     *   <li>Current fill color</li>
     *   <li>Current stroke color</li>
     *   <li>Line width</li>
     *   <li>Font settings (family, size, weight, style)</li>
     *   <li>Any other transformation settings</li>
     * </ul>
     * This allows for later restoration of the state to revert any modifications.
     * </p>
     */
    GraphicsState saveState();

    /**
     * Restores the previously saved graphics state.
     * <p>
     * This method should be used to return to a previously saved state,
     * restoring properties such as fill color, stroke color, line width, font settings,
     * and other transformations that were in effect at the last save.
     * </p>
     */
    void restoreState(GraphicsState state);

    /**
     * Resets the graphics state to its default settings.
     * <p>
     * This method restores the graphics adapter to its initial default configuration,
     * including resetting colors, stroke width, font settings, and any transformations.
     * </p>
     */
    void resetState();

    /**
     * Schedules periodic frame updates at a specified refresh rate.
     * <p>
     * The provided callback will be executed repeatedly at the specified
     * frame rate (in frames per second, FPS). However, the exact refresh rate
     * may vary depending on the underlying implementation and system constraints.
     * This method should be used for continuous rendering updates.
     * </p>
     *
     * @param callback The callback function executed at the refresh rate.
     * @param refreshRate The target refresh rate in frames per second (FPS).
     */
    void scheduleFrameUpdates(Runnable callback, int refreshRate);

    /**
     * Requests a single animation frame update.
     * <p>
     * The provided callback will be executed exactly once on the next available frame.
     * This should be used for handling animations that do not require fixed frame rates.
     * </p>
     *
     * @param callback The callback function that will be executed on the next frame.
     */
    void requestAnimationFrame(Runnable callback);

    /**
     * Sets the fill color used for filling shapes and text.
     *
     * @param color The color in a string format (e.g., hexadecimal or named colors).
     * @see <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/named-color">Named Colors Reference</a>
     */
    void setFill(String color);

    /**
     * Sets the stroke color used for drawing outlines of shapes and text.
     *
     * @param color The color in a string format (e.g., hexadecimal or named colors).
     * @see <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/named-color">Named Colors Reference</a>
     */
    void setStroke(String color);

    /**
     * Sets the line width for stroking shapes and paths.
     *
     * @param width The width of the stroke in pixels.
     */
    void setLineWidth(int width);

    /**
     * Sets the text alignment for rendering text.
     *
     * @param textAlign The desired text alignment.
     */
    void setTextAlign(TextAlign textAlign);

    /**
     * Sets the font family for rendering text.
     *
     * @param fontFamily The name of the font family (e.g., "Arial", "Times New Roman").
     */
    void setFontFamily(String fontFamily);

    /**
     * Sets the font size for rendering text.
     *
     * @param size The font size in pixels.
     */
    void setFontSize(int size);

    /**
     * Sets the font weight for rendering text.
     *
     * @param weight The font weight (e.g., normal, bold, light).
     */
    void setFontWeight(FontWeight weight);

    /**
     * Sets the font style for rendering text.
     *
     * @param style The font style (e.g., normal, italic, oblique).
     */
    void setFontStyle(FontStyle style);

    /**
     * Fills a rectangle with the current fill color.
     *
     * @param x      The x-coordinate of the rectangle's top-left corner.
     * @param y      The y-coordinate of the rectangle's top-left corner.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     */
    void fillRect(int x, int y, int width, int height);

    /**
     * Fills an oval within the specified bounding box with the current fill color.
     *
     * @param x      The x-coordinate of the bounding box's top-left corner.
     * @param y      The y-coordinate of the bounding box's top-left corner.
     * @param width  The width of the bounding box.
     * @param height The height of the bounding box.
     */
    void fillOval(int x, int y, int width, int height);

    /**
     * Fills a polygon with the current fill color.
     *
     * @param xPoints An array of x-coordinates for the polygon's vertices.
     * @param yPoints An array of y-coordinates for the polygon's vertices.
     * @param nPoints The number of points in the polygon.
     */
    void fillPolygon(int[] xPoints, int[] yPoints, int nPoints);

    /**
     * Renders text at the specified position using the current font settings.
     *
     * @param x    The x-coordinate of the text's baseline.
     * @param y    The y-coordinate of the text's baseline.
     * @param text The text to be rendered.
     */
    void fillText(int x, int y, String text);

    /**
     * Strokes a rectangle outline with the current stroke color and line width.
     *
     * @param x      The x-coordinate of the rectangle's top-left corner.
     * @param y      The y-coordinate of the rectangle's top-left corner.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     */
    void strokeRect(int x, int y, int width, int height);

    /**
     * Strokes an oval outline within the specified bounding box.
     *
     * @param x      The x-coordinate of the bounding box's top-left corner.
     * @param y      The y-coordinate of the bounding box's top-left corner.
     * @param width  The width of the bounding box.
     * @param height The height of the bounding box.
     */
    void strokeOval(int x, int y, int width, int height);

    /**
     * Strokes a polygon outline with the current stroke color and line width.
     *
     * @param xPoints An array of x-coordinates for the polygon's vertices.
     * @param yPoints An array of y-coordinates for the polygon's vertices.
     * @param nPoints The number of points in the polygon.
     */
    void strokePolygon(int[] xPoints, int[] yPoints, int nPoints);

    /**
     * Draws a line between two points.
     *
     * @param x1 The x-coordinate of the starting point.
     * @param y1 The y-coordinate of the starting point.
     * @param x2 The x-coordinate of the ending point.
     * @param y2 The y-coordinate of the ending point.
     */
    void strokeLine(int x1, int y1, int x2, int y2);

    /**
     * Strokes text at the specified position using the current font settings.
     *
     * @param x    The x-coordinate of the text's baseline.
     * @param y    The y-coordinate of the text's baseline.
     * @param text The text to be outlined.
     */
    void strokeText(int x, int y, String text);

    /**
     * Draws a raster image at the specified position.
     * <p>
     * The provided {@code id} is required for caching and post-processing by the
     * underlying rendering engine. This allows optimizations such as texture
     * reuse, transformations, and lazy loading.
     * </p>
     *
     * @param id     A unique identifier for the raster image.
     * @param data   The raw image data in a supported raster format (e.g., PNG, BMP).
     * @param x      The x-coordinate where the image should be drawn.
     * @param y      The y-coordinate where the image should be drawn.
     * @param width  The width to scale the image to.
     * @param height The height to scale the image to.
     */
    void drawRasterImage(String id, byte[] data, int x, int y, int width, int height);

    /**
     * Purges a raster image from cache.
     * <p>
     * This method removes any cached or post-processed versions of the specified
     * raster image. It should be used when the source data has changed and needs
     * to be reloaded.
     * </p>
     *
     * @param id The unique identifier of the raster image to purge.
     */
    void purgeRasterImage(String id);

    /**
     * Defines the aspect ratio for rendering within a fixed 1000x1000 canvas.
     * <p>
     * This method does not change the actual pixel size of the canvas but instead
     * sets the aspect ratio to be used for rendering. For example, calling
     * {@code resizeCanvas(16, 9)} will define a 16:9 aspect ratio, similar to a modern TV screen.
     * Implementations should ensure that transformations are applied accordingly
     * to maintain the defined aspect ratio.
     * </p>
     *
     * @param width  The width of the desired aspect ratio.
     * @param height The height of the desired aspect ratio.
     */
    void setAspectRatio(int width, int height);

    /**
     * Checks if the specified key is currently pressed.
     * 
     * @param key The key code to check.
     * @return {@code true} if the key is pressed, {@code false} otherwise.
     */
    boolean isKeyPressed(String key);

    /**
     * Returns list of keys that are currently pressed.
     * 
     * @return List of key codes that are currently pressed.
     */
    String[] getPressedKeys();
}
