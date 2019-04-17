package com.fisherman.trainingdiary.presenter.profile;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.profile.ProfileCreateContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.entity.Profile;
import com.fisherman.trainingdiary.exception.InvalidFieldValueException;
import com.fisherman.trainingdiary.exception.ObjectAlreadyExistsException;

public class ProfileCreatePresenter implements ProfileCreateContract.Presenter {

    private ProfileCreateContract.View view;
    private DaoFactory daoFactory;

    public ProfileCreatePresenter(ProfileCreateContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public void saveProfile(Profile profile) {
        try {
            validateProfile(profile);
        } catch (Exception e) {
            view.showErrorMessage(e.getMessage());
        }
        daoFactory.getProfileDao().addProfile(profile);
        view.finish();
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
