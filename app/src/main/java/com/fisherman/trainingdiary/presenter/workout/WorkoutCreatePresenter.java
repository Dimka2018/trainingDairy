package com.fisherman.trainingdiary.presenter.workout;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.workout.WorkoutCreateContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.Workout;
import com.fisherman.trainingdiary.exception.InvalidFieldValueException;
import com.fisherman.trainingdiary.exception.ObjectAlreadyExistsException;

public class WorkoutCreatePresenter implements WorkoutCreateContract.Presenter {

    private WorkoutCreateContract.View view;
    private DaoFactory daoFactory;

    public WorkoutCreatePresenter(WorkoutCreateContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public void saveWorkout(Workout workout) {
        try {
            validateWorkout(workout);
            workout.setProfileId(daoFactory.getProfileDao().getCurrent().getId());
            daoFactory.getWorkoutDao().saveWorkout(workout);
            view.finish();
        } catch (Exception e) {
            view.showErrorMessage(e.getMessage());
        }
    }

    private void validateWorkout(Workout workout) throws Exception {
        Activity activity = (Activity) view;
        if (workout.getName() == null || "".equals(workout.getName().trim())) {
            throw new InvalidFieldValueException(activity.getString(R.string.empty_field));
        }
        if (daoFactory.getWorkoutDao().isWorkoutExists(workout)) {
            throw new ObjectAlreadyExistsException(activity.getString(R.string
                    .workout_already_exists));
        }
    }
}
