package com.fisherman.trainingdiary.dao;

import com.fisherman.trainingdiary.entity.MassType;

import java.util.List;

public interface MassTypeDao {

    MassType getMassTypeById(Long typeId);

    boolean isMassTypeExists(MassType massType);

    List<MassType> getMassTypeList();

    MassType save(MassType massType);

    void delete(MassType massType);

    void update(MassType massType);
}
