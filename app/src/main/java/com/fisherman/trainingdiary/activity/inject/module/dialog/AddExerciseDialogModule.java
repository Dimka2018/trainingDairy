package com.fisherman.trainingdiary.activity.inject.module.dialog;

import android.content.Context;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.activity.dialog.AddDialog;
import com.fisherman.trainingdiary.activity.dialog.AddDialog_;

import dagger.Module;
import dagger.Provides;

@Module
public class AddExerciseDialogModule {

    @Provides
    AddDialog provideDialog(Context context) {
        AddDialog dialog = new AddDialog_();
        dialog.setHint(context.getString(R.string.enter_exercise_name));
        return dialog;
    }
}
