package com.fisherman.trainingdiary.activity.inject.module.training_part;

import android.app.Activity;
import android.content.Context;

import com.fisherman.trainingdiary.activity.view.TrainingPartView;
import com.fisherman.trainingdiary.contract.training_part.TrainingPartContract;

import dagger.Module;
import dagger.Provides;

@Module
public class TrainingPartContextModule {

    @Provides
    TrainingPartContract.View provideView(TrainingPartView view) {
        return view;
    }

    @Provides
    Context provideContext(TrainingPartView context) {
        return context.getContext();
    }

    @Provides
    Activity provideActivity(TrainingPartView activity) {
        return (Activity) activity.getContext();
    }
}
