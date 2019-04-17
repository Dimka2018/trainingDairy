package com.fisherman.trainingdiary.activity.inject.component.weight;

import com.fisherman.trainingdiary.activity.activity.weight.WeightCreateActivity;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;
import com.fisherman.trainingdiary.activity.inject.module.weight.WeightCreateContextModule;
import com.fisherman.trainingdiary.activity.inject.module.weight.WeightCreatePresenterModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {WeightCreatePresenterModule.class, WeightCreateContextModule.class, ToastModule.class})
public interface WeightCreateComponent {

    void inject(WeightCreateActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(WeightCreateActivity context);

        WeightCreateComponent build();
    }
}
