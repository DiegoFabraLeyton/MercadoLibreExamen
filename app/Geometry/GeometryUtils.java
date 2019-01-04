package Geometry;

import com.google.inject.Singleton;
import org.apache.commons.math3.util.Precision;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class GeometryUtils implements CollinearPoint {


    @Override
    public boolean isInLine(@NotNull List<Point> points) {
        final List<Point> list = points.stream().distinct().collect(Collectors.toList());
        if (!list.isEmpty() && list.size() >= 3) {
            final Point a = points.get(0);
            final Point b = points.get(1);
            final List<Point> pointsToSolver = points.subList(2, points.size());
            for (final Point p : pointsToSolver) {
                if (!doOperation(a, b, p))
                    return false;
            }
            return true;
        }
        return false;
    }

    private boolean doOperation(Point x1, Point x2, Point x3) {
        return Precision.round((x1.getX() - x2.getX()) * (x2.getY() - x3.getY()) - ((x2.getX() - x3.getX()) * (x1.getY() - x2.getY())), 2) == 0.0;
    }
}
