package com.fisherman.trainingdiary.activity.inject.module.entity_source;

import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.EntitySource;
import com.fisherman.trainingdiary.contract.exercise.ExerciseContract;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class ExerciseEntitySourceModule {

    @Provides
    EntitySource provideSource(final ExerciseContract.Presenter presenter) {
        return new EntitySource() {
            @Override
            public List get() {
                return presenter.getExerciseList();
            }
        };
    }
}
