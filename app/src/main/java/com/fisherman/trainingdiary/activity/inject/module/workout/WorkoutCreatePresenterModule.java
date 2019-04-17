package com.fisherman.trainingdiary.activity.inject.module.workout;

import com.fisherman.trainingdiary.contract.workout.WorkoutCreateContract;
import com.fisherman.trainingdiary.presenter.workout.WorkoutCreatePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class WorkoutCreatePresenterModule {

    @Provides
    WorkoutCreateContract.Presenter providePresenter(WorkoutCreateContract.View view) {
        return new WorkoutCreatePresenter(view);
    }
}
