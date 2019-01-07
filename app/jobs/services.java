package jobs;

import Geometry.*;
import akka.actor.ActorSystem;
import com.google.inject.Inject;
import model.*;
import scala.concurrent.ExecutionContext;
import scala.concurrent.duration.Duration;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 *  Clase que realiza el servicio de simulacion del sistema planetario
 */
public class services {

     private final CollinearPoint modelDI;
     private final SystemReference referenceDI;
     private final DayService repositoryDI;
     private final ExecutionContext executionContext;
     private final ActorSystem actorSystem;


    /**
     * Injecto todas las dependencias del sistema
     *
     * @param modelDI
     * @param referenceDI
     * @param repositoryDI
     * @param executionContext
     * @param actorSystem
     */

    @Inject
    public services(CollinearPoint modelDI, SystemReference referenceDI, DayService repositoryDI, ExecutionContext executionContext, ActorSystem actorSystem) {
        this.modelDI = modelDI;
        this.referenceDI = referenceDI;
        this.repositoryDI = repositoryDI;
        this.executionContext = executionContext;
        this.actorSystem = actorSystem;
        this.initialize();
    }

    /**
     * Inicializa el Job para correr una vez al dia
     */
    private void initialize(){
        this.actorSystem.scheduler().schedule(
                Duration.create(1, TimeUnit.SECONDS), // initialDelay
                Duration.create(24, TimeUnit.HOURS), // interval
                this::simulateSystem,
                this.executionContext
        );
    }


    /**
     * Se inicializa los planetas, y se comienza la simulación
     */
    private void simulateSystem() {

        repositoryDI.deleteDaysCollection();
        final List<Planet> planets;planets = new ArrayList<>();

        final Velocity velocityFerengi = new Velocity(1.0, SENSE.NEGATIVE);
        final Angle angle = new Angle(90.0);
        final Planet ferengi = new Planet(velocityFerengi, angle, 500.0);
        planets.add(ferengi);

        final Velocity velocityBetasoide = new Velocity(3.0, SENSE.NEGATIVE);
        final Angle angleBetasoide = new Angle(90.0); //59.7
        final Planet betasoide = new Planet(velocityBetasoide, angleBetasoide, 2000.0);
        planets.add(betasoide);

        final Velocity velocityVulcano = new Velocity(5.0, SENSE.POSITIVE);
        final Angle angleVulcano = new Angle(90.0); // 70.8
        final Planet vulcano = new Planet(velocityVulcano, angleVulcano, 1000.0);
        planets.add(vulcano);

        final SimulationSystem system = new SimulationSystem(new Point(0.0,0.0),planets,modelDI,referenceDI,repositoryDI);
        final SimulationObject object = new SimulationObject();
        final String statistic = system.getStatistic(10);
        object.setInformationFormat(statistic);
        repositoryDI.insertSimulation(object);


    }
}
