package com.fisherman.trainingdiary.activity.inject.module.workout;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.workout.WorkoutCreateActivity;
import com.fisherman.trainingdiary.contract.workout.WorkoutCreateContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class WorkoutCreateContextModule {

    @Binds
    abstract WorkoutCreateContract.View bindView(WorkoutCreateActivity view);

    @Binds
    abstract Context bindContext(WorkoutCreateActivity context);
}
