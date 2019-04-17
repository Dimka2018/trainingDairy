package com.fisherman.trainingdiary.activity.inject.module.training;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.training.TrainingActivity;
import com.fisherman.trainingdiary.contract.training.TrainingContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TrainingContextModule {

    @Binds
    abstract TrainingContract.View bindView(TrainingActivity view);

    @Binds
    abstract Context bindContext(TrainingActivity context);
}
