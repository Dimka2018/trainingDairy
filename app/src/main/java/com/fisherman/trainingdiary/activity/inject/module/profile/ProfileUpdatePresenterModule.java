package com.fisherman.trainingdiary.activity.inject.module.profile;

import com.fisherman.trainingdiary.contract.profile.ProfileUpdateContract;
import com.fisherman.trainingdiary.presenter.profile.ProfileUpdatePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileUpdatePresenterModule {

    @Provides
    ProfileUpdateContract.Presenter providePresenter(ProfileUpdateContract.View view) {
        return new ProfileUpdatePresenter(view);
    }
}
