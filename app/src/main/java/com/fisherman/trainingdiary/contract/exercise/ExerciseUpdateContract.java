package com.fisherman.trainingdiary.contract.exercise;

import com.fisherman.trainingdiary.entity.Exercise;

public interface ExerciseUpdateContract {

    public interface View {

        void onUpdateButtonClicked();

        void finish();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        void updateExercise(Exercise exercise);
    }
}