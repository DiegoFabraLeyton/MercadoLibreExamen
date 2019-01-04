package Geometry;

import java.util.List;

public interface Shape {

    void buildShape(List<Point> points);

    boolean isInInside(Point point);

    Double perimeter();
}
