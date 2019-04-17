package com.fisherman.trainingdiary.dao.sqlite;

import com.fisherman.trainingdiary.dao.TraineeDao;
import com.fisherman.trainingdiary.entity.Trainee;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SQLiteTraineeDao implements TraineeDao {

    private com.fisherman.trainingdiary.entity.TraineeDao traineeDao;

    @Override
    public Trainee save(Trainee trainee) {
        traineeDao.save(trainee);
        return trainee;
    }

    @Override
    public List<Trainee> getListForProfile(Long profileId) {
        return traineeDao.queryBuilder()
                .where(com.fisherman.trainingdiary.entity.TraineeDao.Properties.ProfileId.eq(profileId))
                .list();
    }
}
