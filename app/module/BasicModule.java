package module;



import Geometry.CartesianCoordinate;
import Geometry.CollinearPoint;
import Geometry.GeometryUtils;
import com.google.inject.AbstractModule;
import jobs.services;
import model.DBConnection;
import model.DayRepository;
import model.DayService;
import model.SystemReference;


public class BasicModule extends AbstractModule {

    @Override
    protected void configure() {

        //Injecta la dependenica de SystemReference como CartesianCoordinate tan pronto se utilice
        bind(SystemReference.class).to(CartesianCoordinate.class).asEagerSingleton();
        //Injecta la dependenica de CollinearPoint como GeometryUtils tan pronto se utilice
        bind(CollinearPoint.class).to(GeometryUtils.class).asEagerSingleton();
        bind(DBConnection.class).asEagerSingleton();
        //Injecta la dependencia de DayRepository como DayServuce tan pronto se utilice
        bind(DayRepository.class).to(DayService.class).asEagerSingleton();
        //Bideo que hace el Job se ejecute cuando inicie la applicación
        bind(services.class).asEagerSingleton();
    }
}