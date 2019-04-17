package com.fisherman.trainingdiary.presenter.exercise;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.exercise.ExerciseCreateContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.exception.InvalidFieldValueException;
import com.fisherman.trainingdiary.exception.ObjectAlreadyExistsException;

public class ExerciseCreatePresenter implements ExerciseCreateContract.Presenter {

    private ExerciseCreateContract.View view;
    private DaoFactory daoFactory;

    public ExerciseCreatePresenter(ExerciseCreateContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public void saveExercise(Exercise exercise) {
        try {
            validateExercise(exercise);
            daoFactory.getExerciseDao().save(exercise);
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
