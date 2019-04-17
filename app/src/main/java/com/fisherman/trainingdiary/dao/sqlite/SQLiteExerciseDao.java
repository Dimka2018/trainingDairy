package com.fisherman.trainingdiary.dao.sqlite;

import com.fisherman.trainingdiary.dao.ExerciseDao;
import com.fisherman.trainingdiary.entity.Exercise;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SQLiteExerciseDao implements ExerciseDao {

    private com.fisherman.trainingdiary.entity.ExerciseDao exerciseDao;

    @Override
    public List<String> getExerciseNameList() {
        List<String> nameList = new ArrayList<>();
        for (Exercise exercise : exerciseDao.loadAll()){
            nameList.add(exercise.getName());
        }
        return nameList;
    }

    @Override
    public Exercise getExerciseById(Long id) {
        return exerciseDao.queryBuilder()
                .where(com.fisherman.trainingdiary.entity.ExerciseDao.Properties.Id.eq(id))
                .uniqueOrThrow();
    }

    @Override
    public List<Exercise> getExerciseList() {
        return exerciseDao.loadAll();
    }

    @Override
    public boolean isExerciseExists(Exercise exercise) {
        return exerciseDao.queryBuilder().where(com.fisherman.trainingdiary.entity.ExerciseDao
                .Properties.Name.eq(exercise.getName())).count() > 0;
    }

    @Override
    public boolean isExerciseNameNonUnique(String name) {
        return exerciseDao.queryBuilder().where(com.fisherman.trainingdiary.entity.ExerciseDao
                .Properties.Name.eq(name)).count() > 1;
    }

    @Override
    public Exercise getExerciseByName(String name) {
        return  exerciseDao.queryBuilder().where(com.fisherman.trainingdiary.entity.ExerciseDao
                .Properties.Name.eq(name)).build().unique();
    }

    @Override
    public Exercise save(Exercise exercise) {
        exerciseDao.insert(exercise);
        return exercise;
    }

    @Override
    public void updateExercise(Exercise exercise) {
        exerciseDao.update(exercise);
    }

    @Override
    public void delete(Exercise exercise) {
        exerciseDao.delete(exercise);
    }
}
