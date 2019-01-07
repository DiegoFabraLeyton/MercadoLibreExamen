package model;

import Geometry.Angle;
import Geometry.Point;

/**
 * Interfaz que representa un sistema de referencia
 */
public interface SystemReference {

    Point getCoordinate(final Angle angle, final Double hypotenuse);
}
