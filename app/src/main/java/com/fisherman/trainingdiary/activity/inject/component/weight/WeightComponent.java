package com.fisherman.trainingdiary.activity.inject.component.weight;

import com.fisherman.trainingdiary.activity.activity.weight.WeightActivity;
import com.fisherman.trainingdiary.activity.inject.annotation.ActivityScope;
import com.fisherman.trainingdiary.activity.inject.module.adapter.DefaultAdapterModule;
import com.fisherman.trainingdiary.activity.inject.module.creator.WeightMenuCreatorModule;
import com.fisherman.trainingdiary.activity.inject.module.dialog.WeightDeleteDialogModule;
import com.fisherman.trainingdiary.activity.inject.module.entity_source.WeightEntitySourceModule;
import com.fisherman.trainingdiary.activity.inject.module.listener.WeightItemListenerModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;
import com.fisherman.trainingdiary.activity.inject.module.weight.WeightContextModule;
import com.fisherman.trainingdiary.activity.inject.module.weight.WeightPresenterModule;

import dagger.BindsInstance;
import dagger.Component;

@ActivityScope
@Component(modules = {WeightPresenterModule.class, WeightContextModule.class,
        WeightMenuCreatorModule.class, DefaultAdapterModule.class, WeightDeleteDialogModule.class,
        WeightEntitySourceModule.class, WeightItemListenerModule.class, ToastModule.class})
public interface WeightComponent {

    void inject(WeightActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(WeightActivity context);

        WeightComponent build();
    }
}
