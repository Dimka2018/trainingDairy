package com.fisherman.trainingdiary.activity.inject.module.weight;

import com.fisherman.trainingdiary.contract.weight.WeightContract;
import com.fisherman.trainingdiary.presenter.weight.WeightPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class WeightPresenterModule {

    @Provides
    WeightContract.Presenter providePresenter(WeightContract.View view) {
        return new WeightPresenter(view);
    }
}
