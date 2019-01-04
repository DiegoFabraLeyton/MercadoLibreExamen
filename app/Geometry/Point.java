package Geometry;

public class Point {

    private final double X;
    private final double Y;

    public Point(double x, double y) {
        X = x;
        Y = y;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "Point{" +  "X=" + X +  ", Y=" + Y +  '}';
    }


}
