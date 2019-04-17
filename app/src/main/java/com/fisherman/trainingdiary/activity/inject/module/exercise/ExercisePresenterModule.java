package com.fisherman.trainingdiary.activity.inject.module.exercise;

import com.fisherman.trainingdiary.contract.exercise.ExerciseContract;
import com.fisherman.trainingdiary.presenter.exercise.ExercisePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ExercisePresenterModule {

    @Provides
    ExerciseContract.Presenter providePresenter(ExerciseContract.View view) {
        return new ExercisePresenter(view);
    }
}
