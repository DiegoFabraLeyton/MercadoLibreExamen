package model;

import Geometry.*;
import com.google.inject.Inject;


import java.util.*;
import java.util.stream.Collectors;

public class SolarSystem {


    private final Point sun;
    private final List<Planet> planetList;

    @Inject
    private final CollinearPoint model;

    @Inject
    private final SystemReference reference;
    private Shape shape;


    public SolarSystem(final Point sun, final List<Planet> planets, final CollinearPoint model,final SystemReference reference) {
        this.sun = sun;
        this.planetList = planets;
        this.model = model;
        this.reference = reference;
    }


    boolean isDrought() {
        if (!planetList.isEmpty() && planetList.size() == 3) {
            final List<Point> points = getPlanetPosition();
            points.add(sun);
            return model.isInLine(points);
        }
        return false;
    }

    boolean isOptimalSystem() {
        if (!planetList.isEmpty() && planetList.size() == 3) {
            return model.isInLine(getPlanetPosition());
        }
        return false;
    }

    private List<Point> getPlanetPosition() {
        final List<Point> points = new ArrayList<>();
        planetList.forEach(e -> points.add(e.getPosition()));
        return points;
    }

    Map<Boolean, Double> isRainy() {
        final List<Planet> planets = removeDuplicatePlanets();
        if (!planets.isEmpty() && planets.size() == 3) {
            return getSolarSystemPerimeter();
        }
        return new HashMap<>();
    }

    private Map<Boolean,Double> getSolarSystemPerimeter(){
        final Map<Boolean, Double> result = new HashMap<>();
        shape = new Triangle();
        shape.buildShape(getPlanetPosition());
        boolean isInside = shape.isInInside(sun);
        if(isInside){
            result.put(true, shape.perimeter());
        }
        return result;
    }

    private List<Planet> removeDuplicatePlanets(){
        return planetList.stream().distinct().collect(Collectors.toList());
    }

    void move(int days) {
        planetList.forEach(e -> e.move(days,reference));
    }
}







