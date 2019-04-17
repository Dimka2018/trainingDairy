package com.fisherman.trainingdiary.activity.inject.component.training;

import com.fisherman.trainingdiary.activity.activity.training.TrainingActivity;
import com.fisherman.trainingdiary.activity.inject.module.dialog.TrainingListDialogModule;
import com.fisherman.trainingdiary.activity.inject.module.list.ListModule;
import com.fisherman.trainingdiary.activity.inject.module.training.TrainingContextModule;
import com.fisherman.trainingdiary.activity.inject.module.training.TrainingPresenterModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {TrainingPresenterModule.class, TrainingContextModule.class,
        TrainingListDialogModule.class, ListModule.class})
public interface TrainingComponent {

    void inject(TrainingActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(TrainingActivity context);

        TrainingComponent build();
    }
}
