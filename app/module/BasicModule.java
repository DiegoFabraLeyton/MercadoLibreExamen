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

        bind(SystemReference.class).to(CartesianCoordinate.class).asEagerSingleton();
        bind(CollinearPoint.class).to(GeometryUtils.class).asEagerSingleton();
        bind(DBConnection.class).asEagerSingleton();
        bind(DayRepository.class).to(DayService.class).asEagerSingleton();
        bind(services.class).asEagerSingleton();
    }
}