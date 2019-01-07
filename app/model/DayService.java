package model;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;


import java.util.List;
import java.util.Optional;


/**
 * Clase que implenetar el repository, esta se hace a traves de Mongo DB
 */
@Singleton
public class DayService implements DayRepository {

    private DBConnection connection;

    @Inject
    public DayService(DBConnection connection){
        this.connection = connection;
    }

    @Override
    public void insertListDay(List<Day> dayList){
        days().insert(dayList.toArray());
    }

    @Override
    public Optional<Day> findDay(int date) {
        final MongoCursor<Day> as = days().find("{date:#}", date).as(Day.class);
        Optional<Day> dayOptional = Optional.ofNullable((as.hasNext()? as.next(): null));
        return dayOptional;
    }

    private MongoCollection days() {
     return  connection.getConnection().getCollection("Days");
    }

    public void deleteDaysCollection(){
        days().drop();
    }


}
