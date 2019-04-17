package com.fisherman.trainingdiary.activity.inject.module.dialog;

import android.content.Context;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.dialog.Dialog;
import com.fisherman.trainingdiary.activity.dialog.Dialog_;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileDeleteDialogModule {

    @Provides
    Dialog provideDialog(Context context) {
        Dialog dialog = new Dialog_();
        dialog.setMessage(context.getString(R.string.delete_profile_ask));
        return dialog;
    }
}
