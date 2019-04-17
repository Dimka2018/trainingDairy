package com.fisherman.trainingdiary.contract.profile;

import com.fisherman.trainingdiary.entity.Profile;

public interface ProfileUpdateContract {

    public interface View {

        void onUpdateButtonClicked();

        void finish();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        void updateProfile(Profile profile);
    }
}
