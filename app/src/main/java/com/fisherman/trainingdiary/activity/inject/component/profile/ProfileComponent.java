package com.fisherman.trainingdiary.activity.inject.component.profile;

import com.fisherman.trainingdiary.activity.activity.profile.ProfileActivity;
import com.fisherman.trainingdiary.activity.inject.annotation.ActivityScope;
import com.fisherman.trainingdiary.activity.inject.module.adapter.DefaultAdapterModule;
import com.fisherman.trainingdiary.activity.inject.module.creator.ProfileMenuCreatorModule;
import com.fisherman.trainingdiary.activity.inject.module.dialog.ProfileDeleteDialogModule;
import com.fisherman.trainingdiary.activity.inject.module.entity_source.ProfileEntitySource;
import com.fisherman.trainingdiary.activity.inject.module.listener.ProfileItemListenerModule;
import com.fisherman.trainingdiary.activity.inject.module.profile.ProfileContextModule;
import com.fisherman.trainingdiary.activity.inject.module.profile.ProfilePresenterModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;

import dagger.BindsInstance;
import dagger.Component;

@ActivityScope
@Component(modules = {ProfilePresenterModule.class, ProfileContextModule.class,
        ProfileMenuCreatorModule.class,
        DefaultAdapterModule.class, ProfileDeleteDialogModule.class, ProfileEntitySource.class,
        ProfileItemListenerModule.class, ToastModule.class})
public interface ProfileComponent {

    void inject(ProfileActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(ProfileActivity context);

        ProfileComponent build();
    }
}
