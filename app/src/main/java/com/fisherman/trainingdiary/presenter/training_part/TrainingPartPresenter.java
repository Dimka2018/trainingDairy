package com.fisherman.trainingdiary.presenter.training_part;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.training_part.TrainingPartContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.exception.InvalidFieldValueException;
import com.fisherman.trainingdiary.exception.ObjectAlreadyExistsException;

import java.util.List;

public class TrainingPartPresenter implements TrainingPartContract.Presenter {

    private TrainingPartContract.View view;
    private Activity activity;
    private DaoFactory daoFactory;

    public TrainingPartPresenter(TrainingPartContract.View view, Activity activity) {
        this.view = view;
        this.activity = activity;
        this.daoFactory = (DaoFactory) activity.getApplication();
    }

    @Override
    public List<Exercise> getExerciseList() {
        return daoFactory.getExerciseDao().getExerciseList();
    }

    @Override
    public void saveExercise(Exercise exercise) {
        try {
            validateExercise(exercise);
            daoFactory.getExerciseDao().save(exercise);
            view.refresh();
        } catch (Exception e) {
            view.showErrorMessage(e.getMessage());
        }
    }

    private void validateExercise(Exercise exercise) throws Exception {
        if (exercise.getName() == null || "".equals(exercise.getName())) {
            throw new InvalidFieldValueException(activity.getString(R.string.empty_field));
        }
        if (daoFactory.getExerciseDao().isExerciseExists(exercise)) {
            throw new ObjectAlreadyExistsException(activity.getString(R.string
                    .exercise_already_exists));
        }
    }
}
