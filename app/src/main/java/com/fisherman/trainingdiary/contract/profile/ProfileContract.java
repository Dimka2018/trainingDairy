package com.fisherman.trainingdiary.contract.profile;

import com.fisherman.trainingdiary.entity.Profile;

import java.util.List;

public interface ProfileContract {

    public static final String EXTRA_KEY = "profile";

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
