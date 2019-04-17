package com.fisherman.trainingdiary.presenter.workout;

import android.app.Activity;

import com.fisherman.trainingdiary.contract.workout.WorkoutContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.Profile;
import com.fisherman.trainingdiary.entity.Workout;

import java.util.List;

public class WorkoutPresenter implements WorkoutContract.Presenter {

    private WorkoutContract.View view;
    private DaoFactory daoFactory;

    public WorkoutPresenter(WorkoutContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public List<Workout> getCurrentWorkoutList() {
        return daoFactory.getProfileDao().getCurrent().getWorkoutList();
    }

    @Override
    public void activateWorkout(Workout workout) {
        Workout oldWorkout = daoFactory.getWorkoutDao().getActive();
        if (oldWorkout != null) {
            oldWorkout.setIsActive(false);
            daoFactory.getWorkoutDao().update(oldWorkout);
        }
        workout.setIsActive(true);
        daoFactory.getWorkoutDao().update(workout);
        Profile profile = daoFactory.getProfileDao().getCurrent();
        profile.setCurrentDayId(workout.getDayList().get(0).getId());
        daoFactory.getProfileDao().updateProfile(profile);
        view.refresh();
    }

    @Override
    public void deleteWorkout(Workout workout) {
        if (workout.getIsActive()) {
            Profile profile = daoFactory.getProfileDao().getCurrent();
            profile.setCurrentDayId(null);
            daoFactory.getProfileDao().updateProfile(profile);
        }
        daoFactory.getWorkoutDao().deleteWorkout(workout);
        view.refresh();
    }
}
