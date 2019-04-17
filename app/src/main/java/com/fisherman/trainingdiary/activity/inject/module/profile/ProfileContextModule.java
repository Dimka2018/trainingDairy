package com.fisherman.trainingdiary.activity.inject.module.profile;

import android.app.Activity;
import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.profile.ProfileActivity;
import com.fisherman.trainingdiary.contract.profile.ProfileContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ProfileContextModule {

    @Binds
    abstract ProfileContract.View bindView(ProfileActivity view);

    @Binds
    abstract Context bindContext(ProfileActivity context);

    @Binds
    abstract Activity bindActivity(ProfileActivity activity);
}
