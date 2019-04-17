package com.fisherman.trainingdiary.activity.inject.module.dialog;

import com.fisherman.trainingdiary.activity.dialog.Dialog;
import com.fisherman.trainingdiary.activity.dialog.Dialog_;

import dagger.Module;
import dagger.Provides;
@Module
public class DialogModule {

    @Provides
    Dialog provideDialog() {
        return new Dialog_();
    }
}
