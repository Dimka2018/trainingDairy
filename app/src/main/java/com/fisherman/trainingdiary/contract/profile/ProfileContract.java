package com.fisherman.trainingdiary.contract.profile;

import com.fisherman.trainingdiary.entity.Profile;

import java.util.List;

public interface ProfileContract {

    public interface View {

        void refresh();

        void showErrorMessage(String message);
    }

    public interface Presenter {

        List<Profile> getAllProfiles();

        void activateProfile(Profile profile);

        void deleteProfile(Profile profile);
    }
}
