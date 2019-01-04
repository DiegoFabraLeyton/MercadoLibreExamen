package Geometry;

import org.junit.Test;

import java.util.function.BiFunction;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AngleTest {


    @Test
    public void sumAngleTest(){
        Angle a = new Angle(0.0);
        final Angle b = a.sumAngle(new Angle(90.0));
        assertThat(b.getNumber(), is(equalTo(90.0)));

        final Angle c = b.sumAngle(new Angle(10.0));
        assertThat(c.getNumber(), is(equalTo(100.0)));

        final Angle d = c.sumAngle(new Angle(260.0));
        assertThat(d.getNumber(), is(equalTo(0.0)));

        BiFunction<Point,Point,Double> distance = ((point, point2) -> Math.sqrt(point.getY()- point2.getX()));


    }

    @Test
    public void minusAngleTest(){
        Angle a = new Angle(0.0);
        final Angle b = a.minusAngle(new Angle(30.0));
        assertThat(b.getNumber(), is(equalTo(330.0)));

        final Angle c = b.minusAngle(new Angle(30.0));
        assertThat(c.getNumber(), is(equalTo(300.0)));

        final Angle d =  c.minusAngle(new Angle(300.0));
        assertThat(d.getNumber(), is(equalTo(0.0)));


    }
}
