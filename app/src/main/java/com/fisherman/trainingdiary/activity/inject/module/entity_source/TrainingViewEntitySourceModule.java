package com.fisherman.trainingdiary.activity.inject.module.entity_source;

import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.EntitySource;
import com.fisherman.trainingdiary.contract.training_view.TrainingViewContract;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class TrainingViewEntitySourceModule {

    @Provides
    EntitySource provideSource(final TrainingViewContract.Presenter presenter) {
        return new EntitySource() {
            @Override
            public List get() {
                return presenter.getWeightList();
            }
        };
    }
}
