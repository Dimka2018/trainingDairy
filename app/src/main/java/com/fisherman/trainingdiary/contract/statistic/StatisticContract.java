package com.fisherman.trainingdiary.contract.statistic;

import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.entity.History;
import com.fisherman.trainingdiary.entity.MassType;

import java.util.List;

public interface StatisticContract {

    public interface View {

    }

    public interface Presenter {

        List<Exercise> getExerciseList();

        List<MassType> getMassTypeList();

        List<History> getHistoryList(Exercise exercise, MassType massType);
    }
}
