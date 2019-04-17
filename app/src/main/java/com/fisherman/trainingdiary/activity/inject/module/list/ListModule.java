package com.fisherman.trainingdiary.activity.inject.module.list;

import com.fisherman.trainingdiary.activity.view.TrainingView;
import com.fisherman.trainingdiary.activity.view.TrainingDayView;
import com.fisherman.trainingdiary.entity.History;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class ListModule {

    @Provides
    List<TrainingDayView> provideTrainingDayViewList() {
        return new ArrayList<>();
    }

    @Provides
    List<History> provideHistoryList() {
        return new ArrayList<>();
    }

    @Provides
    List<TrainingView> provideExerciseViewList() {
        return new ArrayList<>();
    }
}
