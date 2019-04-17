package com.fisherman.trainingdiary.contract.profile;

import com.fisherman.trainingdiary.entity.Profile;

public interface ProfileCreateContract {

    public interface View {

        void onSaveButtonClicked();

        void finish();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        void saveProfile(Profile profile);
    }
}
