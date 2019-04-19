package com.fisherman.trainingdiary.presenter.training;

import android.app.Activity;

import com.fisherman.trainingdiary.contract.training.TrainingContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.dto.WorkoutDTO;
import com.fisherman.trainingdiary.entity.Day;
import com.fisherman.trainingdiary.entity.History;
import com.fisherman.trainingdiary.entity.Profile;
import com.fisherman.trainingdiary.entity.Trainee;
import com.fisherman.trainingdiary.entity.TrainingPart;
import com.fisherman.trainingdiary.entity.Workout;

import java.util.List;

public class TrainingPresenter implements TrainingContract.Presenter {

    private TrainingContract.View view;
    private DaoFactory daoFactory;

    public TrainingPresenter(TrainingContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    private void saveTraining(List<TrainingPart> trainingPartList, List<History> historyList) {
        Trainee trainee = new Trainee();
        Profile currentProfile = getCurrentProfile();
        trainee.setProfileId(currentProfile.getId());
        trainee = daoFactory.getTraineeDao().save(trainee);
        for (int i = 0; i < trainingPartList.size(); i++)  {
            History history = historyList.get(i);
            history.setTraineeId(trainee.getId());
            history = saveHistory(history);
            TrainingPart trainingPart = trainingPartList.get(i);
            trainingPart.setLastHistory(history);
            updateTrainingPart(trainingPart);
        }
    }

    private void setNextTrainingDay() {
        Workout currentWorkout = getActiveWorkout();
        List<Day> days = currentWorkout.getDayList();
        Profile profile = getCurrentProfile();
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).equals(profile.getCurrentDay())) {
                Day nextDay = days.get(i == (days.size() - 1) ? 0 : (i + 1));
                profile.setCurrentDayId(nextDay.getId());
                profile.setCurrentDay(nextDay);
                break;
            }
        }
        updateProfile(profile);
    }

    @Override
    public void onFinishWorkoutButtonClicked(List<TrainingPart> trainingPartList, List<History> historyList) {
        saveTraining(trainingPartList, historyList);
        setNextTrainingDay();
        view.finish();
    }

    @Override
    public WorkoutDTO getWorkoutDTO(TrainingPart trainingPart) {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutDTO.setExercise(trainingPart.getExercise());
        workoutDTO.setNumberSets(trainingPart.getNumberSets());
        History history = trainingPart.getLastHistory();
        if (history != null) {
            workoutDTO.setLastMeasure(daoFactory.getMassTypeDao().getMassTypeById(history.getMassTypeId()));
            workoutDTO.setMaxWeight(history.getIsMaxWeight());
            workoutDTO.setLastWeight(history.getWeight());
            if (history.getIsCompleted() && history.getIsMaxWeight()) {
                workoutDTO.setNumberReps(history.getNumberReps() + 1);
            } else {
                workoutDTO.setNumberReps(history.getNumberReps());
            }
            workoutDTO.setLastComplete(history.getIsCompleted());
        } else {
            workoutDTO.setNumberReps(trainingPart.getNumberReps());
        }
        return workoutDTO;
    }

    @Override
    public Profile getCurrentProfile() {
        return daoFactory.getProfileDao().getCurrent();
    }

    @Override
    public Workout getActiveWorkout() {
        return daoFactory.getWorkoutDao().getActive();
    }

    @Override
    public void updateProfile(Profile profile) {
        daoFactory.getProfileDao().updateProfile(profile);
    }

    @Override
    public History saveHistory(History history) {
        return daoFactory.getHistoryDao().save(history);
    }

    @Override
    public void updateTrainingPart(TrainingPart trainingPart) {
        daoFactory.getTrainingPartDao().update(trainingPart);
    }
}
