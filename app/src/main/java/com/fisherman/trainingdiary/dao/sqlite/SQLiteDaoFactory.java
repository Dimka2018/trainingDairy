package com.fisherman.trainingdiary.dao.sqlite;

import android.app.Application;

import com.fisherman.trainingdiary.dao.DaoFactory;
import com.fisherman.trainingdiary.dao.DayDao;
import com.fisherman.trainingdiary.dao.ExerciseDao;
import com.fisherman.trainingdiary.dao.HistoryDao;
import com.fisherman.trainingdiary.dao.MassTypeDao;
import com.fisherman.trainingdiary.dao.ProfileDao;
import com.fisherman.trainingdiary.dao.TraineeDao;
import com.fisherman.trainingdiary.dao.TrainingPartDao;
import com.fisherman.trainingdiary.dao.WorkoutDao;
import com.fisherman.trainingdiary.database.SQLiteOpenHelper;
import com.fisherman.trainingdiary.entity.DaoMaster;
import com.fisherman.trainingdiary.entity.DaoSession;

import org.greenrobot.greendao.database.Database;


public class SQLiteDaoFactory extends Application implements DaoFactory {

    private static final String DB_NAME = "trainingDairy.db";
    private ProfileDao profileDao;
    private WorkoutDao workoutDao;
    private ExerciseDao exerciseDao;
    private DayDao dayDao;
    private TrainingPartDao trainingPartDao;
    private HistoryDao historyDao;
    private MassTypeDao massTypeDao;
    private TraineeDao traineeDao;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        Database database = new SQLiteOpenHelper(this, DB_NAME)
                .getWritableDb();
        database.execSQL("PRAGMA foreign_keys=ON");
        daoSession = new DaoMaster(database)
                .newSession();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        daoSession.clear();
    }


    @Override
    public ProfileDao getProfileDao() {
        if (profileDao == null){
            profileDao = new SQLiteProfileDao(daoSession.getProfileDao());
        }
        return profileDao;
    }

    @Override
    public HistoryDao getHistoryDao() {
        if (historyDao == null) {
            historyDao = new SQLiteHistoryDao(daoSession.getHistoryDao());
        }
        return historyDao;
    }

    @Override
    public MassTypeDao getMassTypeDao() {
        if (massTypeDao == null) {
            massTypeDao = new SQLiteMassTypeDao(daoSession.getMassTypeDao());
        }
        return massTypeDao;
    }

    @Override
    public TraineeDao getTraineeDao() {
        if (traineeDao == null) {
            traineeDao = new SQLiteTraineeDao(daoSession.getTraineeDao());
        }
        return traineeDao;
    }

    @Override
    public WorkoutDao getWorkoutDao() {
        if (workoutDao == null){
            workoutDao = new SQLiteWorkoutDao(daoSession);
        }
        return workoutDao;
    }

    @Override
    public ExerciseDao getExerciseDao() {
        if (exerciseDao == null){
            exerciseDao = new SQLiteExerciseDao(daoSession.getExerciseDao());
        }
        return exerciseDao;
    }

    @Override
    public DayDao getDayDao() {
        if (dayDao == null) {
            dayDao = new SQLiteDayDao(daoSession.getDayDao());
        }
        return dayDao;
    }

    @Override
    public TrainingPartDao getTrainingPartDao() {
        if (trainingPartDao == null) {
            trainingPartDao = new SQLiteTrainingPartDao(daoSession.getTrainingPartDao());
        }
        return trainingPartDao;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
