package com.fisherman.trainingdiary.activity.inject.module.dialog;

import com.fisherman.trainingdiary.activity.dialog.training_list.TrainingListDialog;
import com.fisherman.trainingdiary.activity.dialog.training_list.TrainingListDialog_;

import dagger.Module;
import dagger.Provides;

@Module
public class TrainingListDialogModule {

    @Provides
    TrainingListDialog provideDialog() {
        return new TrainingListDialog_();
    }
}
