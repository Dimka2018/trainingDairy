package com.fisherman.trainingdiary.contract.exercise;

import com.fisherman.trainingdiary.entity.Exercise;

import java.util.List;

public interface ExerciseContract {

    public interface View {

        void refresh();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        void deleteExercise(Exercise exercise);

        List<Exercise> getExerciseList();
    }
}
