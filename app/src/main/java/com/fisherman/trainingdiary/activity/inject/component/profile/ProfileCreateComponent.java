package com.fisherman.trainingdiary.activity.inject.component.profile;

import com.fisherman.trainingdiary.activity.activity.profile.ProfileCreateActivity;
import com.fisherman.trainingdiary.activity.inject.module.profile.ProfileCreateContextModule;
import com.fisherman.trainingdiary.activity.inject.module.profile.ProfileCreatePresenterModule;
import com.fisherman.trainingdiary.activity.inject.module.toast.ToastModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {ProfileCreatePresenterModule.class, ProfileCreateContextModule.class, ToastModule.class})
public interface ProfileCreateComponent {

    void inject(ProfileCreateActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(ProfileCreateActivity context);

        ProfileCreateComponent build();
    }
}
