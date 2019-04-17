package com.fisherman.trainingdiary.presenter.profile;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.profile.ProfileUpdateContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.Profile;
import com.fisherman.trainingdiary.exception.InvalidFieldValueException;
import com.fisherman.trainingdiary.exception.ObjectAlreadyExistsException;

public class ProfileUpdatePresenter implements ProfileUpdateContract.Presenter {

    private ProfileUpdateContract.View view;
    private DaoFactory daoFactory;

    public ProfileUpdatePresenter(ProfileUpdateContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public void updateProfile(Profile profile) {
        try {
            validateProfile(profile);
            daoFactory.getProfileDao().updateProfile(profile);
            view.finish();
        } catch (Exception e) {
            view.showErrorMessage(e.getMessage());
        }
    }

    private void validateProfile(Profile profile) throws Exception {
        Activity activity = (Activity) view;
        if (profile.getName() == null || "".equals(profile.getName().trim())) {
            throw new InvalidFieldValueException(activity.getString(R.string.empty_field));
        }
        if (daoFactory.getProfileDao().isProfileExists(profile)) {
            throw new ObjectAlreadyExistsException(activity.getString(R.string
                    .profile_already_exists));
        }
    }
}
