package Geometry;

import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class ShapeTest {
    private Point x1;
    private Point x2;
    private Point x3;

    @Before
    public void  setUp(){
        x1 = new Point(-2.0,0.0);
        x2 = new Point(2.0,0.0);
        x3 = new Point(0.0,5.0);
    }

    @Test
    public void triangleShapeWithListOfPointTestInsidePoint(){
       final List<Point> pointList = Arrays.asList(x1,x2,x3);
       final Shape shape = new Triangle();
       shape.buildShape(pointList);
       assertThat(true, is(equalTo(shape.isInInside(new Point(0.0,2.0)))));
       assertThat(true, is(equalTo(shape.isInInside(new Point(1.0,1.0)))));
    }

    @Test
    public void triangleShapeWithConstructorInsidePointTest(){
        final Shape shape = new Triangle(x1,x2,x3);
        assertThat(true, is(equalTo(shape.isInInside(new Point(0.0,2.0)))));
        assertThat(true, is(equalTo(shape.isInInside(new Point(1.0,1.0)))));
    }

    @Test
    public void triangleShapeWithListOfPointOutSidePointTest(){
        final List<Point> pointList = Arrays.asList(x1,x2,x3);
        final Shape shape = new Triangle();
        shape.buildShape(pointList);
        assertThat(false, is(equalTo(shape.isInInside(new Point(3.0,0.0)))));
        assertThat(false, is(equalTo(shape.isInInside(new Point(3.0,1.0)))));
    }

    @Test
    public  void triangleShapeWithConstructorOutSidePointTest(){
        final Shape shape = new Triangle(x1,x2,x3);
        assertThat(false, is(equalTo(shape.isInInside(new Point(3.0,2.0)))));
        assertThat(false, is(equalTo(shape.isInInside(new Point(3.0,1.0)))));
    }

    @Test
    public void triangleShapePerimeterTest(){
        x1 = new Point(0.0,0.0);
        x2 = new Point(3.0,0.0);
        x3 = new Point(0.0,4.0);

        final Shape shape = new Triangle();
        shape.buildShape( Arrays.asList(x1,x2,x3));
        assertThat(12.0, is(equalTo(shape.perimeter())));
    }

    @Test
    public void lineShapePerimeterTest(){
        x1 = new Point(0.0,0.0);
        x2 = new Point(3.0,0.0);
        x3 = new Point(0.0,4.0);

        final Shape shape = new Line(x1,x2);
        assertThat(3.0, is(equalTo(shape.perimeter())));

        shape.buildShape(Arrays.asList(x1,x3));
        assertThat(4.0, is(equalTo(shape.perimeter())));

        shape.buildShape(Arrays.asList(x2,x3));
        assertThat(5.0,is(equalTo(shape.perimeter())));

    }

    @Test(expected = NotImplementedException.class)
    public void isInInsideNotImplementMethod(){
        x1 = new Point(0.0,0.0);
        x2 = new Point(3.0,0.0);
        x3 = new Point(0.0,4.0);

        final Shape shape = new Line(x1,x2);
        shape.isInInside(x3);
    }


}
