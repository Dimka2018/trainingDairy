package com.fisherman.trainingdiary.activity.inject.module.weight;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.weight.WeightCreateActivity;
import com.fisherman.trainingdiary.contract.weight.WeightCreateContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class WeightCreateContextModule {

    @Binds
    abstract WeightCreateContract.View bindView(WeightCreateActivity view);

    @Binds
    abstract Context bindContext(WeightCreateActivity context);
}
