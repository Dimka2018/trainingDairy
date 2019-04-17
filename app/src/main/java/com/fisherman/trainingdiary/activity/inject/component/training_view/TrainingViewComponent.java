package com.fisherman.trainingdiary.activity.inject.component.training_view;

import com.fisherman.trainingdiary.activity.inject.module.dialog.AddWeightDialogModule;
import com.fisherman.trainingdiary.activity.inject.module.entity_source.TrainingViewEntitySourceModule;
import com.fisherman.trainingdiary.activity.inject.module.listener.TrainingViewNewMassTypeListenerModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;
import com.fisherman.trainingdiary.activity.inject.module.training_view.TrainingViewContextModule;
import com.fisherman.trainingdiary.activity.inject.module.training_view.TrainingViewPresenterModule;
import com.fisherman.trainingdiary.activity.view.TrainingView;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {TrainingViewEntitySourceModule.class, TrainingViewContextModule.class,
        TrainingViewPresenterModule.class, TrainingViewNewMassTypeListenerModule.class,
        AddWeightDialogModule.class, ToastModule.class})
public interface TrainingViewComponent {

    void inject(TrainingView view);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(TrainingView context);

        TrainingViewComponent build();
    }
}
