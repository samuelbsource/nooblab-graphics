package com.nooblab.adapter;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nooblab.text.FontStyle;
import com.nooblab.text.FontWeight;
import com.nooblab.text.TextAlign;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * A {@link GraphicsAdapter} implementation using JavaFX.
 * <p>
 * This adapter wraps a JavaFX {@link GraphicsContext} to provide
 * rendering capabilities using the JavaFX graphics API.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public class JavaFXGraphicsAdapter implements GraphicsAdapter {

    /**
     * Graphics context for the canvas
     */
    protected GraphicsContext graphicsContext;

    /**
     * Flag to check if the graphics engine has been initialized
     */
    protected boolean initialized;

    /**
     * Flag to check if the graphics engine has been initialized and window was created
     */
    protected boolean fullyInitialized;

    /**
     * Title of the graphics window
     */
    protected String title;

    /**
     * Canvas width
     */
    protected int width;

    /**
     * Canvas height
     */
    protected int height;

    /**
     * Graphics state.
     */
    protected GraphicsState state;

    /**
     * List of keys that are currently pressed
     */
    protected List<KeyCode> pressedKeys;

    /**
     * Store processed raster images for performance
     */
    protected Map<String, Image> cachedImages;


    /**
     * Creates a new JavaFX graphics adapter with default settings.
     */
    public JavaFXGraphicsAdapter() {
        initialized = false;
        fullyInitialized = false;
        title = "Nooblab Graphics";
        width = 1000;
        height = 1000;
        state = new GraphicsState();
        pressedKeys = new ArrayList<KeyCode>();
        cachedImages = new HashMap<String, Image>();
    }

    /**
     * Creates a new JavaFX graphics adapter with the specified title, width, and height.
     */
    public JavaFXGraphicsAdapter(String title, int width, int height) {
        initialized = false;
        this.title = title;
        this.width = width;
        this.height = height;
        state = new GraphicsState();
    }

    @Override
    public void init() {
        if (!initialized) {
            initialized = true;
            Platform.startup(() -> {
                Stage stage = new Stage();
                stage.setTitle(title);

                Group root = new Group();
                Canvas canvas = new Canvas(width, height);
                root.getChildren().add(canvas);

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                scene.setOnKeyPressed(event -> {
                    if (!pressedKeys.contains(event.getCode())) {
                        pressedKeys.add(event.getCode());
                    }
                });

                scene.setOnKeyReleased(event -> {
                    pressedKeys.remove(event.getCode());
                });
                
                graphicsContext = canvas.getGraphicsContext2D();
                graphicsContext.setImageSmoothing(false);
                fullyInitialized = true;
            });
        }
    }

    @Override
    public void dispose() {
        Platform.exit();
        initialized = false;
    }

    @Override
    public boolean isFinished() {
        return initialized && fullyInitialized && Window.getWindows().isEmpty();
    }

    @Override
    public void clear() {
        graphicsContext.clearRect(0, 0, width, height);
    }

    @Override
    public GraphicsState saveState() {
        return state.clone();
    }

    @Override
    public void restoreState(GraphicsState newState) {
        state.apply(newState);
    }

    @Override
    public void resetState() {
        state.reset();
    }

    @Override
    public void scheduleFrameUpdates(Runnable callback, int refreshRate) {
        Duration duration = Duration.seconds(1.0 / refreshRate);
        Timeline timeline = new Timeline(new KeyFrame(duration, e -> {
            callback.run();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @Override
    public void requestAnimationFrame(Runnable callback) {
        Platform.runLater(callback);
    }

    @Override
    public void setFill(String color) {
        state.setFillColor(color);
        graphicsContext.setFill(Color.web(color));
    }

    @Override
    public void setStroke(String color) {
        state.setStrokeColor(color);
        graphicsContext.setStroke(Color.web(color));
    }

    @Override
    public void setLineWidth(int width) {
        state.setLineWidth(width);
        graphicsContext.setLineWidth(width);
    }

    @Override
    public void setTextAlign(TextAlign textAlign) {
        state.setTextAlign(textAlign);
        switch (textAlign) {
            case LEFT:
                graphicsContext.setTextAlign(javafx.scene.text.TextAlignment.LEFT);
                break;
            case CENTER:
                graphicsContext.setTextAlign(javafx.scene.text.TextAlignment.CENTER);
                break;
            case RIGHT:
                graphicsContext.setTextAlign(javafx.scene.text.TextAlignment.RIGHT);
                break;
        }
    }

    @Override
    public void setFontFamily(String fontFamily) {
        state.setFontFamily(fontFamily);
        graphicsContext.setFont(getFont());
    }

    @Override
    public void setFontSize(int size) {
        state.setFontSize(size);
        graphicsContext.setFont(getFont());
    }

    @Override
    public void setFontWeight(FontWeight weight) {
        state.setFontWeight(weight);
        graphicsContext.setFont(getFont());
    }

    @Override
    public void setFontStyle(FontStyle style) {
        state.setFontStyle(style);
        graphicsContext.setFont(getFont());
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        graphicsContext.fillRect(x, y, width, height);
    }

    @Override
    public void fillOval(int x, int y, int width, int height) {
        graphicsContext.fillOval(x, y, width, height);
    }

    @Override
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        double[] xPointsD = new double[nPoints];
        double[] yPointsD = new double[nPoints];

        for (int i = 0; i < nPoints; i++) {
            xPointsD[i] = xPoints[i];
            yPointsD[i] = yPoints[i];
        }

        graphicsContext.fillPolygon(xPointsD, yPointsD, nPoints);
    }

    @Override
    public void fillText(int x, int y, String text) {
        // Adjust text position based on text size
        int adjustY = state.getFontSize() / 2;
        graphicsContext.fillText(text, x, y + adjustY);
    }

    @Override
    public void strokeRect(int x, int y, int width, int height) {
        graphicsContext.strokeRect(x, y, width, height);
    }

    @Override
    public void strokeOval(int x, int y, int width, int height) {
        graphicsContext.strokeOval(x, y, width, height);
    }

    @Override
    public void strokePolygon(int[] xPoints, int[] yPoints, int nPoints) {
        double[] xPointsD = new double[nPoints];
        double[] yPointsD = new double[nPoints];

        for (int i = 0; i < nPoints; i++) {
            xPointsD[i] = xPoints[i];
            yPointsD[i] = yPoints[i];
        }

        graphicsContext.strokePolygon(xPointsD, yPointsD, nPoints);
    }

    @Override
    public void strokeLine(int x1, int y1, int x2, int y2) {
        graphicsContext.strokeLine(x1, y1, x2, y2);
    }

    @Override
    public void strokeText(int x, int y, String text) {
        graphicsContext.strokeText(text, x, y);
    }

    @Override
    public void drawRasterImage(String id, byte[] data, int x, int y, int width, int height) {
        if (!cachedImages.containsKey(id)) {
            ByteArrayInputStream stream = new ByteArrayInputStream(data);
            cachedImages.put(id, new Image(stream));
        }
        try {
            graphicsContext.drawImage(cachedImages.get(id), x, y, width, height);
        } catch (Exception e) {
            System.err.println("Failed to draw raster image: " + e.getMessage());
        }
    }

    @Override
    public void purgeRasterImage(String id) {
        cachedImages.remove(id);
    }

    @Override
    public void setAspectRatio(int width, int height)
    {
        // Calulate the new width and height based on the aspect ratio
        double aspectRatio = (double) width / height;
        double newWidth = 1000;
        double newHeight = 1000;

        if (width > height) {
            newHeight = 1000 / aspectRatio;
        } else {
            newWidth = 1000 * aspectRatio;
        }

        this.width = (int) newWidth;
        this.height = (int) newHeight;

        if (fullyInitialized) {
            graphicsContext.getCanvas().setWidth(this.width);
            graphicsContext.getCanvas().setHeight(this.height);
        }
    }

    /**
     * Gets the JavaFX font object based on the current state.
     * 
     * @return JavaFX font object
     */
    protected Font getFont() {
        int size = state.getFontSize();
        javafx.scene.text.FontWeight weight = javafx.scene.text.FontWeight.findByName(state.getFontWeight().getValue());
        javafx.scene.text.FontPosture style = javafx.scene.text.FontPosture.REGULAR;

        if (state.getFontStyle() == FontStyle.ITALIC) {
            style = javafx.scene.text.FontPosture.ITALIC;
        }

        return Font.font(state.getFontFamily(), weight, style, size);
    }

    @Override
    public boolean isKeyPressed(String key) {
        KeyCode keyCode = KeyCode.valueOf(key);
        return pressedKeys.contains(keyCode);
    }

    @Override
    public String[] getPressedKeys() {
        String[] keys = new String[pressedKeys.size()];
        for (int i = 0; i < pressedKeys.size(); i++) {
            keys[i] = pressedKeys.get(i).toString();
        }
        return keys;
    }
}
