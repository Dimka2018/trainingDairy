package com.fisherman.trainingdiary.contract.weight;

import com.fisherman.trainingdiary.entity.MassType;

public interface WeightCreateContract {

    interface View {

        void onSaveButtonClick();

        void finish();

        void showErrorMessage(String message);
    }

    interface Presenter {

        void saveWeight(MassType massType);
    }
}
