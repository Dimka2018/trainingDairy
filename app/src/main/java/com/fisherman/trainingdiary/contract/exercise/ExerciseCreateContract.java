package com.fisherman.trainingdiary.contract.exercise;

import com.fisherman.trainingdiary.entity.Exercise;

public interface ExerciseCreateContract {

    public interface View {

        void onSaveButtonClicked();

        void finish();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        void saveExercise(Exercise exercise);
    }

}
