package com.fisherman.trainingdiary.activity.inject.module.entity_source;

import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.EntitySource;
import com.fisherman.trainingdiary.contract.weight.WeightContract;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class WeightEntitySourceModule {

    @Provides
    EntitySource provideSource(final WeightContract.Presenter presenter) {
        return new EntitySource() {
            @Override
            public List get() {
                return presenter.getMassTypeList();
            }
        };
    }
}
