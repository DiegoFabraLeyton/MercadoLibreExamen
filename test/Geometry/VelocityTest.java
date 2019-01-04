package Geometry;

import org.junit.Test;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class VelocityTest {

    @Test
    public void getVelocityInformationTest(){
        final Double magnitude = 1.0;
        final SENSE sense = SENSE.POSITIVE;
        final Velocity velocity = new Velocity(magnitude,sense);
        final String velocityFormat = String.format(Locale.US,"Velocity{magnitude=%1.1f, sense=%S}",magnitude,sense);

        assertThat(1.0, is(equalTo(velocity.getMagnitude())));
        assertThat(sense,is(equalTo(velocity.getSense())));
        assertThat(velocityFormat, is(equalTo(velocity.toString())));

        System.out.println(velocity.toString());
    }
}
