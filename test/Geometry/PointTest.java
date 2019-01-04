package Geometry;

import org.junit.Test;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class PointTest {

    @Test
    public void toStringTest(){
        final String pointFormat = String.format(Locale.US,"Point{X=%1.1f, Y=%1.1f}", 2.0, 3.0);
        final Point point = new Point(2.0,3.0);
        assertThat(pointFormat,is(equalTo(point.toString())));
    }
}
