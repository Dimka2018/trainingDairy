package com.fisherman.trainingdiary.activity.inject.module.workout;

import android.app.Activity;
import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.workout.WorkoutActivity;
import com.fisherman.trainingdiary.contract.workout.WorkoutContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class WorkoutContextModule {

    @Binds
    abstract WorkoutContract.View bindView(WorkoutActivity view);

    @Binds
    abstract Context bindContext(WorkoutActivity context);

    @Binds
    abstract Activity bindActivity(WorkoutActivity activity);
}
