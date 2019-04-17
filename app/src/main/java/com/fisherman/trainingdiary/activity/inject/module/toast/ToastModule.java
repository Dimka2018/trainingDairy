package com.fisherman.trainingdiary.activity.inject.module.toast;

import android.content.Context;
import android.widget.Toast;

import com.fisherman.trainingdiary.activity.toast.NotificationToast;

import dagger.Module;
import dagger.Provides;

@Module
public class ToastModule {

    @Provides
    Toast povideToast(Context context) {
        return new NotificationToast(context);
    }
}
