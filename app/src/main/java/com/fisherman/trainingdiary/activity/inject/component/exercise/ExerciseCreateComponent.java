package com.fisherman.trainingdiary.activity.inject.component.exercise;

import com.fisherman.trainingdiary.activity.activity.exercise.ExerciseCreateActivity;
import com.fisherman.trainingdiary.activity.inject.module.exercise.ExerciseCreateContextModule;
import com.fisherman.trainingdiary.activity.inject.module.exercise.ExerciseCreatePresenterModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {ExerciseCreatePresenterModule.class, ExerciseCreateContextModule.class,
        ToastModule.class})
public interface ExerciseCreateComponent {

    void inject(ExerciseCreateActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(ExerciseCreateActivity context);

        ExerciseCreateComponent build();
    }
}
