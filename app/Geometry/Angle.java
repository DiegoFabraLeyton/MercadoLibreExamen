package Geometry;


import javax.validation.constraints.NotNull;

public class Angle {

    private Double number;

    public Angle(Double number) {
        this.number = number;
    }

    public Double getNumber() {
        return number;
    }

    public Angle sumAngle(@NotNull final Angle angle) {
        final Double result = number + angle.getNumber();
        return (result < 360.0) ? new Angle(result) : new Angle(result % 360.0);
    }

    public Angle minusAngle(@NotNull final Angle angle) {
        final Double result = number - angle.getNumber();
        return (result >= 0) ? new Angle(result) : new Angle(360.0 + result);
    }
}
