package com.fisherman.trainingdiary.presenter.training_view;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.training_view.TrainingViewContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.MassType;
import com.fisherman.trainingdiary.exception.InvalidFieldValueException;
import com.fisherman.trainingdiary.exception.ObjectAlreadyExistsException;

import java.util.List;

public class TrainingViewPresenter implements TrainingViewContract.Presenter {

    private TrainingViewContract.View view;
    private Activity activity;
    private DaoFactory daoFactory;

    public TrainingViewPresenter(TrainingViewContract.View view, Activity activity) {
        this.view = view;
        this.activity = activity;
        this.daoFactory = (DaoFactory) activity.getApplication();
    }

    @Override
    public List<MassType> getWeightList() {
        return daoFactory.getMassTypeDao().getMassTypeList();
    }

    @Override
    public void saveWeight(MassType massType) {
        try {
            validateWeight(massType);
            daoFactory.getMassTypeDao().save(massType);
            view.refresh();
        } catch (Exception e) {
            view.showErrorMessage(e.getMessage());
        }
    }

    private void validateWeight(MassType massType) throws Exception {
        if (massType.getName() == null || "".equals(massType.getName())) {
            throw new InvalidFieldValueException(activity.getString(R.string.empty_field));
        }
        if (daoFactory.getMassTypeDao().isMassTypeExists(massType)) {
            throw new ObjectAlreadyExistsException(activity.getString(R.string
                    .weight_already_exists));
        }
    }
}
