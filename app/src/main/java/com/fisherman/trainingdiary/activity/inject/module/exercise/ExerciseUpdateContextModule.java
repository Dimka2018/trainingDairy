package com.fisherman.trainingdiary.activity.inject.module.exercise;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.exercise.ExerciseUpdateActivity;
import com.fisherman.trainingdiary.contract.exercise.ExerciseUpdateContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ExerciseUpdateContextModule {

    @Binds
    abstract ExerciseUpdateContract.View bindView(ExerciseUpdateActivity view);

    @Binds
    abstract Context bindContext(ExerciseUpdateActivity context);
}
