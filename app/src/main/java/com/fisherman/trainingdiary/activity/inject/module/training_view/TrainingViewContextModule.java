package com.fisherman.trainingdiary.activity.inject.module.training_view;

import android.app.Activity;
import android.content.Context;

import com.fisherman.trainingdiary.activity.view.TrainingView;
import com.fisherman.trainingdiary.contract.training_view.TrainingViewContract;

import dagger.Module;
import dagger.Provides;

@Module
public class TrainingViewContextModule {

    @Provides
    TrainingViewContract.View provideView(TrainingView view) {
        return view;
    }

    @Provides
    Context provideContext(TrainingView context) {
        return context.getContext();
    }

    @Provides
    Activity provideActivity(TrainingView activity) {
        return (Activity) activity.getContext();
    }
}
