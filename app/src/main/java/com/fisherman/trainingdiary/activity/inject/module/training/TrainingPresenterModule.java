package com.fisherman.trainingdiary.activity.inject.module.training;

import com.fisherman.trainingdiary.contract.training.TrainingContract;
import com.fisherman.trainingdiary.presenter.training.TrainingPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class TrainingPresenterModule {

    @Provides
    TrainingContract.Presenter providePresenter(TrainingContract.View view) {
        return new TrainingPresenter(view);
    }
}
