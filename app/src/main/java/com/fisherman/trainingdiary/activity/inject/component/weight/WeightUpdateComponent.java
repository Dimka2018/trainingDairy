package com.fisherman.trainingdiary.activity.inject.component.weight;

import com.fisherman.trainingdiary.activity.activity.weight.WeightUpdateActivity;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;
import com.fisherman.trainingdiary.activity.inject.module.weight.WeightUpdateContextModule;
import com.fisherman.trainingdiary.activity.inject.module.weight.WeightUpdatePresenterModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {WeightUpdatePresenterModule.class, WeightUpdateContextModule.class, ToastModule.class})
public interface WeightUpdateComponent {

    void inject(WeightUpdateActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(WeightUpdateActivity context);

        WeightUpdateComponent build();
    }
}
