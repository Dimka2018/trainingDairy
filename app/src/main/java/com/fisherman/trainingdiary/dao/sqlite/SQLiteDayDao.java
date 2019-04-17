package com.fisherman.trainingdiary.dao.sqlite;

import com.fisherman.trainingdiary.dao.DayDao;
import com.fisherman.trainingdiary.entity.Day;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SQLiteDayDao implements DayDao {

    private com.fisherman.trainingdiary.entity.DayDao dayDao;

    @Override
    public Day saveDay(Day day) {
        dayDao.insert(day);
        return day;
    }

    @Override
    public void deleteDay(Day day) {
        dayDao.delete(day);
    }

    @Override
    public List<Day> getDayListForWorkout(Long workoutId) {
        return dayDao.queryBuilder()
                .where(com.fisherman.trainingdiary.entity.DayDao.Properties.WorkoutId.eq(workoutId))
                .list();
    }
}
