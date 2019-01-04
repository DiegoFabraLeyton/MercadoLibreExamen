package model;

import Geometry.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import module.BasicModule;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlanetTest {

    private Velocity velocity;
    private Planet vulcano;

    @Test
    public void movePlanetTest(){
        Double magnitude = 1.0;
        velocity = new Velocity(magnitude,SENSE.POSITIVE);
        final Angle angle = mock(Angle.class);

        when(angle.getNumber()).thenReturn(0.0);
        when(angle.sumAngle(any(Angle.class))).thenReturn(new Angle(0.0));

        vulcano = new Planet(velocity,angle,500.0);
        SystemReference coordinateMock = Mockito.mock(CartesianCoordinate.class);
        when(coordinateMock.getCoordinate(any(Angle.class),anyDouble())).thenReturn(new Point(500.0,0.0));

        vulcano.move(0,coordinateMock);
        assertThat(vulcano.getPosition().getX(),is(equalTo(500.0)));
        assertThat(vulcano.getPosition().getY(),is(equalTo(0.0)));

    }

    @Test
    public void movePlanetClockWise(){
        Double magnitude = 1.0;
        velocity = new Velocity(magnitude,SENSE.NEGATIVE);

        final Angle angle = mock(Angle.class);

        when(angle.getNumber()).thenReturn(270.0);
        when(angle.minusAngle(any(Angle.class))).thenReturn(new Angle(180.0));

        vulcano = new Planet(velocity,angle,500.0);
        SystemReference coordinateMock = Mockito.mock(CartesianCoordinate.class);
        when(coordinateMock.getCoordinate(any(Angle.class),anyDouble())).thenReturn(new Point(-500.0,0.0));

        vulcano.move(180,coordinateMock);
        assertThat(vulcano.getPosition().getX(),is(equalTo(-500.0)));
        assertThat(vulcano.getPosition().getY(),is(equalTo(0.0)));

    }

}
