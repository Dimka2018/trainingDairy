package com.fisherman.trainingdiary.entity;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.ToOne;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Keep
@Entity(createInDb = false)
public class History implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id(autoincrement = true)
    private Long id;
    private boolean isCompleted;
    private boolean isMaxWeight;
    private long weight;
    private Integer numberReps;
    private Integer numberSets;
    private Long massTypeId;
    private Long traineeId;
    private Long exerciseId;

    @ToOne(joinProperty = "massTypeId")
    private MassType massType;

    @ToOne(joinProperty = "exerciseId")
    private  Exercise exercise;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1462128466)
    private transient HistoryDao myDao;

    public History() {}

    @Generated(hash = 155104304)
    public History(Long id, boolean isCompleted, boolean isMaxWeight, long weight,
            Integer numberReps, Integer numberSets, Long massTypeId, Long traineeId,
            Long exerciseId) {
        this.id = id;
        this.isCompleted = isCompleted;
        this.isMaxWeight = isMaxWeight;
        this.weight = weight;
        this.numberReps = numberReps;
        this.numberSets = numberSets;
        this.massTypeId = massTypeId;
        this.traineeId = traineeId;
        this.exerciseId = exerciseId;
    }

    /** To-one relationship, resolved on first access. */
    public MassType getMassType() {
        Long key = this.massTypeId;
        if (key != null && massType == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            massType = daoSession.getMassTypeDao().load(key);
        }
        return massType;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void setMassType(MassType massType) {
        this.massType = massType;
        massTypeId = massType == null ? null : massType.getId();
    }

    /** To-one relationship, resolved on first access. */
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean getIsMaxWeight() {
        return this.isMaxWeight;
    }

    public void setIsMaxWeight(boolean isMaxWeight) {
        this.isMaxWeight = isMaxWeight;
    }

    public Long getWeight() {
        return this.weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Integer getNumberReps() {
        return this.numberReps;
    }

    public void setNumberReps(Integer numberReps) {
        this.numberReps = numberReps;
    }

    public Integer getNumberSets() {
        return this.numberSets;
    }

    public void setNumberSets(Integer numberSets) {
        this.numberSets = numberSets;
    }

    public Long getMassTypeId() {
        return this.massTypeId;
    }

    public void setMassTypeId(Long massTypeId) {
        this.massTypeId = massTypeId;
    }

    public Long getTraineeId() {
        return this.traineeId;
    }

    public void setTraineeId(Long traineeId) {
        this.traineeId = traineeId;
    }

    public Long getExerciseId() {
        return this.exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 851899508)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHistoryDao() : null;
    }

}
