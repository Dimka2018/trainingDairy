package com.fisherman.trainingdiary.activity.inject.module.entity_source;

import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.EntitySource;
import com.fisherman.trainingdiary.contract.training_part.TrainingPartContract;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class TrainingPartEntitySourceModule {

    @Provides
    EntitySource provideSource(final TrainingPartContract.Presenter presenter) {
        return new EntitySource() {
            @Override
            public List get() {
                return presenter.getExerciseList();
            }
        };
    }
}
