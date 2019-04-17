package com.fisherman.trainingdiary.activity.inject.module.exercise;

import com.fisherman.trainingdiary.contract.exercise.ExerciseUpdateContract;
import com.fisherman.trainingdiary.presenter.exercise.ExerciseUpdatePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ExerciseUpdatePresenterModule {

    @Provides
    ExerciseUpdateContract.Presenter providePresenter(ExerciseUpdateContract.View view) {
        return new ExerciseUpdatePresenter(view);
    }
}
