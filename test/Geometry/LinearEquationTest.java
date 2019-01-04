package Geometry;


import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LinearEquationTest {

    private LinearEquation equation;

    @Test
    public void solvingAValidEquation(){
        final Point a = new Point(0.0,0.0);
        final Point b = new Point(2.0,2.0);
        equation = new LinearEquation(a,b);
        final List<Point> solution = new ArrayList<>();
        solution.add(new Point(3.0,3.0));

        assertThat(equation.isSolution(solution), is(equalTo(true)));

        equation.buildNewGradient(new Point(0.0,0.0), new Point(1.0, 2.0));
        final List<Point> points = new ArrayList<>();
        points.add(new Point(2.0,4.0));
        points.add(new Point(-1.0,-2.0));

        assertThat(equation.isSolution(points),is(equalTo(true)));
    }

    @Test
    public void isInLineTest(){

        final Point a = new Point(0.0,0.0);
        final Point b = new Point(2.0,2.0);
        final Point c = new Point(4.0,4.0);

        final List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        equation = new LinearEquation();
        assertThat(equation.isInLine(points), is(equalTo(true)));
    }

    @Test
    public void isNotInLine(){
        final Point a = new Point(0.0,0.0);
        final Point b = new Point(2.0,2.0);
        final Point c = new Point(0.0,-4.0);

        final List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        equation = new LinearEquation();
        assertThat(equation.isInLine(points), is(equalTo(false)));
    }

    @Test
    public void planetListLessThanThreeTest(){
        final Point a = new Point(0.0,0.0);
        final Point b = new Point(2.0,2.0);


        final List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        equation = new LinearEquation();
        assertThat(equation.isInLine(points), is(equalTo(false)));
    }





}
