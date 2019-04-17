package com.fisherman.trainingdiary.activity.inject.module.creator;

import android.content.Context;

import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.fisherman.trainingdiary.activity.view.swipe_menu_creator.ExerciseSwipeMenuCreator;

import dagger.Module;
import dagger.Provides;

@Module
public class ExerciseMenuCreatorModule {

    @Provides
    SwipeMenuCreator provideCreator(Context context) {
        return new ExerciseSwipeMenuCreator(context);
    }
}
