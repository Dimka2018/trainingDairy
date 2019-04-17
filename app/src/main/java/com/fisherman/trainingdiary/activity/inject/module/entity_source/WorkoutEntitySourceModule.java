package com.fisherman.trainingdiary.activity.inject.module.entity_source;

import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.EntitySource;
import com.fisherman.trainingdiary.contract.workout.WorkoutContract;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class WorkoutEntitySourceModule {

    @Provides
    EntitySource provideSource(final WorkoutContract.Presenter presenter) {
        return new EntitySource() {
            @Override
            public List get() {
                return presenter.getCurrentWorkoutList();
            }
        };
    }
}
