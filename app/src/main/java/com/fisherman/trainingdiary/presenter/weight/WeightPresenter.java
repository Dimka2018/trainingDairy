package com.fisherman.trainingdiary.presenter.weight;

import android.app.Activity;

import com.fisherman.trainingdiary.contract.weight.WeightContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.MassType;

import java.util.List;

public class WeightPresenter implements WeightContract.Presenter {

    private WeightContract.View view;
    private DaoFactory daoFactory;

    public WeightPresenter(WeightContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public List<MassType> getMassTypeList() {
        return daoFactory.getMassTypeDao().getMassTypeList();
    }

    @Override
    public void deleteMassType(MassType massType) {
        daoFactory.getMassTypeDao().delete(massType);
        view.refresh();
    }
}
