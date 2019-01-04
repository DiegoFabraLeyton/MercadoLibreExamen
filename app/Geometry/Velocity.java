package Geometry;

public class Velocity {

    private Double magnitude;
    private SENSE sense;

    public Velocity(Double magnitude, SENSE sense) {
        this.magnitude = magnitude;
        this.sense = sense;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public SENSE getSense() {
        return sense;
    }

    @Override
    public String toString() {
        return "Velocity{" + "magnitude=" + magnitude + ", sense=" + sense + '}';
    }
}
