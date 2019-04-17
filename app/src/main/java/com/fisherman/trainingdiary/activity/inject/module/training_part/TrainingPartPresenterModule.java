package com.fisherman.trainingdiary.activity.inject.module.training_part;

import android.app.Activity;

import com.fisherman.trainingdiary.contract.training_part.TrainingPartContract;
import com.fisherman.trainingdiary.presenter.training_part.TrainingPartPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class TrainingPartPresenterModule {

    @Provides
    TrainingPartContract.Presenter providePresenter(TrainingPartContract.View view, Activity activity) {
        return new TrainingPartPresenter(view, activity);
    }
}
