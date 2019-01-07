package controllers;

import com.google.inject.Inject;
import model.Day;
import model.DayRepository;
import play.libs.Json;
import play.mvc.*;

import java.util.Optional;


/*

*/
public class DayController extends Controller {

    private DayRepository dayRepository;

    @Inject
    DayController(DayRepository dayRepository){
        this.dayRepository = dayRepository;
    }


    public Result show(int date){
        final Optional<Day> day =dayRepository.findDay(date);
        if(day.isPresent())
            return ok(Json.toJson(day.get()));
        return  noContent();
    }
}
