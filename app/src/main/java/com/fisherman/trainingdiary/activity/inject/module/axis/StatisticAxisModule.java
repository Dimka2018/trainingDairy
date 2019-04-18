package com.fisherman.trainingdiary.activity.inject.module.axis;

import android.graphics.Color;

import dagger.Module;
import dagger.Provides;
import lecho.lib.hellocharts.model.Axis;

@Module
public class StatisticAxisModule {

    @Provides
    Axis provideAxis() {
        Axis axis = new Axis();
        axis.setLineColor(Color.WHITE);
        axis.setTextColor(Color.WHITE);
        axis.setTextSize(20);
        return axis;
    }
}
