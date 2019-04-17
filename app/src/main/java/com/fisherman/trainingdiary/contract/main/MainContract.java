package com.fisherman.trainingdiary.contract.main;

public interface MainContract {

    public interface View {

        void openWorkoutList();
    }

    public interface Presenter {

        boolean hasCurrentUserTraining();
    }
}
