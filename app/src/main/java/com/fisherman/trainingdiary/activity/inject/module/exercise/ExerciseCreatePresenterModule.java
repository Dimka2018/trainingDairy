package com.fisherman.trainingdiary.activity.inject.module.exercise;

import com.fisherman.trainingdiary.contract.exercise.ExerciseCreateContract;
import com.fisherman.trainingdiary.presenter.exercise.ExerciseCreatePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ExerciseCreatePresenterModule {

    @Provides
    ExerciseCreateContract.Presenter providePresenter(ExerciseCreateContract.View view) {
        return new ExerciseCreatePresenter(view);
    }
}
