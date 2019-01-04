package Geometry;


import org.apache.commons.math3.util.Precision;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.validation.constraints.NotNull;
import java.util.List;


public class Line implements Shape {

    private Point x1;
    private Point x2;


    public Line(@NotNull Point x1, @NotNull Point x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public void buildShape(List<Point> points) {
        this.x1 = points.get(0);
        this.x2 = points.get(1);
    }

    @Override
    public boolean isInInside(Point point) {
        throw new NotImplementedException();
    }

    @Override
    public Double perimeter() {
        double  number = Precision.round(Math.pow(x2.getX() - x1.getX(), 2) + Math.pow(x2.getY() - x1.getY(), 2),2);
        return  Precision.round(Math.sqrt(number),2);
    }



}
