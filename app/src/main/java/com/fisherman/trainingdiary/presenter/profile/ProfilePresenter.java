package com.fisherman.trainingdiary.presenter.profile;

import android.app.Activity;

import com.fisherman.trainingdiary.R;
import com.fisherman.trainingdiary.contract.profile.ProfileContract;
import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.dao.ProfileDao;
import com.fisherman.trainingdiary.entity.Profile;
import com.fisherman.trainingdiary.exception.NoPermissionException;

import java.util.List;

public class ProfilePresenter implements ProfileContract.Presenter {

    private ProfileContract.View view;
    private DaoFactory daoFactory;

    public ProfilePresenter(ProfileContract.View view) {
        this.view = view;
        this.daoFactory = (DaoFactory) ((Activity) view).getApplication();
    }

    @Override
    public List<Profile> getAllProfiles() {
        return daoFactory.getProfileDao().getAllProfiles();
    }

    @Override
    public void activateProfile(Profile profile) {
        ProfileDao profileDao = daoFactory.getProfileDao();
        Profile currentProfile = profileDao.getCurrent();
        currentProfile.setIsActive(false);
        profileDao.updateProfile(currentProfile);
        profile.setIsActive(true);
        profileDao.updateProfile(profile);
        view.refresh();
    }

    @Override
    public void deleteProfile(Profile profile) {
        try {
            validate(profile);
            daoFactory.getProfileDao().deleteProfile(profile);
            view.refresh();
            System.out.println(daoFactory.getWorkoutDao().getAllWorkouts().size());
        } catch (Exception e) {
            view.showErrorMessage(e.getMessage());
        }
    }

    private void validate(Profile profile) throws Exception {
        Activity activity = (Activity) view;
        if (profile.isActive()) {
            throw new NoPermissionException(activity.getString(R.string.cant_delete_profile));
        }
    }
}
