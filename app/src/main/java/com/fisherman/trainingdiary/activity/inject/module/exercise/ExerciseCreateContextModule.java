package com.fisherman.trainingdiary.activity.inject.module.exercise;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.exercise.ExerciseCreateActivity;
import com.fisherman.trainingdiary.contract.exercise.ExerciseCreateContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ExerciseCreateContextModule {

    @Binds
    abstract ExerciseCreateContract.View bindView(ExerciseCreateActivity view);

    @Binds
    abstract Context bindContext(ExerciseCreateActivity context);
}
