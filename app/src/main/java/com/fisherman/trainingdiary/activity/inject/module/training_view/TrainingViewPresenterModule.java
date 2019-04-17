package com.fisherman.trainingdiary.activity.inject.module.training_view;

import android.app.Activity;

import com.fisherman.trainingdiary.contract.training_view.TrainingViewContract;
import com.fisherman.trainingdiary.presenter.training_view.TrainingViewPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class TrainingViewPresenterModule {

    @Provides
    TrainingViewContract.Presenter providePresenter(TrainingViewContract.View view, Activity activity) {
        return new TrainingViewPresenter(view, activity);
    }
}
