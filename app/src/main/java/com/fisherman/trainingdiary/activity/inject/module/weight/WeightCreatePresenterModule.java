package com.fisherman.trainingdiary.activity.inject.module.weight;

import com.fisherman.trainingdiary.contract.weight.WeightCreateContract;
import com.fisherman.trainingdiary.presenter.weight.WeightCreatePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class WeightCreatePresenterModule {

    @Provides
    WeightCreateContract.Presenter providePresenter(WeightCreateContract.View view) {
        return new WeightCreatePresenter(view);
    }
}
