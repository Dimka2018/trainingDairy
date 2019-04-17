package com.fisherman.trainingdiary.activity.inject.module.exercise;

import android.app.Activity;
import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.exercise.ExerciseActivity;
import com.fisherman.trainingdiary.contract.exercise.ExerciseContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ExerciseContextModule {

    @Binds
    abstract ExerciseContract.View bindView(ExerciseActivity view);

    @Binds
    abstract Context bindContext(ExerciseActivity context);

    @Binds
    abstract Activity bindActivity(ExerciseActivity activity);

}
