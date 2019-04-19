package com.fisherman.trainingdiary.entity;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Keep
@Entity(createInDb = false)
public class Day implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id(autoincrement = true)
    private Long id;
    private Long workoutId;

    @ToMany(referencedJoinProperty = "dayId")
    private List<TrainingPart> trainingPartList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 312167767)
    private transient DayDao myDao;

    @Inject
    public Day() {
        trainingPartList = new ArrayList<>();
    }

    public Day(Long id, Long workoutId) {
        this.id = id;
        this.workoutId = workoutId;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    public List<TrainingPart> getTrainingPartList() {
        if (trainingPartList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TrainingPartDao targetDao = daoSession.getTrainingPartDao();
            trainingPartList = targetDao._queryDay_TrainingPartList(id);
        }
        return trainingPartList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public void resetTrainingPartList() {
        trainingPartList = null;
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

    public Long getWorkoutId() {
        return this.workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public void setTrainingPartList(List<TrainingPart> trainingPartList) {
        this.trainingPartList = trainingPartList;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1409317752)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDayDao() : null;
    }
}
