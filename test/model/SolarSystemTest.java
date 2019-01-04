package model;

import Geometry.CollinearPoint;
import Geometry.Point;
import Geometry.SENSE;
import com.google.inject.Guice;
import com.google.inject.Injector;
import module.BasicModule;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;

public class SolarSystemTest {

    private Point sun;
    private CollinearPoint collinearPoint = mock(CollinearPoint.class);
    private SystemReference reference = mock(SystemReference.class);

    @Before
    public void setUp(){
        sun = new Point(0.0,0.0);
    }


    @Test
    public void returnFalseWithOnlyTwoPlanets(){


        final Planet one =  new PlanetBuilder()
                                    .withAngle(0.0)
                                    .withDistanceToSun(1.0)
                                    .withSystemReference(reference)
                                    .withVelocity(1.0,SENSE.POSITIVE)
                                    .build();

        final Planet two = new PlanetBuilder()
                .withAngle(0.0)
                .withDistanceToSun(2.0)
                .withSystemReference(reference)
                .withVelocity(1.0,SENSE.POSITIVE)
                .build();

        final SolarSystem solarSystem = new SolarSystem(sun, Arrays.asList(one,two),collinearPoint,reference);
        assertThat(false, is(equalTo(solarSystem.isOptimalSystem())));
        assertThat(false,is(equalTo(solarSystem.isDrought())));
        final Map<Boolean, Double> rainy = solarSystem.isRainy();
        assertThat(true, is(equalTo(rainy.isEmpty())));

    }

    @Test
    public void returnFalseWithPlanetsInSamePosition(){
        final Planet one =  new PlanetBuilder()
                .withAngle(0.0)
                .withDistanceToSun(1.0)
                .withSystemReference(reference)
                .withVelocity(1.0,SENSE.POSITIVE)
                .build();

        final SolarSystem solarSystem = new SolarSystem(sun, Arrays.asList(one,one,one),collinearPoint,reference);
        assertThat(false, is(equalTo(solarSystem.isOptimalSystem())));
        assertThat(false,is(equalTo(solarSystem.isDrought())));
        final Map<Boolean, Double> rainy = solarSystem.isRainy();
        assertThat(true, is(equalTo(rainy.isEmpty())));

    }

    @Test
    public void isRainyTest(){

    }




}
