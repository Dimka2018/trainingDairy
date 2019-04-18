package com.fisherman.trainingdiary.dao.sqlite;

import com.fisherman.trainingdiary.dao.ProfileDao;
import com.fisherman.trainingdiary.entity.Profile;

import org.greenrobot.greendao.query.QueryBuilder;

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
        return profileDao.queryBuilder().orderAsc(com.fisherman.trainingdiary.entity.ProfileDao
                .Properties.Name).list();
    }

    @Override
    public Profile addProfile(Profile profile) {
        profileDao.insert(profile);
        return profile;
    }

    @Override
    public boolean isProfileExists(Profile profile) {
        QueryBuilder<Profile> builder = profileDao.queryBuilder().where(com.fisherman.trainingdiary.entity.ProfileDao
                .Properties.Name.eq(profile.getName()));
        if (profile.getId() != null) {
            builder.where(com.fisherman.trainingdiary.entity.ProfileDao.Properties.Id.notEq
                    (profile.getId()));
        }
        return builder.count() > 0;
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
