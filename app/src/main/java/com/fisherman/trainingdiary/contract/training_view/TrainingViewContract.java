package com.fisherman.trainingdiary.contract.training_view;

import com.fisherman.trainingdiary.entity.MassType;

import java.util.List;

public interface TrainingViewContract {

    public interface View {

        void refresh();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        List<MassType> getWeightList();

        void saveWeight(MassType massType);
    }
}
