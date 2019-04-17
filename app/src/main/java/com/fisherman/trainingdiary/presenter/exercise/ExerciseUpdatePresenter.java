package com.fisherman.trainingdiary.presenter.exercise;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.exercise.ExerciseUpdateContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.exception.InvalidFieldValueException;
import com.fisherman.trainingdiary.exception.ObjectAlreadyExistsException;

public class ExerciseUpdatePresenter implements ExerciseUpdateContract.Presenter {

    private ExerciseUpdateContract.View view;
    private DaoFactory daoFactory;


    public ExerciseUpdatePresenter(ExerciseUpdateContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public void updateExercise(Exercise exercise) {
        try {
            validateExercise(exercise);
            daoFactory.getExerciseDao().updateExercise(exercise);
            view.finish();
        } catch (Exception e) {
            view.showErrorMessage(e.getMessage());
        }
    }

    private void validateExercise(Exercise exercise) throws Exception {
        Activity activity = (Activity) view;
        if (exercise.getName() == null || "".equals(exercise.getName().trim())) {
            throw new InvalidFieldValueException(activity.getString(R.string.empty_field));
        }
        if (daoFactory.getExerciseDao().isExerciseExists(exercise)) {
            throw new ObjectAlreadyExistsException(activity.getString(R.string
                    .exercise_already_exists));
        }
    }
}
