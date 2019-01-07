package controllers;

import com.google.inject.Inject;
import model.Day;
import model.DayRepository;
import play.libs.Json;
import play.mvc.*;

import java.util.Optional;


/**
 * Esta clase contiene un action que maneja el http request de DayController
 */
public class DayController extends Controller {

    private DayRepository dayRepository;

    @Inject
    DayController(DayRepository dayRepository){
        this.dayRepository = dayRepository;
    }


    /**
     *
     * @param date
     * @return el número de day y el clima en formatoJson o
     * retorna un 204 si el dia no es encontrado
     */
    public Result show(int date){
        final Optional<Day> day =dayRepository.findDay(date);
        if(day.isPresent())
            return ok(Json.toJson(day.get()));
        return  noContent();
    }
}
