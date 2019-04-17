package com.fisherman.trainingdiary.dao;

import com.fisherman.trainingdiary.entity.TrainingPart;

import java.util.List;

public interface TrainingPartDao {

    TrainingPart save(TrainingPart trainingPart);

    List<TrainingPart> getTrainingPartListForDay(Long dayId);

    List<TrainingPart> getAll();

    void delete(TrainingPart trainingPart);

    void update(TrainingPart trainingPart);
}
