package com.fisherman.trainingdiary.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Keep
@Entity(createInDb = false)
public class TrainingPart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id(autoincrement = true)
    private Long id;
    private Long dayId;
    private Long exerciseId;
    private int numberSets;
    private int numberReps;
    private Long lastHistoryId;

    @ToOne(joinProperty = "lastHistoryId")
    private History lastHistory;

    @ToOne(joinProperty = "exerciseId")
    private Exercise exercise;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 770718190)
    private transient TrainingPartDao myDao;


    public TrainingPart(Long id, Long dayId, Long exerciseId, int numberSets, int numberReps,
            Long lastHistoryId) {
        this.id = id;
        this.dayId = dayId;
        this.exerciseId = exerciseId;
        this.numberSets = numberSets;
        this.numberReps = numberReps;
        this.lastHistoryId = lastHistoryId;
    }

    @Generated(hash = 1176278852)
    public TrainingPart() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDayId() {
        return this.dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public Long getExerciseId() {
        return this.exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getNumberSets() {
        return this.numberSets;
    }

    public void setNumberSets(int numberSets) {
        this.numberSets = numberSets;
    }

    public int getNumberReps() {
        return this.numberReps;
    }

    public void setNumberReps(int numberReps) {
        this.numberReps = numberReps;
    }

    public Long getLastHistoryId() {
        return this.lastHistoryId;
    }

    public void setLastHistoryId(Long lastHistoryId) {
        this.lastHistoryId = lastHistoryId;
    }

    /** To-one relationship, resolved on first access. */
    public History getLastHistory() {
        Long key = this.lastHistoryId;
        if (key != null && lastHistory == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HistoryDao targetDao = daoSession.getHistoryDao();
            lastHistory = targetDao.load(key);
        }
        return lastHistory;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void setLastHistory(History lastHistory) {
            this.lastHistory = lastHistory;
            lastHistoryId = lastHistory == null ? null : lastHistory.getId();
    }

    /** To-one relationship, resolved on first access. */
    @Keep
    public Exercise getExercise() {
        Long key = this.exerciseId;
        if (key != null && exercise == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ExerciseDao targetDao = daoSession.getExerciseDao();
            exercise = targetDao.load(key);
        }
        return exercise;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void setExercise(Exercise exercise) {
            this.exercise = exercise;
            exerciseId = exercise == null ? null : exercise.getId();
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1442666287)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTrainingPartDao() : null;
    }
}
