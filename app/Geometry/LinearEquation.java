package Geometry;


import com.google.inject.Singleton;
import org.apache.commons.math3.util.Precision;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Implementación de CollinearPoint. Método Ecuación lineal para saber si los puntos
 * perternece a un recta
 */
@Singleton
public class LinearEquation implements CollinearPoint {

    private Point x1;
    private Point x2;

    LinearEquation(){}


    LinearEquation(@NotNull Point x1, @NotNull Point x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    /**
     *
     * @param points
     * @return true, si los puntos satisfacen la solucion de la recta
     */
     boolean isSolution(@NotNull List<Point> points){
        for(final Point point: points){
            double solution = solve(point.getX());
            if(point.getY() != solution)
                return false;
        }
        return true;
    }

    void buildNewGradient(@NotNull Point a,@NotNull Point b){
        x1 = a;
        x2 = b;
    }

    /**
     *
     * @param x, Valor a reemplazar en la ecuación
     * @return Double, la solución de la recta
     */

    private Double solve(@NotNull final Double x){
        return Precision.round( buildGradient() * x  + buildIntercept(),2);
    }

    /**
     *
     * @return Double, el valor de la pendiente de la recta
     */
    private Double buildGradient(){
        return  Precision.round((x2.getY() - x1.getY())/(x2.getX() - x1.getY()),2);
    }

    /**
     *
     * @return Double, el punto de corte con el eje X
     */
    private Double buildIntercept(){
        return Precision.round( -(buildGradient() * x1.getX()) + x1.getY(),2);
    }

    @Override
    public boolean isInLine(@NotNull List<Point> points) {
        if(!points.isEmpty() && points.size() >= 3){
            buildNewGradient(points.get(0),points.get(1));
            return isSolution(points.subList(2,points.size()));
        }
        return false;
    }
}
