package Geometry;


import com.google.inject.Singleton;
import model.SystemReference;
import org.apache.commons.math3.util.Precision;

import javax.validation.constraints.NotNull;

/**
 *  Clase que implementa un sistema de referencia
 *  En esta caso en coordenadas cartesianas.
 */
@Singleton
public class CartesianCoordinate implements SystemReference {

    /**
     * Se hace la operación mediante relación trigonométrica para obtener un punto
     *
     * @param angle
     * @param hypotenuse
     * @return Point
     */
    @Override
    public Point getCoordinate(@NotNull final Angle angle, @NotNull final Double hypotenuse){
       return new Point(getCosX(angle,hypotenuse), getSinX(angle,hypotenuse));
    }

    /**
     *
     * @param angle
     * @param hypotenuse
     * @return Double, punto en X
     */
    private Double getSinX(final Angle angle, final Double hypotenuse){
        return Precision.round(hypotenuse * Math.sin(Math.toRadians(angle.getNumber())),2);
    }

    /**
     *
     * @param angle
     * @param hypotenuse
     * @return Double, Punto en Y
     */

    private Double getCosX(final Angle angle, final Double hypotenuse){
        return( angle.getNumber().equals(270.0)) ? 0.0 : Precision.round(hypotenuse * Math.cos(Math.toRadians(angle.getNumber())),2);
    }

}
