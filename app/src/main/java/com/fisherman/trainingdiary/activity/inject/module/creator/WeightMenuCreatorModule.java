package com.fisherman.trainingdiary.activity.inject.module.creator;

import android.content.Context;

import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.fisherman.trainingdiary.activity.view.swipe_menu_creator.WeightSwipeMenuCreator;

import dagger.Module;
import dagger.Provides;

@Module
public class WeightMenuCreatorModule {

    @Provides
    SwipeMenuCreator provideSwipeMenuCreator(Context context) {
        return new WeightSwipeMenuCreator(context);
    }
}
