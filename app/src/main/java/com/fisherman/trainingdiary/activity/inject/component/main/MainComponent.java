package com.fisherman.trainingdiary.activity.inject.component.main;

import com.fisherman.trainingdiary.activity.activity.main.MainActivity;
import com.fisherman.trainingdiary.activity.inject.module.dialog.NoWorkoutDialogModule;
import com.fisherman.trainingdiary.activity.inject.module.main.MainContextModule;
import com.fisherman.trainingdiary.activity.inject.module.main.MainPresenterModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {MainPresenterModule.class, MainContextModule.class, NoWorkoutDialogModule.class})
public interface MainComponent {

    void inject(MainActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(MainActivity context);

        MainComponent build();
    }
}
