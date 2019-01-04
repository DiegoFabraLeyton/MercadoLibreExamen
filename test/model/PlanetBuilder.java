package model;

import Geometry.Angle;
import Geometry.SENSE;
import Geometry.Velocity;

public class PlanetBuilder {

    private Velocity velocity;
    private Double distance;
    private Angle angle;
    private SystemReference reference;



    public Planet build(){
        return new Planet(velocity,angle,distance);
    }

    public PlanetBuilder withVelocity(Double magnitude, SENSE sense){
        this.velocity = new Velocity(magnitude,sense);
        return this;
    }

    public PlanetBuilder withDistanceToSun(Double distance){
        this.distance = distance;
        return this;
    }

    public PlanetBuilder withAngle(Double number){
        this.angle = new Angle(number);
        return this;
    }

    public PlanetBuilder withSystemReference(SystemReference reference){
        this.reference = reference;
        return this;
    }
}
