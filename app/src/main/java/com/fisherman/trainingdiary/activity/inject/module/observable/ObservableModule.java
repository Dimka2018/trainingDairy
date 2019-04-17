package com.fisherman.trainingdiary.activity.inject.module.observable;

import android.databinding.ObservableInt;

import dagger.Module;
import dagger.Provides;

@Module
public class ObservableModule {

    @Provides
    ObservableInt provideInt(Integer integer) {
        return new ObservableInt(integer);
    }
}
