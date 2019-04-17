package com.fisherman.trainingdiary.activity.inject.module.workout;

import com.fisherman.trainingdiary.contract.workout.WorkoutUpdateContract;
import com.fisherman.trainingdiary.presenter.workout.WorkoutUpdatePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class WorkoutUpdatePresenterModule {

    @Provides
    WorkoutUpdateContract.Presenter providePresenter(WorkoutUpdateContract.View view) {
        return new WorkoutUpdatePresenter(view);
    }
}
