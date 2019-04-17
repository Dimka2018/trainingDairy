package com.fisherman.trainingdiary.contract.training;

import com.fisherman.trainingdiary.dto.WorkoutDTO;
import com.fisherman.trainingdiary.entity.History;
import com.fisherman.trainingdiary.entity.Profile;
import com.fisherman.trainingdiary.entity.TrainingPart;
import com.fisherman.trainingdiary.entity.Workout;

import java.util.List;

public interface TrainingContract {

    public interface View {

        void finish();

        void openSideMenu();

        void startTimer();
    }

    public interface Presenter {

        void onFinishWorkoutButtonClicked(List<TrainingPart> trainingPartList, List<History>
                historyList);

        WorkoutDTO getWorkoutDTO(TrainingPart trainingPart);

        Profile getCurrentProfile();

        Workout getActiveWorkout();

        void updateProfile(Profile profile);

        History saveHistory(History history);

        void updateTrainingPart(TrainingPart trainingPart);
    }
}
