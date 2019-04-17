package com.fisherman.trainingdiary.dao;

import com.fisherman.trainingdiary.entity.Trainee;

import java.util.List;

public interface TraineeDao {

    Trainee save(Trainee trainee);

    List<Trainee> getListForProfile(Long profileId);
}
