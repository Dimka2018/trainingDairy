package com.fisherman.trainingdiary.dao.sqlite;

import com.fisherman.trainingdiary.dao.MassTypeDao;
import com.fisherman.trainingdiary.entity.MassType;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SQLiteMassTypeDao implements MassTypeDao {

    private com.fisherman.trainingdiary.entity.MassTypeDao massTypeDao;

    @Override
    public MassType getMassTypeById(Long typeId) {
        return massTypeDao.queryBuilder()
                .where(com.fisherman.trainingdiary.entity.MassTypeDao.Properties.Id.eq(typeId))
                .unique();
    }

    @Override
    public boolean isMassTypeExists(MassType massType) {
        QueryBuilder<MassType> builder = massTypeDao.queryBuilder().where(com.fisherman.trainingdiary.entity.MassTypeDao
                .Properties.Name.eq(massType.getName()));
        if (massType.getId() != null) {
            builder.where(com.fisherman.trainingdiary.entity.MassTypeDao.Properties.Id.notEq
                    (massType.getId()));
        }
        return builder.count() > 0;
    }

    @Override
    public List<MassType> getMassTypeList() {
        return massTypeDao.queryBuilder().orderAsc(com.fisherman.trainingdiary.entity.MassTypeDao
                .Properties.Name).list();
    }

    @Override
    public void update(MassType massType) {
        massTypeDao.update(massType);
    }

    @Override
    public void delete(MassType massType) {
        massTypeDao.delete(massType);
    }

    @Override
    public MassType save(MassType massType) {
        massTypeDao.insert(massType);
        return massType;
    }
}
