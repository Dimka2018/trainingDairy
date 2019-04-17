package com.fisherman.trainingdiary.dao.sqlite;

import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.entity.History;
import com.fisherman.trainingdiary.entity.HistoryDao;
import com.fisherman.trainingdiary.entity.MassType;
import com.fisherman.trainingdiary.entity.Profile;
import com.fisherman.trainingdiary.entity.ProfileDao;
import com.fisherman.trainingdiary.entity.Trainee;
import com.fisherman.trainingdiary.entity.TraineeDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class SQLiteHistoryDao implements com.fisherman.trainingdiary.dao.HistoryDao {

    private HistoryDao historyDao;

    @Override
    public History save(History history) {
        historyDao.save(history);
        return history;
    }

    @Override
    public List<History> getHistoryList(Exercise exercise, MassType massType) {
        QueryBuilder<History> builder = historyDao.queryBuilder().where(HistoryDao.Properties
                .ExerciseId.eq(exercise.getId())).where(HistoryDao.Properties.MassTypeId.eq
                (massType.getId()));
        builder.join(Trainee.class, HistoryDao.Properties.TraineeId);
        builder.join(Profile.class, TraineeDao.Properties.ProfileId).where
                (ProfileDao.Properties.IsActive.eq(true));
        return builder.list();
    }

    @Override
    public List<History> getAll() {
        return historyDao.loadAll();
    }

}
