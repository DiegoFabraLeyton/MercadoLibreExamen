package model;

import Geometry.CollinearPoint;
import Geometry.Point;


import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;


public class SimulationSystem {


    private Point center;
    private List<Planet> planetList;
    private CollinearPoint model;

    private DayService repository;

    private int droughtCounter;
    private int optimalCounter;
    private int rainyCounter;
    private SystemReference reference;

    private Map<String,Double> rainiestDayMap;
    private Map<String,Integer> statistics;


    public SimulationSystem(Point center, List<Planet> planetList, CollinearPoint point, SystemReference reference, DayService repository) {
        this.center = center;
        this.planetList = planetList;
        this.model = point;
        this.repository = repository;
        this.reference = reference;
        initStatistic();
    }

    /**
     *
     * @param years
     * @return String, con todas las estadisticas de la simulación
     */
    public String getStatistic(@NotNull int years){
        final Map<String, Integer> simulate = simulate(years);
        final Map<String, Double> rainiestDayMap = rainiestDay();
        return String.format("drought periods :  %d , optimal periods:  %d, rainy periods:  %d, rainy day:  %s ",
                simulate.get(DROUGHT), simulate.get(OPTIMAL), simulate.get(RAINY), rainiestDayMap.entrySet().stream().findFirst().get());

    }

    /**
     *
     * @param years
     * @return Mapa con toda la simulación de los 3 planetas
     */
    private Map<String, Integer> simulate(final int years) {
        final List<Day> days = new ArrayList<>();
        final SolarSystem solarSystem = new SolarSystem(center, planetList, model,reference);
        for (int i = 1; i <= moveYears(years); i++) {
            solarSystem.move(i);
            boolean drought = solarSystem.isDrought();
            boolean optimalSystem = solarSystem.isOptimalSystem();
            final Map<Boolean, Double> solarSystemRainy = solarSystem.isRainy();
            if (drought) {
                optimalSystem = false;
                droughtCounter = handlerPeriodWeather(droughtCounter,i,DROUGHT);
                days.add(new Day(i,DROUGHT));
            }
            if (optimalSystem) {
                optimalCounter = handlerPeriodWeather(optimalCounter,i,OPTIMAL);
                days.add(new Day(i,OPTIMAL));
            }
            if(!solarSystemRainy.isEmpty()){
                rainyCounter = handlerPeriodWeather(rainyCounter,i,RAINY);
                rainiestDayMap.put(String.valueOf(i),solarSystemRainy.get(true));
                days.add(new Day(i,RAINY));
            }
        }
        repository.insertListDay(days);
        return statistics;
    }

    /*
        Maneja los peridoso de la simulación
     */
    private int handlerPeriodWeather(int weatherLastDay,final int day,final String weather){
        if(weatherLastDay != 0 && (day - weatherLastDay) != 1){
            addPeriodToWeatherMap(weather);
            return  0;
        }else
            return day;
    }

    private void addPeriodToWeatherMap(final String weather){
        final Integer value = statistics.get(weather);
        statistics.put(weather,value + 1);
    }


    /**
     *
     * @return Devuelve el día más lluvioso
     */
    private Map<String,Double> rainiestDay(){
        final Double maxValue = rainiestDayMap.values().stream().max(Comparator.naturalOrder()).orElse(0.0);
        return rainiestDayMap.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(maxValue))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

    }

    private void initStatistic(){
        this.statistics = new HashMap<>();
        statistics.put(DROUGHT,0);
        statistics.put(OPTIMAL,0);
        statistics.put(RAINY,0);
        this.droughtCounter = 0;
        this.optimalCounter = 0;
        this.rainyCounter = 0;
        this.rainiestDayMap = new HashMap<>();
    }

    private int moveYears(final int years) {
        return years * 365;
    }

    private static final String DROUGHT = "drought";
    private static final String OPTIMAL = "optimal";
    private static final String RAINY   = "rainy";


}
