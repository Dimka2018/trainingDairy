package com.fisherman.trainingdiary.activity.inject.module.weight;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.weight.WeightUpdateActivity;
import com.fisherman.trainingdiary.contract.weight.WeightUpdateContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class WeightUpdateContextModule {

    @Binds
    abstract WeightUpdateContract.View bindView(WeightUpdateActivity view);

    @Binds
    abstract Context bindContext(WeightUpdateActivity context);
}
