package com.nooblab;

import java.io.IOException;
import java.util.concurrent.locks.LockSupport;

import com.nooblab.adapter.GraphicsAdapter;
import com.nooblab.adapter.GraphicsAdapterFactory;
import com.nooblab.element.Circle;
import com.nooblab.element.Element;
import com.nooblab.element.Image;
import com.nooblab.element.Line;
import com.nooblab.element.Polygon;
import com.nooblab.element.Positionable;
import com.nooblab.element.Rectangle;
import com.nooblab.element.Resizable;
import com.nooblab.element.Text;
import com.nooblab.util.ElementList;
import com.nooblab.util.ImageLoader;
import com.nooblab.util.SVGImageLoader;
import com.nooblab.util.StringImageLoader;

public final class Graphics {

    /**
     * List of all elements that will be drawn on the canvas
     */
    protected static ElementList<Element> graphicsElements = new ElementList<Element>();

    /**
     * Default sleep time for the graphics library to allow for infinite loop in the
     * main method without overloading the CPU
     */
    protected static int sleepTime = 10;

    /**
     * Graphics adapter to be used for drawing
     */
    protected static GraphicsAdapter graphicsAdapter;

    /**
     * Main thread
     */
    protected static Thread mainThread;
    
    /**
     * Private constructor to prevent instantiation.
     */
    private Graphics() {
        // Utility class; should not be instantiated.
    }

    /**
     * <b>drawRectangle</b> draws a rectangle at the position specified by <b>x</b>
     * and <b>y</b> of the specified <b>width</b> and <b>height</b>.
     * These parameters are mandatory. The position relates to the top left edge of
     * the rectangle. The rectangle can be coloured with the
     * optional parameters <b>fillColour</b>, <b>strokeColour</b> (the colour of the
     * outline around the box) and <b>strokeWeight</b>
     * (the thickness of the outline around the box).
     *
     * Colours can be specified as a human readable string e.g. <b>"red"</b>,
     * <b>"blue"</b> etc, or as CSS style hexadecimal RGB values
     * e.g. <b>#FF27AA</b>. If you Google “HTML colour picker” you’ll find plenty of
     * pages that let you determine the RGB codes
     * for a given colour.
     * 
     * @see <a href="https://www.w3schools.com/colors/colors_picker.asp">HTML Colour Picker</a>
     *
     * @param x            the x-coordinate of the rectangle's top-left edge
     * @param y            the y-coordinate of the rectangle's top-left edge
     * @param width        the width of the rectangle
     * @param height       the height of the rectangle
     * @param fillColour   the fill colour of the rectangle (optional)
     * @param strokeColour the outline colour of the rectangle (optional)
     * @param strokeWeight the thickness of the outline (optional)
     * @return ID of the rectangle
     */
    public static String drawRectangle(int x, int y, int width, int height, String fillColour, String strokeColour, int strokeWeight) {
        checkInitialized();
        Rectangle rectangle = new Rectangle(x, y, width, height, fillColour, strokeColour, strokeWeight);
        graphicsElements.add(rectangle);
        sleepInternal();
        return rectangle.getId();
    }

    /**
     * drawCircle draws a circle at the position specified by x and y of the
     * specified radius.
     * Note that the position specifies the centre of the circle rather than the top
     * left edge.
     * As with the rectangle, the parameters for the colour and stroke settings of
     * the circle are options.
     *
     * @param x            the x-coordinate of the circle’s centre
     * @param y            the y-coordinate of the circle’s centre
     * @param r            the radius of the circle
     * @param colour       the fill colour of the circle (optional)
     * @param strokeColor  the stroke colour of the circle (optional)
     * @param strokeWeight the thickness of the circle’s outline (optional)
     * @return ID of the circle
     */
    public static String drawCircle(int x, int y, int r, String colour, String strokeColor, int strokeWeight) {
        checkInitialized();
        Circle circle = new Circle(x, y, r, colour, strokeColor, strokeWeight);
        graphicsElements.add(circle);
        sleepInternal();
        return circle.getId();
    }

