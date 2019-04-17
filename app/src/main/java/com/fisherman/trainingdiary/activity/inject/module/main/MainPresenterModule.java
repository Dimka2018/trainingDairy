package com.fisherman.trainingdiary.activity.inject.module.main;

import com.fisherman.trainingdiary.contract.main.MainContract;
import com.fisherman.trainingdiary.presenter.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPresenterModule {

    @Provides
    MainContract.Presenter providePresenter(MainContract.View view) {
        return new MainPresenter(view);
    }
}
