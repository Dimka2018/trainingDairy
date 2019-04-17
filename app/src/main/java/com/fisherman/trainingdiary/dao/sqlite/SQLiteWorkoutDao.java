package com.fisherman.trainingdiary.dao.sqlite;

import com.fisherman.trainingdiary.dao.WorkoutDao;
import com.fisherman.trainingdiary.entity.DaoSession;
import com.fisherman.trainingdiary.entity.Day;
import com.fisherman.trainingdiary.entity.TrainingPart;
import com.fisherman.trainingdiary.entity.Workout;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SQLiteWorkoutDao implements WorkoutDao {

    private DaoSession daoSession;

    @Override
    public List<Workout> getWorkoutList(Long profileId) {
        return daoSession.getWorkoutDao().queryBuilder().where(com.fisherman.trainingdiary.entity
                .WorkoutDao
                .Properties.ProfileId.eq(profileId)).build().list();
    }

    @Override
    public List<Workout> getAllWorkouts() {
        return daoSession.getWorkoutDao().loadAll();
    }

    @Override
    public Workout getById(Long workoutId) {
        return daoSession.getWorkoutDao().load(workoutId);
    }

    @Override
    public void update(Workout workout) {
        daoSession.getWorkoutDao().update(workout);
        for (Day day : workout.getDayList()) {
            daoSession.getDayDao().update(day);
            for (TrainingPart trainingPart : day.getTrainingPartList()) {
                daoSession.getTrainingPartDao().update(trainingPart);
            }
        }
    }

    @Override
    public Workout saveWorkout(Workout workout) {
        refreshId(workout);
        daoSession.getWorkoutDao().insert(workout);
        for (Day day : workout.getDayList()) {
            day.setWorkoutId(workout.getId());
            daoSession.getDayDao().insert(day);
            for(TrainingPart trainingPart : day.getTrainingPartList()) {
                trainingPart.setDayId(day.getId());
                daoSession.getTrainingPartDao().insert(trainingPart);
            }
        }
        return workout;
    }

    @Override
    public boolean isWorkoutExists(Workout workout) {
        return daoSession.getWorkoutDao().queryBuilder().where(com.fisherman.trainingdiary.entity
                .WorkoutDao.Properties.Name.eq(workout.getName())).count() > 0;
    }

    @Override
    public Workout getActive() {
        return daoSession.getWorkoutDao().queryBuilder().where(com.fisherman.trainingdiary.entity
                .WorkoutDao.Properties.IsActive.eq(true)).unique();
    }

    private void refreshId(Workout workout) {
        workout.setId(null);
        for(Day day : workout.getDayList()) {
            day.setId(null);
            for (TrainingPart trainingPart : day.getTrainingPartList()) {
                trainingPart.setId(null);
            }
        }
    }

    @Override
    public Workout getWorkoutByProfileId(Long profileId) {
        return daoSession.getWorkoutDao().queryBuilder()
                .where(com.fisherman.trainingdiary.entity.WorkoutDao.Properties.ProfileId.eq(profileId))
                .unique();
    }

    @Override
    public void deleteWorkout(Workout workout) {
        daoSession.getWorkoutDao().delete(workout);
    }
}