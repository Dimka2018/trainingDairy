package com.fisherman.trainingdiary.activity.inject.module.statistic;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.statistic.StatisticActivity;
import com.fisherman.trainingdiary.contract.statistic.StatisticContract;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class StatisticContextModule {

    @Provides
    Context provideContext(StatisticActivity context) {
        return  context;
    }

    @Provides
    StatisticContract.View provideView(StatisticActivity view) {
        return view;
    }
}
