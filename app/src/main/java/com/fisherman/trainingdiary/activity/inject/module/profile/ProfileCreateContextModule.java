package com.fisherman.trainingdiary.activity.inject.module.profile;

import android.content.Context;

import com.fisherman.trainingdiary.activity.activity.profile.ProfileCreateActivity;
import com.fisherman.trainingdiary.contract.profile.ProfileCreateContract;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ProfileCreateContextModule {

    @Binds
    abstract ProfileCreateContract.View bindView(ProfileCreateActivity view);

    @Binds
    abstract Context bindContext(ProfileCreateActivity context);
}
