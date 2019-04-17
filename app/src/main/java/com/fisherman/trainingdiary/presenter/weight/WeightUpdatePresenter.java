package com.fisherman.trainingdiary.presenter.weight;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.weight.WeightUpdateContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.MassType;
import com.fisherman.trainingdiary.exception.InvalidFieldValueException;
import com.fisherman.trainingdiary.exception.ObjectAlreadyExistsException;

public class WeightUpdatePresenter implements WeightUpdateContract.Presenter {

    private DaoFactory daoFactory;
    private WeightUpdateContract.View view;

    public WeightUpdatePresenter(WeightUpdateContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public void updateWeight(MassType massType) {
        try {
            validateWeight(massType);
        } catch (Exception e) {
            view.showErrorMessage(e.getMessage());
        }
        daoFactory.getMassTypeDao().update(massType);
        view.finish();
    }

    private void validateWeight(MassType massType) throws Exception {
        Activity activity = (Activity) view;
        if (massType.getName() == null || "".equals(massType.getName().trim())) {
            throw new InvalidFieldValueException(activity.getString(R.string.empty_field));
        }
        if (daoFactory.getMassTypeDao().isMassTypeExists(massType)) {
            throw new ObjectAlreadyExistsException(activity.getString(R.string
                    .weight_already_exists));
        }
    }
}
