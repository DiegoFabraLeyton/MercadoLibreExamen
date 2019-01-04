package Geometry;


import com.google.inject.Singleton;
import model.SystemReference;
import org.apache.commons.math3.util.Precision;

import javax.validation.constraints.NotNull;

@Singleton
public class CartesianCoordinate implements SystemReference {


    @Override
    public Point getCoordinate(@NotNull final Angle angle, @NotNull final Double hypotenuse){
       return new Point(getCosX(angle,hypotenuse), getSinX(angle,hypotenuse));
    }

    private Double getSinX(final Angle angle, final Double hypotenuse){
        return Precision.round(hypotenuse * Math.sin(Math.toRadians(angle.getNumber())),2);
    }

    private Double getCosX(final Angle angle, final Double hypotenuse){
        return( angle.getNumber().equals(270.0)) ? 0.0 : Precision.round(hypotenuse * Math.cos(Math.toRadians(angle.getNumber())),2);
    }

}
