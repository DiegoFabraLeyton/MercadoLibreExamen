package Geometry;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GeometryUtilsTest {

    private Point x1;
    private Point x2;
    private Point x3;
    private CollinearPoint point;

    @Before
    public void setUp(){
        x1 = new Point(0.0,0.0);
        x2 = new Point(1.0,1.0);
        x3 = new Point(2.0,2.0);
        point = new GeometryUtils();
    }

    @Test
    public void pointInLineTest() {

        boolean inLine = point.isInLine(Arrays.asList(x1, x2, x3));
        assertThat(true, is(equalTo(inLine)));

        x3 = new Point(7.3, 1.0);
        inLine = point.isInLine(Arrays.asList(x1, x2, x3));
        assertThat(false, is(equalTo(inLine)));
    }

    @Test
    public void isInLineWithFourPoints(){
        boolean inLine = point.isInLine(Arrays.asList(x1, x2, x3, new Point(3.0,3.0)));
        assertThat(true, is(equalTo(inLine)));
    }

    @Test
    public void isInLineWithPointDifferentTZero(){
        x1 = new Point(0.0,1.0);
        x2 = new Point(1.0,2.0);
        x3 = new Point(-1.0,0.0);
        boolean inLine = point.isInLine(Arrays.asList(x1,x2,x3));
        assertThat(true, is(equalTo(inLine)));
    }

    @Test
    public void  isLessThanThree(){
        x1 = new Point(0.0,1.0);
        x2 = new Point(1.0,2.0);
        List<Point> pointList =  new ArrayList<>();
        pointList.add(x1);
        pointList.add(x2);

        assertThat(point.isInLine(pointList),is(equalTo(false)));
    }

}
