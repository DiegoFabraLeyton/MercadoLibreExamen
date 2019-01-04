package model;


import java.util.List;
import java.util.Optional;

public interface DayRepository {

    Optional<Day> findDay(int date);

   void insertListDay(List<Day> dayList);

}
