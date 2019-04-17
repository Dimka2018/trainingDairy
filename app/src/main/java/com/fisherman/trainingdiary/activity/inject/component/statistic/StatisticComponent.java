package com.fisherman.trainingdiary.activity.inject.component.statistic;

import com.fisherman.trainingdiary.activity.activity.statistic.StatisticActivity;
import com.fisherman.trainingdiary.activity.inject.module.adapter.ExerciseListAdapterModule;
import com.fisherman.trainingdiary.activity.inject.module.adapter.WeightListAdapterModule;
import com.fisherman.trainingdiary.activity.inject.module.axis.StatisticAxisModule;
import com.fisherman.trainingdiary.activity.inject.module.statistic.StatisticContextModule;
import com.fisherman.trainingdiary.activity.inject.module.statistic.StatisticPresenterModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {ExerciseListAdapterModule.class, WeightListAdapterModule.class,
        StatisticPresenterModule.class, StatisticContextModule.class, StatisticAxisModule.class})
public interface StatisticComponent {

    void inject(StatisticActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(StatisticActivity context);

        StatisticComponent build();
    }
}
