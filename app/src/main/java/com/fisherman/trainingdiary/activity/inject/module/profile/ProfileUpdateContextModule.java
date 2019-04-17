package com.fisherman.trainingdiary.activity.inject.module.profile;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.profile.ProfileUpdateActivity;
import com.fisherman.trainingdiary.contract.profile.ProfileUpdateContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ProfileUpdateContextModule {

    @Binds
    abstract ProfileUpdateContract.View bindView(ProfileUpdateActivity view);

    @Binds
    abstract Context bindContext(ProfileUpdateActivity context);
}
