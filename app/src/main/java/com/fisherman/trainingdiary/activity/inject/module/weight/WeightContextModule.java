package com.fisherman.trainingdiary.activity.inject.module.weight;

import android.app.Activity;
import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.weight.WeightActivity;
import com.fisherman.trainingdiary.contract.weight.WeightContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class WeightContextModule {

    @Binds
    abstract WeightContract.View bindView(WeightActivity view);

    @Binds
    abstract Context bindContext(WeightActivity context);

    @Binds
    abstract Activity bindActivity(WeightActivity activity);
}
