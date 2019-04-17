package com.fisherman.trainingdiary.activity.inject.component.profile;

import com.fisherman.trainingdiary.activity.activity.profile.ProfileUpdateActivity;
import com.fisherman.trainingdiary.activity.inject.module.profile.ProfileUpdateContextModule;
import com.fisherman.trainingdiary.activity.inject.module.profile.ProfileUpdatePresenterModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {ProfileUpdatePresenterModule.class, ProfileUpdateContextModule.class, ToastModule.class})
public interface ProfileUpdateComponent {

    void inject(ProfileUpdateActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(ProfileUpdateActivity context);

        ProfileUpdateComponent build();
    }
}
