package com.fisherman.trainingdiary.activity.inject.module.main;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.main.MainActivity;
import com.fisherman.trainingdiary.contract.main.MainContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainContextModule {

    @Binds
    abstract MainContract.View bindView(MainActivity view);

    @Binds
    abstract Context bindContext(MainActivity context);
}
