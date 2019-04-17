package com.fisherman.trainingdiary.activity.inject.component.workout;

import com.fisherman.trainingdiary.activity.activity.workout.WorkoutActivity;
import com.fisherman.trainingdiary.activity.inject.annotation.ActivityScope;
import com.fisherman.trainingdiary.activity.inject.module.adapter.DefaultAdapterModule;
import com.fisherman.trainingdiary.activity.inject.module.creator.WorkoutMenuCreatorModule;
import com.fisherman.trainingdiary.activity.inject.module.dialog.DeleteWorkoutDialog;
import com.fisherman.trainingdiary.activity.inject.module.entity_source.WorkoutEntitySourceModule;
import com.fisherman.trainingdiary.activity.inject.module.listener.WorkoutItemListenerModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;
import com.fisherman.trainingdiary.activity.inject.module.workout.WorkoutContextModule;
import com.fisherman.trainingdiary.activity.inject.module.workout.WorkoutPresenterModule;

import dagger.BindsInstance;
import dagger.Component;

@ActivityScope
@Component(modules = {WorkoutPresenterModule.class, DefaultAdapterModule.class,
        WorkoutContextModule.class, DeleteWorkoutDialog.class, WorkoutMenuCreatorModule.class,
        WorkoutEntitySourceModule.class, WorkoutItemListenerModule.class, ToastModule.class})
public interface WorkoutComponent {

    void inject(WorkoutActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(WorkoutActivity context);

        WorkoutComponent build();
    }
}
