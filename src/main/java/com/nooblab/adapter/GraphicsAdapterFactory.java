package com.nooblab.adapter;

/**
 * Factory class for creating instances of {@link GraphicsAdapter}.
 * <p>
 * This class automatically selects and returns an appropriate implementation of
 * {@link GraphicsAdapter} based on the available graphics libraries or runtime environment.
 * The implementation uses reflection to determine the best suitable adapter.
 * </p>
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public class GraphicsAdapterFactory {
    /**
     * Returns an instance of a suitable {@link GraphicsAdapter} implementation.
     * <p>
     * The selection process determines the best available graphics adapter at runtime.
     * If no suitable adapter is found, this method throws an exception.
     * </p>
     *
     * @return an instance of {@link GraphicsAdapter}.
     * @throws IllegalStateException if no suitable adapter is found.
     */
    public static GraphicsAdapter getGraphicsAdapter() {

        // Check if JavaFX is available
        try {
            Class.forName("javafx.application.Application");
            return new JavaFXGraphicsAdapter();
        } catch (ClassNotFoundException e) {
            // JavaFX is not available
        }

        throw new IllegalStateException("No suitable GraphicsAdapter implementation found.");
    }

    /**
     * Returns an instance of a specific {@link GraphicsAdapter} implementation by name.
     * <p>
     * This method looks up and returns a named adapter if it is available.
     * If the provided name does not match a known implementation, an exception is thrown.
     * </p>
     *
     * @param adapterName The name of the desired {@link GraphicsAdapter} implementation.
     * @return an instance of the specified {@link GraphicsAdapter}.
     * @throws IllegalArgumentException if the adapter name is invalid or not found.
     */
    public static GraphicsAdapter getGraphicsAdapterByName(String adapterName) {
        switch (adapterName) {
            case "javafx":
                return new JavaFXGraphicsAdapter();
            default:
                throw new IllegalArgumentException("Invalid GraphicsAdapter name: " + adapterName);
        }
    }
}
