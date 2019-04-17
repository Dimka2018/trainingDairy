package com.fisherman.trainingdiary.activity.inject.module.workout;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.workout.WorkoutUpdateActivity;
import com.fisherman.trainingdiary.contract.workout.WorkoutUpdateContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class WorkoutUpdateContextModule {

    @Binds
    abstract WorkoutUpdateContract.View bindView(WorkoutUpdateActivity view);

    @Binds
    abstract Context bindContext(WorkoutUpdateActivity context);
}
