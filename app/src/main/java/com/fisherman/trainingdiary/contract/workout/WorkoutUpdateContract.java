package com.fisherman.trainingdiary.contract.workout;

import com.fisherman.trainingdiary.entity.Workout;

public interface WorkoutUpdateContract {

    public interface View {

        void onUpdateButtonClicked();

        void finish();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        Workout getWorkoutById(Long id);

        void update(Workout workout);
    }
}
