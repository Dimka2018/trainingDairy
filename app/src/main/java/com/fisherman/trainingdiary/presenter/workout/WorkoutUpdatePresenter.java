package com.fisherman.trainingdiary.presenter.workout;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.workout.WorkoutUpdateContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.Workout;
import com.fisherman.trainingdiary.exception.InvalidFieldValueException;
import com.fisherman.trainingdiary.exception.ObjectAlreadyExistsException;

public class WorkoutUpdatePresenter implements WorkoutUpdateContract.Presenter {

    private WorkoutUpdateContract.View view;
    private DaoFactory daoFactory;

    public WorkoutUpdatePresenter(WorkoutUpdateContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public Workout getWorkoutById(Long id) {
        return  daoFactory.getWorkoutDao().getById(id);
    }

    @Override
    public void update(Workout workout) {
        try {
            validateWorkout(workout);
            daoFactory.getWorkoutDao().deleteWorkout(workout);
            daoFactory.getWorkoutDao().saveWorkout(workout);
            view.finish();
        } catch (InvalidFieldValueException | ObjectAlreadyExistsException e) {
            view.showErrorMessage(e.getMessage());
        }
    }

    private void validateWorkout(Workout workout) throws InvalidFieldValueException, ObjectAlreadyExistsException {
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
