package com.fisherman.trainingdiary.entity;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(createInDb = false)
public class Day {

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

    public Day() {
        trainingPartList = new ArrayList<>();
    }

    @Generated(hash = 857409854)
    public Day(Long id, Long workoutId) {
        this.id = id;
        this.workoutId = workoutId;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1726364112)
    public List<TrainingPart> getTrainingPartList() {
        if (trainingPartList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TrainingPartDao targetDao = daoSession.getTrainingPartDao();
            List<TrainingPart> trainingPartListNew = targetDao._queryDay_TrainingPartList(id);
            synchronized (this) {
                if (trainingPartList == null) {
                    trainingPartList = trainingPartListNew;
                }
            }
        }
        return trainingPartList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1825195332)
    public synchronized void resetTrainingPartList() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day day = (Day) o;

        return id.equals(day.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1409317752)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDayDao() : null;
    }
}
