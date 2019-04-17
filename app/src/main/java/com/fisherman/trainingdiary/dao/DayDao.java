package com.fisherman.trainingdiary.dao;

import com.fisherman.trainingdiary.entity.Day;

import java.util.List;

public interface DayDao {

    Day saveDay(Day day);

    List<Day> getDayListForWorkout(Long workoutId);

    void deleteDay (Day day);

}
