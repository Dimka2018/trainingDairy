package com.fisherman.trainingdiary.activity.inject.module.profile;

import com.fisherman.trainingdiary.contract.profile.ProfileCreateContract;
import com.fisherman.trainingdiary.presenter.profile.ProfileCreatePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileCreatePresenterModule {

    @Provides
    ProfileCreateContract.Presenter providePresenter(ProfileCreateContract.View view) {
        return new ProfileCreatePresenter(view);
    }
}
