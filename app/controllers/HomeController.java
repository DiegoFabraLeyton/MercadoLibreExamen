package controllers;

import com.google.inject.Inject;
import model.DayRepository;
import model.SimulationObject;
import play.libs.Json;
import play.mvc.*;

import java.util.Optional;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private DayRepository dayRepository;

    @Inject
    HomeController(DayRepository dayRepository){
        this.dayRepository = dayRepository;
    }

    public Result index() {
        final Optional<SimulationObject> simulation = dayRepository.findSimulation();
        if(simulation.isPresent())
            return ok(Json.toJson(simulation.get()));
        return  noContent();
    }

}
