package com.fisherman.trainingdiary.dao;

public interface DaoFactory {

    ProfileDao getProfileDao();

    WorkoutDao getWorkoutDao();

    ExerciseDao getExerciseDao();

    DayDao getDayDao();

    TrainingPartDao getTrainingPartDao();

    HistoryDao getHistoryDao();

    MassTypeDao getMassTypeDao();

    TraineeDao getTraineeDao();


}
