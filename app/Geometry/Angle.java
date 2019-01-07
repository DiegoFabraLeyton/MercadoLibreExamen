package Geometry;


import javax.validation.constraints.NotNull;

/**
 * Clase que representa un Ángulo
 */
public class Angle {

    private Double number;

    public Angle(Double number) {
        this.number = number;
    }

    public Double getNumber() {
        return number;
    }

    /**
     * Este método suma dos ángulos y siempre queda entre 0 y 360
     *
     * @param angle
     * @return angle
     */
    public Angle sumAngle(@NotNull final Angle angle) {
        final Double result = number + angle.getNumber();
        return (result < 360.0) ? new Angle(result) : new Angle(result % 360.0);
    }

    /**
     * Este método resta dos ángulos y siempre queda entre 0 y 360
     *
     * @param angle
     * @return angle
     */
    public Angle minusAngle(@NotNull final Angle angle) {
        final Double result = number - angle.getNumber();
        return (result >= 0) ? new Angle(result) : new Angle(360.0 + result);
    }
}
