package com.fisherman.trainingdiary.dao;

import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.entity.History;
import com.fisherman.trainingdiary.entity.MassType;

import java.util.List;

public interface HistoryDao {

    List<History> getAll();

    History save(History history);

    List<History> getHistoryList(Exercise exercise, MassType massType);
}
