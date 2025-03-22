package com.nooblab.util;

import java.util.ArrayList;
import com.nooblab.element.Element;

/**
 * A specialized list for managing {@link Element} objects.
 * <p>
 * This class extends {@link ArrayList} and provides additional utility
 * methods for searching and removing elements by their unique identifier.
 * </p>
 *
 * @param <T> The type of elements in this list, restricted to {@link Element} or its subclasses.
 *
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public class ElementList<T extends Element> extends ArrayList<T> {

    /**
     * Finds an {@link Element} in the list by its unique identifier.
     * <p>
     * Iterates through the list and returns the first element whose ID matches the given value.
     * If no matching element is found, returns {@code null}.
     * </p>
     * @param <T>
     *
     * @param id The unique identifier of the element to find.
     * @return The {@link Element} with the specified ID, or {@code null} if not found.
     */
    public T findByID(String id) {
        for (T element : this) {
            if (element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }

    /**
     * Removes an {@link Element} from the list by its unique identifier.
     * <p>
     * If an element with the given ID is found, it is removed from the list.
     * If no matching element is found, the list remains unchanged.
     * </p>
     *
     * @param id The unique identifier of the element to remove.
     */
    public void removeByID(String id) {
        for (T element : this) {
            if (element.getId().equals(id)) {
                this.remove(element);
                return;
            }
        }
    }
}
