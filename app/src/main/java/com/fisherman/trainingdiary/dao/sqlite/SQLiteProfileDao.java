package com.fisherman.trainingdiary.dao.sqlite;

import com.fisherman.trainingdiary.dao.ProfileDao;
import com.fisherman.trainingdiary.entity.Profile;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SQLiteProfileDao implements ProfileDao {

    private static final Integer ACTIVE_INDICATOR = 1;

    private com.fisherman.trainingdiary.entity.ProfileDao profileDao;

    @Override
    public Profile getCurrent() {
        return profileDao.queryBuilder().where(com.fisherman.trainingdiary.entity.ProfileDao
                .Properties
                .IsActive.eq(ACTIVE_INDICATOR)).build().unique();
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileDao.loadAll();
    }

    @Override
    public Profile addProfile(Profile profile) {
        profileDao.insert(profile);
        return profile;
    }

    @Override
    public boolean isProfileExists(Profile profile) {
        return profileDao.queryBuilder().where(com.fisherman.trainingdiary.entity.ProfileDao
                .Properties.Name.eq(profile.getName())).count() > 0;
    }

    @Override
    public void updateProfile(Profile profile) {
        profileDao.update(profile);
    }

    @Override
    public void deleteProfile(Profile profile) {
        profileDao.delete(profile);
    }
}
