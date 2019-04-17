package com.fisherman.trainingdiary.activity.inject.module.statistic;

import com.fisherman.trainingdiary.contract.statistic.StatisticContract;
import com.fisherman.trainingdiary.presenter.statistic.StatisticPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class StatisticPresenterModule {

    @Provides
    StatisticContract.Presenter providePresenter(StatisticContract.View view) {
        return new StatisticPresenter(view);
    }
}
