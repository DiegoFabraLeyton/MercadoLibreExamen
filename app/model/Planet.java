package model;


import Geometry.Angle;
import Geometry.Point;
import Geometry.SENSE;
import Geometry.Velocity;


import javax.validation.constraints.NotNull;

/**
 * Clase que representa un planeta
 */
public class Planet implements CelestialObject {

    private final Velocity velocity;
    private final Double distanceToCenter;

    private Angle angle;
    private Point position;


    public Planet(@NotNull final Velocity velocity, @NotNull final Angle angle, @NotNull final Double distanceToCenter) {
        this.velocity = velocity;
        this.angle = angle;
        this.distanceToCenter = distanceToCenter;
    }

    Point getPosition() {
        return position;
    }

    private Angle moveAngle(int time){
        final Double angleToMove = time * velocity.getMagnitude();
        return (velocity.getSense().equals(SENSE.NEGATIVE)) ? angle.minusAngle(new Angle(angleToMove))
                : angle.sumAngle(new Angle(angleToMove));
    }

    @Override
    public String toString() {
        return "Planet{" +  "velocity=" + velocity + ", distanceToCenter=" + distanceToCenter + ", position=" + position + '}';
    }

    /**
     *
     * @param time, dias a moverse
     * @param reference, systema de referencia que se mueve. se hace por DI
     */
    @Override
    public void move(int time, SystemReference reference) {
        angle = moveAngle(time);
        this.position = reference.getCoordinate(angle,distanceToCenter);
    }
}
