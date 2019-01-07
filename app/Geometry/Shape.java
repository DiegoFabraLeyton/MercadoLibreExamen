package Geometry;

import java.util.List;

/**
 * Interfaz que reperesenta una figura geométrica
 */
public interface Shape {

    /**
     *  Método que construye una figura geometrica con puntos
     * @param points
     */
    void buildShape(List<Point> points);

    boolean isInInside(Point point);

    Double perimeter();
}
