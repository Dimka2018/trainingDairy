package com.fisherman.trainingdiary.dto;

import com.fisherman.trainingdiary.entity.Exercise;
import com.fisherman.trainingdiary.entity.History;
import com.fisherman.trainingdiary.entity.MassType;

import lombok.Data;

@Data
public class WorkoutDTO {

    private Exercise exercise;
    private int numberSets;
    private int numberReps;
    private long lastWeight;
    private MassType lastMeasure;
    private boolean isMaxWeight;
    private boolean lastComplete;
    private boolean isCompleted;

    public History getHistory() {
        History history = new History();
        history.setExerciseId(exercise.getId());
        history.setExercise(exercise);
        history.setNumberReps(numberReps);
        history.setNumberSets(numberSets);
        history.setIsMaxWeight(isMaxWeight);
        if (!isCompleted || isMaxWeight) {
            history.setWeight(lastWeight);
        }
        return history;
    }
}
