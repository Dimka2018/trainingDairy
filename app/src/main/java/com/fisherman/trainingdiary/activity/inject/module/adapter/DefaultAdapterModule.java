package com.fisherman.trainingdiary.activity.inject.module.adapter;

import android.content.Context;

import com.fisherman.trainingdiary.activity.inject.annotation.ActivityScope;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.AutoRefreshableListAdapter;
import com.fisherman.trainingdiary.activity.view.adapter.autorefresh.EntitySource;

import dagger.Module;
import dagger.Provides;

@Module
public class DefaultAdapterModule {

    @ActivityScope
    @Provides
    AutoRefreshableListAdapter provideAdapter(Context context, EntitySource entitySource) {
        return new AutoRefreshableListAdapter(context, entitySource);
    }
}
