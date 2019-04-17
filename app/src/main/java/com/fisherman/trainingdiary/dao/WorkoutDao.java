package com.fisherman.trainingdiary.dao;

import com.fisherman.trainingdiary.entity.Workout;

import java.util.List;

public interface WorkoutDao {

    List<Workout> getWorkoutList(Long profileId);

    Workout saveWorkout(Workout workout);

    boolean isWorkoutExists(Workout workout);

    Workout getActive();

    void deleteWorkout(Workout workout);

    Workout getWorkoutByProfileId(Long profileId);

    List<Workout> getAllWorkouts();

    void update(Workout workout);

    Workout getById(Long workoutId);
}
