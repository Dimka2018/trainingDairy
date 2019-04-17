package com.fisherman.trainingdiary.activity.inject.module.weight;

import com.fisherman.trainingdiary.contract.weight.WeightUpdateContract;
import com.fisherman.trainingdiary.presenter.weight.WeightUpdatePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class WeightUpdatePresenterModule {

    @Provides
    WeightUpdateContract.Presenter providePresenter(WeightUpdateContract.View view) {
        return new WeightUpdatePresenter(view);
    }
}