    /**
     * drawLine draws a line at the position specified by x and y to the position
     * specified by x2 and y2.
     * As a line is only a stroke without any internal area, only strokeColour and
     * strokeWeight are
     * available for styling the line; as with other shapes, these style parameters
     * are optional.
     *
     * @param x            the x-coordinate of the start of the line
     * @param y            the y-coordinate of the start of the line
     * @param x2           the x-coordinate of the end of the line
     * @param y2           the y-coordinate of the end of the line
     * @param strokeColour the outline colour of the line (optional)
     * @param strokeWeight the thickness of the outline (optional)
     * @return ID of the line
     */
    public static String drawLine(int x, int y, int x2, int y2, String strokeColour, int strokeWeight) {
        checkInitialized();
        Line line = new Line(x, y, x2, y2, strokeColour, strokeWeight);
        graphicsElements.add(line);
        sleepInternal();
        return line.getId();
    }

    /**
     * drawPolygon draws the shape specified by a series of X and Y coordinates
     * supplied
     * in the parameter <b>points</b>. This can be specified as a string that
     * contains a list
     * of coordinates where X and Y are separated by commas and each pair of
     * coordinates
     * is separated by a space. For example, <code>10,50 30,90 50,50</code> would be
     * a valid
     * string for <b>points</b>. Alternatively, you can specify <b>points</b> as a
     * 2D array of
     * integer values. As with other shapes, <b>colour</b> and <b>stroke</b>
     * parameters are optional.
     *
     * @param points       a string of X,Y coordinate pairs or a 2D array of integer
     *                     coordinates
     * @param colour       (optional) the fill colour for the polygon
     * @param strokeColour (optional) the outline colour of the polygon
     * @param strokeWidth  (optional) the thickness of the outline
     * @return ID of the polygon
     */
    public static String drawPolygon(String points, String colour, String strokeColour, int strokeWidth) {
        checkInitialized();

        // Convert the string of points into two arrays of integers
        String[] pointStrings = points.split(" ");
        int[] x = new int[pointStrings.length];
        int[] y = new int[pointStrings.length];

        for (int i = 0; i < pointStrings.length; i++) {
            String[] point = pointStrings[i].split(",");
            x[i] = Integer.parseInt(point[0]);
            y[i] = Integer.parseInt(point[1]);
        }

        Polygon polygon = new Polygon(x, y, colour, strokeColour, strokeWidth);
        graphicsElements.add(polygon);
        sleepInternal();
        return polygon.getId();
    }

    /**
     * drawPolygon draws the shape specified by a series of X and Y coordinates
     * supplied
     * in the parameter <b>points</b>. This can be specified as a string that
     * contains a list
     * of coordinates where X and Y are separated by commas and each pair of
     * coordinates
     * is separated by a space. For example, <code>10,50 30,90 50,50</code> would be
     * a valid
     * string for <b>points</b>. Alternatively, you can specify <b>points</b> as a
     * 2D array of
     * integer values. As with other shapes, <b>colour</b> and <b>stroke</b>
     * parameters are optional.
     *
     * @param points       a 2D array of integer coordinates, where each inner array
     *                     has two elements (X, Y)
     * @param colour       (optional) the fill colour for the polygon
     * @param strokeColour (optional) the outline colour of the polygon
     * @param strokeWidth  (optional) the thickness of the outline
     * @return ID of the polygon
     */
    public static String drawPolygon(int[][] points, String colour, String strokeColour, int strokeWidth) {
        checkInitialized();

        int[] x = new int[points.length];
        int[] y = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            x[i] = points[i][0];
            y[i] = points[i][1];
        }

