package com.fisherman.trainingdiary.activity.inject.component.exercise;

import com.fisherman.trainingdiary.activity.activity.exercise.ExerciseUpdateActivity;
import com.fisherman.trainingdiary.activity.inject.module.exercise.ExerciseUpdateContextModule;
import com.fisherman.trainingdiary.activity.inject.module.exercise.ExerciseUpdatePresenterModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {ExerciseUpdatePresenterModule.class, ExerciseUpdateContextModule.class,
        ToastModule.class})
public interface ExerciseUpdateComponent {

    void inject(ExerciseUpdateActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(ExerciseUpdateActivity context);

        ExerciseUpdateComponent build();
    }
}
