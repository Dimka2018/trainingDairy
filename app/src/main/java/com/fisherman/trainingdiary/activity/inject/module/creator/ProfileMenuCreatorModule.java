package com.fisherman.trainingdiary.activity.inject.module.creator;

import android.content.Context;

import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.fisherman.trainingdiary.activity.view.swipe_menu_creator.ProfileSwipeMenuCreator;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileMenuCreatorModule {

    @Provides
    SwipeMenuCreator provideSwipeMenuCreator(Context context) {
        return new ProfileSwipeMenuCreator(context);
    }
}