        Polygon polygon = new Polygon(x, y, colour, strokeColour, strokeWidth);
        graphicsElements.add(polygon);
        sleepInternal();
        return polygon.getId();
    }

    /**
     * drawText draws the specified text onto the graphical area at the position
     * specified by x and y.
     * The <b>style</b> parameter is optional and should contain a CSS style string.
     * For example,
     * <code>colour="red"; font-size: 120%</code> would be a valid style.
     *
     * <p>
     * Note that this method is distinct from <code>System.out.println</code> in
     * that it paints the text
     * on the graphical area alongside any shapes, images, etc. The existing
     * <code>System.out.println</code>
     * method is still available, and will still display its output in the usual
     * text console.
     * Nothing stops you writing programs that use both output areas.
     * </p>
     *
     * @param x     the x-coordinate where the text will appear
     * @param y     the y-coordinate where the text will appear
     * @param text  the text to draw
     * @param style (optional) a CSS-style string to style the text
     * @return ID of the text
     */
    public static String drawText(int x, int y, String text, String style) {
        checkInitialized();
        Text textElement = new Text(x, y, text, style);
        graphicsElements.add(textElement);
        sleepInternal();
        return textElement.getId();
    }

    /**
     * drawWebSprite draws an image at position <b>x</b> and <b>y</b> using the
     * given <b>url</b> as its source.
     * The <b>width</b> and <b>height</b> parameters are optional; if they are
     * omitted or set to 0 (or a negative value),
     * the image's natural size will apply.
     *
     * @param x      the x-coordinate at which to draw the image
     * @param y      the y-coordinate at which to draw the image
     * @param url    the source URL of the image
     * @param width  (optional) the width to draw the image
     * @param height (optional) the height to draw the image
     */
    public static String drawWebSprite(int x, int y, String url, int width, int height) {
        checkInitialized();

        byte[] imageData;
        if (url.endsWith(".svg")) {
            imageData = SVGImageLoader.loadAsPNG(url, width, height);
        } else {
            imageData = ImageLoader.load(url, width, height);
        }

        Image image = new Image(imageData, x, y, width, height);
        graphicsElements.add(image);
        sleepInternal();
        return image.getId();
    }

    /**
     * drawSprite allows you to programmatically generate your own images (or
     * sprites)
     * without needing a source image on the public internet. The usual <b>x</b> and
     * <b>y</b> coordinates
     * specify the position, and unlike other shapes <b>width</b> and <b>height</b>
     * are mandatory.
     *
     * <p>
     * The <b>data</b> is specified as a 2D array of strings where each element is a
     * single
     * HTML-style pixel colour (so colour names or hex RGB values are fine, and you
     * can include
     * <b>transparent</b> as a colour).
     * </p>
     *
     * <p>
     * The <b>width</b> and <b>height</b> need not match the dimensions of the
     * <b>data</b> array.
     * If the size specified is larger than the array, the sprite will be scaled
     * to the size specified. This means you can create some nice retro 8-bit style
     * sprites;
     * for example.
     * </p>
     *
     * @param x      the x-coordinate at which to draw the sprite
     * @param y      the y-coordinate at which to draw the sprite
     * @param data   a 2D array of strings, each representing a single pixel's colour
     * @param width  the width to draw the sprite
     * @param height the height to draw the sprite
     */
    public static String drawSprite(int x, int y, String[][] data, int width, int height) {
        checkInitialized();
        byte[] pixelData;
        try {
            pixelData = StringImageLoader.loadAsPNG(data);
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to load sprite data");
        }
        Image image = new Image(pixelData, x, y, width, height);
        graphicsElements.add(image);
        sleepInternal();
        return image.getId();
    }

    /**
     * As per the &ldquo;shiny&rdquo; example earlier on, <b>drawPlayingCard</b>
     * lets you draw a playing card.
     * The <b>card</b> parameter specifies which card you want (either <i>ace</i>,
     * <i>jack</i>, <i>queen</i>,
     * <i>king</i>, or a number from 2&ndash;10). If your card number is in an
     * integer or other numeric variable,
     * you'll need to convert it to a <code>String</code>.
     * The <b>suit</b> is one of <b>clubs</b>, <b>spades</b>, <b>hearts</b>, or
     * <b>diamonds</b>.
     * You specify the position on the page with <b>x</b> and <b>y</b>, and also the
     * <b>width</b>.
     * There is no need to specify a height; it is calculated proportionally to the
     * width.
     *
     * @param card  which card to draw (e.g. "ace", "10", "king")
     * @param suit  the suit of the card (e.g. "clubs", "spades", "hearts",
     *              "diamonds")
     * @param x     the x-coordinate where the card is drawn
     * @param y     the y-coordinate where the card is drawn
     * @param width the width of the card; the height is auto-calculated
     */
    public static String drawPlayingCard(String card, String suit, int x, int y, int width) {
        String url = "https://www.nooblab.com/NoobLab/images/cards/" + card + "_of_" + suit + ".svg";
        return drawWebSprite(x, y, url, width, (int) Math.floor(width * 1.45));
    }

    /**
     * Given an <b>id</b>, updates an existing text object to read whatever is
     * supplied in <b>newText</b>.
     * If called on a non-text shape, this will have no effect.
     *
     * @param id      the ID of the text element to update
     * @param newText the new text content
     */
    public static void updateText(String id, String newText) {
        checkInitialized();
        Element element = graphicsElements.findByID(id);
        if (element instanceof Text) {
            ((Text) element).setText(newText);
        } else {
            throw new IllegalArgumentException("Element with ID " + id + " is not a text element");
        }
        sleepInternal();
    }

    /**
     * Given an <b>id</b>, updates an existing text object to whatever CSS style is
     * supplied in <b>newStyle</b>.
     * If called on a non-text shape, this will have no effect.
     *
     * @param id       the ID of the text element to update
     * @param newStyle the new CSS style to apply
     */
    public static void updateTextStyle(String id, String newStyle) {
        checkInitialized();
        Element element = graphicsElements.findByID(id);
        if (element instanceof Text) {
            ((Text) element).setStyle(newStyle);
        } else {
            throw new IllegalArgumentException("Element with ID " + id + " is not a text element");
        }
        sleepInternal();
    }

    /**
     * Given an {@code id} this will update the image displayed by a web sprite
     * object. If called on any other shape, this has no effect.
     * 
     * @param id
     * @param url
     */
    public static void updateWebSpriteImage(String id, String url) {
        Element image = graphicsElements.findByID(id);
        if (image instanceof Image) {
            byte[] imageData;
            if (url.endsWith(".svg")) {
                imageData = SVGImageLoader.loadAsPNG(url, ((Image) image).getWidth(), ((Image) image).getHeight());
            } else {
                imageData = ImageLoader.load(url, ((Image) image).getWidth(), ((Image) image).getHeight());
            }
            ((Image) image).setData(imageData);
        } else {
            throw new IllegalArgumentException("Element with ID " + id + " is not an image element");
        }
    }

    /**
     * Given an <b>id</b> of an existing shape, repositions it at the coordinates
     * <b>newX</b> and <b>newY</b>.
     * This was used in the &ldquo;shiny&rdquo; example to move the big Ace of
     * Spades. You can leave the
     * Y coordinate off if you are only repositioning along the X axis, and you can
     * supply a null for
     * <b>newX</b> if you want to only reposition along the Y axis.
     *
     * @param id   the ID of the shape to move
     * @param newX the new X coordinate
     * @param newY the new Y coordinate
     */
    public static void updatePosition(String id, int newX) {
        checkInitialized();
        Element element = graphicsElements.findByID(id);
        if (element instanceof Positionable) {
            ((Positionable) element).setX(newX);
        } else {
            throw new IllegalArgumentException("Element with ID " + id + " cannot be repositioned");
        }
        sleepInternal();
    }

    /**
     * Given an <b>id</b> of an existing shape, repositions it at the coordinates
     * <b>newX</b> and <b>newY</b>.
     * This was used in the &ldquo;shiny&rdquo; example to move the big Ace of
     * Spades. You can leave the
     * Y coordinate off if you are only repositioning along the X axis, and you can
     * supply a null for
     * <b>newX</b> if you want to only reposition along the Y axis.
     *
     * @param id   the ID of the shape to move
     * @param newX the new X coordinate
     * @param newY the new Y coordinate
     */
    public static void updatePosition(String id, int newX, int newY) {
        checkInitialized();
        Element element = graphicsElements.findByID(id);
        if (element instanceof Positionable) {
            ((Positionable) element).setX(newX);
            ((Positionable) element).setY(newY);
        } else {
            throw new IllegalArgumentException("Element with ID " + id + " cannot be repositioned");
        }
        sleepInternal();
    }

    /**
     * Given an <b>id</b> of an existing shape, repositions it at the coordinates
     * <b>newX</b> and <b>newY</b>.
     * This was used in the &ldquo;shiny&rdquo; example to move the big Ace of
     * Spades. You can leave the
     * Y coordinate off if you are only repositioning along the X axis, and you can
     * supply a null for
     * <b>newX</b> if you want to only reposition along the Y axis.
     *
     * @param id   the ID of the shape to move
     * @param newX the new X coordinate
     * @param newY the new Y coordinate
     */
    public static void updatePosition(String id, Void unused, int newY) {
        checkInitialized();
        Element element = graphicsElements.findByID(id);
        if (element instanceof Positionable) {
            ((Positionable) element).setY(newY);
        } else {
            throw new IllegalArgumentException("Element with ID " + id + " cannot be repositioned");
        }
        sleepInternal();
    }

    /**
     * Given an <b>id</b> of an existing shape, resizes it based on the parameters
     * <b>width</b> and <b>height</b>.
     * You can omit or set <b>height</b> to a null-equivalent if you only want to
     * resize one dimension of the shape,
     * and similarly you can supply a null-equivalent for <b>width</b> if only
     * resizing the other dimension.
     * <p>
     * If you are resizing a circle, then you only need to supply one parameter:
     * that value will be used
     * as the new radius of the circle.
     * </p>
     *
     * @param id     the ID of the shape to resize
     * @param width  the new width (or radius if resizing a circle)
     * @param height the new height (optional for one-dimensional resizing)
     */
    public static void resizeShape(String id, int width, int height) {
        checkInitialized();
        Element element = graphicsElements.findByID(id);
        if (element instanceof Resizable) {
            ((Resizable) element).setWidth(width);
            ((Resizable) element).setHeight(height);
        } else if (element instanceof Circle) {
            ((Circle) element).setRadius(width);
        } else {
            throw new IllegalArgumentException("Element with ID " + id + " cannot be resized");
        }
        sleepInternal();
    }

    /**
     * Given an <b>id</b> of an existing shape, resizes it based on the parameters
     * <b>width</b> and <b>height</b>.
     * You can omit or set <b>height</b> to a null-equivalent if you only want to
     * resize one dimension of the shape,
     * and similarly you can supply a null-equivalent for <b>width</b> if only
     * resizing the other dimension.
     * <p>
     * If you are resizing a circle, then you only need to supply one parameter:
     * that value will be used
     * as the new radius of the circle.
     * </p>
     *
     * @param id     the ID of the shape to resize
     * @param width  the new width (or radius if resizing a circle)
     */
    public static void resizeShape(String id, int width) {
        checkInitialized();
        Element element = graphicsElements.findByID(id);
        if (element instanceof Resizable) {
            ((Resizable) element).setWidth(width);
        } else if (element instanceof Circle) {
            ((Circle) element).setRadius(width);
        } else {
            throw new IllegalArgumentException("Element with ID " + id + " cannot be resized");
        }
        sleepInternal();
    }

    /**
     * Removes the shape with the given <b>id</b> from the canvas entirely, so it is
     * no longer drawn.
     * Once removed, the shape cannot be shown or updated again without recreating
     * it.
     * If the shape is not found, this method does nothing.
     *
     * @param id the ID of the shape to remove
     */
    public static void removeShape(String id) {
        checkInitialized();
        graphicsElements.removeByID(id);
        sleepInternal();
    }

    /**
     * Makes the shape with the given <b>id</b> visible if it was previously hidden.
     * The shape remains on the canvas whether hidden or visible.
     *
     * @param id the ID of the shape to show
     */
    public static void showShape(String id) {
        checkInitialized();
        Element element = graphicsElements.findByID(id);
        if (element != null) {
            element.show();
        }
        sleepInternal();
    }

    /**
     * Hides the shape with the given <b>id</b> without removing it from the canvas.
     * It can be made visible again with {@link #showShape(String)}.
     *
     * @param id the ID of the shape to hide
     */
    public static void hideShape(String id) {
        checkInitialized();
        Element element = graphicsElements.findByID(id);
        if (element != null) {
            element.hide();
        }
        sleepInternal();
    }

    /**
     * Toggles the visibility of the shape with the given <b>id</b>.
     * If visible, it becomes hidden; if hidden, it becomes visible.
     *
     * @param id the ID of the shape to toggle
     */
    public static void toggleShape(String id) {
        checkInitialized();
        Element element = graphicsElements.findByID(id);
        if (element != null) {
            element.toggle();
        }
        sleepInternal();
    }

    /**
     * Wipe the canvas clean, there will be no elements on the canvas after this
     * method is called.
     */
    public static void wipeCanvas() {
        checkInitialized();
        graphicsElements.clear();
        sleepInternal();
    }

    /**
     * Sometimes, graphical programs can run too quickly, particularly if you're
     * continuously calling {@code updatePosition} to animate a shape. This function
     * adds a delay into graphical programs; specify the delay in milliseconds. 1000
     * milliseconds is one second; generally, introducing a delay of 5-10
     * milliseconds will slow an animation down to a smooth glide across the screen.
     */
    public static void sleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function returns true if a given cursor key is pressed, and false if
     * not. This may be useful if you want to add user input to a graphical program,
     * e.g. for games. Supply the {@code key} to check in the form {@code "up"},
     * {@code "down"}, {@code "left"}, or {@code "right"}.
     */
    public static boolean isCursorKeyPressed(String key) {
        return graphicsAdapter.isKeyPressed(key.toUpperCase().trim());
    }

    /**
     * This function returns a string that contains all the cursor keys that are
     * being pressed. This will allow for detection of multiple keys; for example,
     * if someone is pressing both up and right then this will return
     * {@code up left}. It is actually possible to return {@code up down left right}
     * if all four were being held down at the same time (although I'm not sure what
     * any game character would do in such a case!)
     */
    public static String whichCursorKeyPressed() {
        String[] keys = graphicsAdapter.getPressedKeys();
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key.toLowerCase().trim()).append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * The graphics API defaults to an output area that is square in shape and is
     * 1000 "units" wide by 1000 "units" high. This shape tends to fit the NoobLab
     * UI where the code editor and the text-based console occupy the right hand
     * side of the screen. However, you can change the shape of the graphics output
     * area with this function. The graphics area will always be a maximum of either
     * 1000 "units" wide or 1000 "units" high, so you should pass in proportional
     * figures as you might see in TV or film aspect ratios. For example, supplying
     * 16 for {@code x} and 9 for {@code y} would give you a canvas that is the same
     * shape as a modern TV set. Depending on the size of your browser window, you
     * may find that there are bars at the top or at the sides of the graphical
     * output area in order to accommodate the aspect ratio selected.
     */
    public static void setAspectRatio(int x, int y) {
        checkInitialized();
        graphicsAdapter.setAspectRatio(x, y);
        sleepInternal();
    }

    /**
     * Sleep after each drawing method to allow for animations
     */
    private static void sleepInternal() {
        if (graphicsAdapter.isFinished()) {
            graphicsAdapter.dispose();
            System.exit(0);
        }
        LockSupport.park();
    }

    /**
     * Check if the graphics engine has been initialized.
     */
    private static void checkInitialized() {
        if (graphicsAdapter == null) {
            graphicsAdapter = GraphicsAdapterFactory.getGraphicsAdapter();
            graphicsAdapter.init();
            graphicsAdapter.scheduleFrameUpdates(() -> {
                graphicsAdapter.clear();
                try {
                    graphicsElements.forEach(element -> element.draw(graphicsAdapter));
                } catch (Exception e) {
                    // ConcurrentModificationException can occur if the list is modified while iterating
                }
            }, 60);
        }
        if (mainThread == null) {
            mainThread = Thread.currentThread();
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Sleep main thread to prevent overloading the CPU
                    LockSupport.unpark(mainThread);
                }
            }).start();
        }
    }
}
