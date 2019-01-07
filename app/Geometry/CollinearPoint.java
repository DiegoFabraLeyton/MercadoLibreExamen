package Geometry;

import java.util.List;

/**
 * Interfaz para determinar punto colineales
 */
public interface CollinearPoint {

    /**
     *
     * @param points
     * @return true, si la lista de puntos estan en la misma recta
     */
    boolean isInLine(final List<Point> points);
}
