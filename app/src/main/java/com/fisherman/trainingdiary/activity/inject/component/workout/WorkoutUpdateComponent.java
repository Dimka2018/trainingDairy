package com.fisherman.trainingdiary.activity.inject.component.workout;

import com.fisherman.trainingdiary.activity.activity.workout.WorkoutUpdateActivity;
import com.fisherman.trainingdiary.activity.inject.module.list.ListModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;
import com.fisherman.trainingdiary.activity.inject.module.workout.WorkoutUpdateContextModule;
import com.fisherman.trainingdiary.activity.inject.module.workout.WorkoutUpdatePresenterModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {WorkoutUpdatePresenterModule.class, WorkoutUpdateContextModule.class,
        ToastModule.class, ListModule.class})
public interface WorkoutUpdateComponent {

    void inject(WorkoutUpdateActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(WorkoutUpdateActivity context);

        WorkoutUpdateComponent build();
    }
}
