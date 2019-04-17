package com.fisherman.trainingdiary.activity.inject.module.workout;

import com.fisherman.trainingdiary.contract.workout.WorkoutContract;
import com.fisherman.trainingdiary.presenter.workout.WorkoutPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class WorkoutPresenterModule {

    @Provides
    WorkoutContract.Presenter providePresenter(WorkoutContract.View view) {
        return new WorkoutPresenter(view);
    }
}
