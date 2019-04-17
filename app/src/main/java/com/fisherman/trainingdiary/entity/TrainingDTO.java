package com.fisherman.trainingdiary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrainingDTO {

    private String ExerciseName;

    private Integer NumberSets;

    private Integer numberReps;

    private boolean isCompleted;

    private Integer weight;

    private String weightName;

}
