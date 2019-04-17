package com.fisherman.trainingdiary.presenter.exercise;

import android.app.Activity;

import com.fisherman.trainingdiary.contract.exercise.ExerciseContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.Exercise;

import java.util.List;

public class ExercisePresenter implements ExerciseContract.Presenter {

    private ExerciseContract.View view;
    private DaoFactory daoFactory;

    public ExercisePresenter(ExerciseContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public void deleteExercise(Exercise exercise) {
        daoFactory.getExerciseDao().delete(exercise);
        view.refresh();
    }

    @Override
    public List<Exercise> getExerciseList() {
        return daoFactory.getExerciseDao().getExerciseList();
    }
}
