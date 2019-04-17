package com.fisherman.trainingdiary.contract.workout;

import com.fisherman.trainingdiary.entity.Workout;

public interface WorkoutCreateContract {

    public interface View {

        void onSaveButtonClicked();

        void finish();

        void showErrorMessage(String message);
    }


    public interface Presenter {

        void saveWorkout(Workout workout);
    }

}
