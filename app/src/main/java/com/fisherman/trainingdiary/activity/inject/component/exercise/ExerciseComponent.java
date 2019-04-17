package com.fisherman.trainingdiary.activity.inject.component.exercise;

import com.fisherman.trainingdiary.activity.activity.exercise.ExerciseActivity;
import com.fisherman.trainingdiary.activity.inject.annotation.ActivityScope;
import com.fisherman.trainingdiary.activity.inject.module.adapter.DefaultAdapterModule;
import com.fisherman.trainingdiary.activity.inject.module.creator.ExerciseMenuCreatorModule;
import com.fisherman.trainingdiary.activity.inject.module.dialog.ExerciseDeleteDialogModule;
import com.fisherman.trainingdiary.activity.inject.module.entity_source.ExerciseEntitySourceModule;
import com.fisherman.trainingdiary.activity.inject.module.exercise.ExerciseContextModule;
import com.fisherman.trainingdiary.activity.inject.module.exercise.ExercisePresenterModule;
import com.fisherman.trainingdiary.activity.inject.module.listener.ExerciseItemListenerModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;

import dagger.BindsInstance;
import dagger.Component;

@ActivityScope
@Component(modules = {ExercisePresenterModule.class, ExerciseContextModule.class,
        DefaultAdapterModule.class, ExerciseDeleteDialogModule.class, ExerciseMenuCreatorModule.class,
        ExerciseEntitySourceModule.class, ExerciseItemListenerModule.class, ToastModule.class})
public interface ExerciseComponent {

    void inject(ExerciseActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(ExerciseActivity context);

        ExerciseComponent build();
    }
}
