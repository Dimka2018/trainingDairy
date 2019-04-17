package com.fisherman.trainingdiary.dao.sqlite;

import com.fisherman.trainingdiary.dao.TrainingPartDao;
import com.fisherman.trainingdiary.entity.TrainingPart;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SQLiteTrainingPartDao implements TrainingPartDao {

    private com.fisherman.trainingdiary.entity.TrainingPartDao trainingPartDao;

    @Override
    public TrainingPart save(TrainingPart trainingPart) {
        trainingPartDao.insert(trainingPart);
        return trainingPart;
    }

    @Override
    public void delete(TrainingPart trainingPart) {
        trainingPartDao.delete(trainingPart);
    }

    @Override
    public void update(TrainingPart trainingPart) {
        trainingPartDao.update(trainingPart);
    }

    @Override
    public List<TrainingPart> getAll() {
        return trainingPartDao.loadAll();
    }

    @Override
    public List<TrainingPart> getTrainingPartListForDay(Long dayId) {
        return trainingPartDao.queryBuilder()
                .where(com.fisherman.trainingdiary.entity.TrainingPartDao.Properties.DayId.eq(dayId))
                .list();
    }
}