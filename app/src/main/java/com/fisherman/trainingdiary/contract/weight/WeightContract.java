package com.fisherman.trainingdiary.contract.weight;

import com.fisherman.trainingdiary.entity.MassType;

import java.util.List;

public interface WeightContract {

    interface View {

        void refresh();

        void showErrorMesage(String message);
    }

    interface Presenter {

        List<MassType> getMassTypeList();

        void deleteMassType(MassType massType);
    }
}
