package com.fisherman.trainingdiary.presenter.statistic;

import android.app.Activity;

import com.fisherman.trainingdiary.contract.statistic.StatisticContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.entity.History;
import com.fisherman.trainingdiary.entity.MassType;

import java.util.List;

public class StatisticPresenter implements StatisticContract.Presenter {

    private StatisticContract.View view;
    private DaoFactory daoFactory;

    public StatisticPresenter(StatisticContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public List<Exercise> getExerciseList() {
        return daoFactory.getExerciseDao().getExerciseList();
    }

    @Override
    public List<MassType> getMassTypeList() {
        return daoFactory.getMassTypeDao().getMassTypeList();
    }

    @Override
    public List<History> getHistoryList(Exercise exercise, MassType massType) {
        return daoFactory.getHistoryDao().getHistoryList(exercise, massType);
    }
}
