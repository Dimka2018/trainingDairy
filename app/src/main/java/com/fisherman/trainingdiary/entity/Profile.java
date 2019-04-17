package com.fisherman.trainingdiary.entity;

import com.fisherman.trainingdiary.activity.view.adapter.AdapterApplyable;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import lombok.Data;

@Data
@Entity(createInDb = false)
public class Profile implements AdapterApplyable, Serializable {

    private static final long serialVersionUID = 1L;

    @Id(autoincrement = true)
    private Long id;

    private String name;
    private boolean isActive;
    private Long currentDayId;

    @ToMany(referencedJoinProperty = "profileId")
    private List<Workout> workoutList;

    @ToOne(joinProperty = "currentDayId")
    private Day currentDay;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 89320040)
    private transient ProfileDao myDao;

    @Inject
    public Profile() {
    }

    @Generated(hash = 1768649358)
    public Profile(Long id, String name, boolean isActive, Long currentDayId) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.currentDayId = currentDayId;
    }

    @Generated(hash = 665367881)
    private transient Long currentDay__resolvedKey;


    @Override
    public boolean isActive(){
        return isActive;
    }

    @Override
    public String getValue() {
        return name;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1269261075)
    public Day getCurrentDay() {
        Long __key = this.currentDayId;
        if (currentDay__resolvedKey == null || !currentDay__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DayDao targetDao = daoSession.getDayDao();
            Day currentDayNew = targetDao.load(__key);
            synchronized (this) {
                currentDay = currentDayNew;
                currentDay__resolvedKey = __key;
            }
        }
        return currentDay;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1684847422)
    public void setCurrentDay(Day currentDay) {
        synchronized (this) {
            this.currentDay = currentDay;
            currentDayId = currentDay == null ? null : currentDay.getId();
            currentDay__resolvedKey = currentDayId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 730217023)
    public List<Workout> getWorkoutList() {
        if (workoutList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WorkoutDao targetDao = daoSession.getWorkoutDao();
            List<Workout> workoutListNew = targetDao._queryProfile_WorkoutList(id);
            synchronized (this) {
                if (workoutList == null) {
                    workoutList = workoutListNew;
                }
            }
        }
        return workoutList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1620683702)
    public synchronized void resetWorkoutList() {
        workoutList = null;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Long getCurrentDayId() {
        return this.currentDayId;
    }

    public void setCurrentDayId(Long currentDayId) {
        this.currentDayId = currentDayId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1351849779)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getProfileDao() : null;
    }
}
