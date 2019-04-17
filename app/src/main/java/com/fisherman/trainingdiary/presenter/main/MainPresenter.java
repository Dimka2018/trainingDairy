package com.fisherman.trainingdiary.presenter.main;

import android.app.Activity;

import com.fisherman.trainingdiary.contract.main.MainContract;
import com.fisherman.trainingdiary.dao.DaoFactory;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private DaoFactory daoFactory;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public boolean hasCurrentUserTraining() {
        return daoFactory.getProfileDao().getCurrent().getCurrentDay() != null;
    }
}
