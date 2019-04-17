package com.fisherman.trainingdiary.contract.workout;

import com.fisherman.trainingdiary.entity.Workout;

import java.util.List;

public interface WorkoutContract {

    public static final String EXTRA_KEY = "id";

    public interface View {

        void refresh();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        void activateWorkout(Workout workout);

        void deleteWorkout(Workout workout);

        List<Workout> getCurrentWorkoutList();
    }
}
