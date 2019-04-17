package com.fisherman.trainingdiary.activity.inject.module.dialog;

import android.content.Context;
import android.view.View;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.dialog.Dialog;
import com.fisherman.trainingdiary.activity.dialog.Dialog_;
import com.fisherman.trainingdiary.contract.main.MainContract;

import dagger.Module;
import dagger.Provides;

@Module
public class NoWorkoutDialogModule {

    @Provides
    Dialog provideDialog (Context context, final MainContract.View view) {
        Dialog dialog = new Dialog_();
        dialog.setMessage(context.getString(R.string.no_training));
        dialog.setPositiveClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.openWorkoutList();
            }
        });
        return dialog;
    }
}
