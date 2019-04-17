package com.fisherman.trainingdiary.contract.training_part;

import com.fisherman.trainingdiary.entity.Exercise;

import java.util.List;

public interface TrainingPartContract {

    public interface View {

        void refresh();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        List<Exercise> getExerciseList();

        void saveExercise(Exercise exercise);
    }
}
