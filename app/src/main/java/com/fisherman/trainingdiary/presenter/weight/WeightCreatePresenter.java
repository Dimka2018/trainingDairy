package com.fisherman.trainingdiary.presenter.weight;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.weight.WeightCreateContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.MassType;
import com.fisherman.trainingdiary.exception.InvalidFieldValueException;
import com.fisherman.trainingdiary.exception.ObjectAlreadyExistsException;

public class WeightCreatePresenter implements WeightCreateContract.Presenter {

    private WeightCreateContract.View view;
    private DaoFactory daoFactory;

    public WeightCreatePresenter(WeightCreateContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public void saveWeight(MassType massType) {
        try {
            validateWeight(massType);
            daoFactory.getMassTypeDao().save(massType);
            view.finish();
        } catch (Exception e) {
            view.showErrorMessage(e.getMessage());
        }

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
