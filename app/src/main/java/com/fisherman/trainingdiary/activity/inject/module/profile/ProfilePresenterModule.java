package com.fisherman.trainingdiary.activity.inject.module.profile;

import com.fisherman.trainingdiary.contract.profile.ProfileContract;
import com.fisherman.trainingdiary.presenter.profile.ProfilePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfilePresenterModule {

    @Provides
    ProfileContract.Presenter providePresenter(ProfileContract.View view) {
        return new ProfilePresenter(view);
    }
}
