package com.fisherman.trainingdiary.activity.inject.component.training_part;

import com.fisherman.trainingdiary.activity.inject.module.dialog.AddExerciseDialogModule;
import com.fisherman.trainingdiary.activity.inject.module.entity_source.TrainingPartEntitySourceModule;
import com.fisherman.trainingdiary.activity.inject.module.listener.TrainingPartNewExerciseListenerModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;
import com.fisherman.trainingdiary.activity.inject.module.training_part.TrainingPartContextModule;
import com.fisherman.trainingdiary.activity.inject.module.training_part.TrainingPartPresenterModule;
import com.fisherman.trainingdiary.activity.view.TrainingPartView;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {TrainingPartPresenterModule.class, TrainingPartContextModule.class,
        TrainingPartEntitySourceModule.class, TrainingPartNewExerciseListenerModule.class,
        AddExerciseDialogModule.class, ToastModule.class})
public interface TrainingPartComponent {

    void inject(TrainingPartView view);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(TrainingPartView context);

        TrainingPartComponent build();
    }
}
