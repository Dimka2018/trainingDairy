package com.fisherman.trainingdiary.contract.weight;

import com.fisherman.trainingdiary.entity.MassType;

public interface WeightUpdateContract {

    public interface View {

        void onUpdateButtonClick();

        void finish();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        void updateWeight(MassType massType);
    }
}
