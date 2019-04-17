package com.fisherman.trainingdiary.contract.exercise;

import com.fisherman.trainingdiary.entity.Exercise;

import java.util.List;

public interface ExerciseContract {

    public static final String EXTRA_KEY = "exercise";

    public interface View {

        void refresh();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        void deleteExercise(Exercise exercise);

        List<Exercise> getExerciseList();
    }
}
