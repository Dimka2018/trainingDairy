package com.fisherman.trainingdiary.dao;

import com.fisherman.trainingdiary.entity.Exercise;

import java.util.List;

public interface ExerciseDao {

    List<String> getExerciseNameList();

    List<Exercise> getExerciseList();

    boolean isExerciseExists(Exercise exercise);

    boolean isExerciseNameNonUnique(String name);

    Exercise getExerciseByName(String name);

    Exercise getExerciseById(Long id);

    Exercise save(Exercise exercise);

    void updateExercise(Exercise exercise);

    void delete(Exercise exercise);
}
