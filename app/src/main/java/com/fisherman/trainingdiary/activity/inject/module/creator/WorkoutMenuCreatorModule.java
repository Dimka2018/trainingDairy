package com.fisherman.trainingdiary.activity.inject.module.creator;

import android.content.Context;

import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.fisherman.trainingdiary.activity.view.swipe_menu_creator.WorkoutSwipeMenuCreator;

import dagger.Module;
import dagger.Provides;

@Module
public class WorkoutMenuCreatorModule {

    @Provides
    SwipeMenuCreator provideMenuCreator(Context context) {
        return new WorkoutSwipeMenuCreator(context);
    }
}
