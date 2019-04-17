package com.fisherman.trainingdiary.dao;

import com.fisherman.trainingdiary.entity.Profile;

import java.util.List;

public interface ProfileDao {

    Profile getCurrent();

    List<Profile> getAllProfiles();

    Profile addProfile(Profile profile);

    boolean isProfileExists(Profile profile);

    void updateProfile(Profile profile);

    void deleteProfile(Profile profile);
}
