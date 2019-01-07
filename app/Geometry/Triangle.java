package Geometry;

import java.util.List;


public class Triangle implements Shape {

    private Point pointX1;
    private  Point pointX2;
    private  Point pointX3;

    public  Triangle(){

    }

    public Triangle(final Point x1,final Point x2,final Point x3) {
        this.pointX1 = x1;
        this.pointX2 = x2;
        this.pointX3 = x3;
    }


    @Override
    public void buildShape(List<Point> points) {
        this.pointX1 = points.get(0);
        this.pointX2 = points.get(1);
        this.pointX3 = points.get(2);
    }

    @Override
    public boolean isInInside(Point point) {
        return pointInsideTriangle(point);
    }

    @Override
    public Double perimeter() {
        final Line a = new Line(pointX1,pointX2);
        final Line b = new Line(pointX1,pointX3);
        final Line c = new Line(pointX2,pointX3);
        return a.perimeter() + b.perimeter() + c.perimeter();
    }

    public boolean pointInsideTriangle(Point point){
        boolean orientationOne   = triangleOrientation(new Triangle(pointX1,pointX2,point));
        boolean orientationTwo   = triangleOrientation(new Triangle(pointX2,pointX3,point));
        boolean orientationThree = triangleOrientation(new Triangle(pointX3,pointX1,point));

        return ((orientationOne == orientationTwo) && (orientationOne == orientationThree) && (orientationTwo == orientationThree));

    }

    private  boolean triangleOrientation(final Triangle triangle){
        return ((triangle.pointX1.getX() - triangle.pointX3.getX()) * (triangle.pointX2.getY() - triangle.pointX3.getY())) -
                ((triangle.pointX1.getY()- triangle.pointX3.getY()) * (triangle.pointX2.getX() - triangle.pointX3.getX())) >= 0 ;
    }


}
