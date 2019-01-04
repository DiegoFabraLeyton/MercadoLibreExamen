package model;

import Geometry.Angle;
import Geometry.Point;

public interface SystemReference {

    Point getCoordinate(final Angle angle, final Double hypotenuse);
}
