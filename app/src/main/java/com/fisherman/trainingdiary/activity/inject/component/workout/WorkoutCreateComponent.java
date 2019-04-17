package com.fisherman.trainingdiary.activity.inject.component.workout;

import com.fisherman.trainingdiary.activity.activity.workout.WorkoutCreateActivity;
import com.fisherman.trainingdiary.activity.inject.module.list.ListModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;
import com.fisherman.trainingdiary.activity.inject.module.workout.WorkoutCreateContextModule;
import com.fisherman.trainingdiary.activity.inject.module.workout.WorkoutCreatePresenterModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {WorkoutCreatePresenterModule.class, WorkoutCreateContextModule.class,
        ListModule.class, ToastModule.class})
public interface WorkoutCreateComponent {

    void inject(WorkoutCreateActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(WorkoutCreateActivity context);

        WorkoutCreateComponent build();
    }
}
