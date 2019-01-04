package Geometry;


import com.google.inject.Singleton;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class CartesianCoordinateTest {

    private CartesianCoordinate coordinate;
    private Angle angle;

    @Before
    public void setUp(){
        coordinate = new CartesianCoordinate();
    }

    @Test
    public void getCoordinateWithAnglePositive(){
        Double hypotenuse = 1.0;
        angle = new Angle(90.0);
        final Point a = this.coordinate.getCoordinate(angle, hypotenuse);
        assertThat(a.getX(),is(equalTo(0.0)));
        assertThat(a.getY(),is(equalTo(1.0)));
    }

    @Test
    public void getCoordinateWithAngleNegative(){
        Double hypotenuse = 1.0;
        angle = new Angle(-90.0);
        final Point a = this.coordinate.getCoordinate(angle, hypotenuse);
        assertThat(a.getX(),is(equalTo(0.0)));
        assertThat(a.getY(),is(equalTo(-1.0)));
    }
}
