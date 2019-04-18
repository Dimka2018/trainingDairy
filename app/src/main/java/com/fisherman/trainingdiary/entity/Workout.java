package com.fisherman.trainingdiary.entity;

import com.fisherman.trainingdiary.activity.view.adapter.AdapterApplyable;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Entity(createInDb = false)
public class Workout implements AdapterApplyable, Serializable{

    private static final long serialVersionUID = 1L;

    @Id(autoincrement = true)
    private Long id;
    private String name;
    private Long profileId;
    private boolean isActive;

    @ToMany(referencedJoinProperty = "workoutId")
    private List<Day> dayList;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1950649078)
    private transient WorkoutDao myDao;


    @Inject
    public Workout() {
        this.dayList = new ArrayList<>();
    }


    @Generated(hash = 1558702181)
    public Workout(Long id, String name, Long profileId, boolean isActive) {
        this.id = id;
        this.name = name;
        this.profileId = profileId;
        this.isActive = isActive;
    }


    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public String getValue() {
        return name;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1805835665)
    public List<Day> getDayList() {
        if (dayList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DayDao targetDao = daoSession.getDayDao();
            List<Day> dayListNew = targetDao._queryWorkout_DayList(id);
            synchronized (this) {
                if (dayList == null) {
                    dayList = dayListNew;
                }
            }
        }
        return dayList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1010399236)
    public synchronized void resetDayList() {
        dayList = null;
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


    public Long getProfileId() {
        return this.profileId;
    }


    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }


    public boolean getIsActive() {
        return this.isActive;
    }


    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setDayList(List<Day> dayList) {
        this.dayList = dayList;
    }

    public void loadFull() {
        for (Day day : getDayList()) {
            for (TrainingPart part : day.getTrainingPartList()) {
                part.getExercise();
            }
        }
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1398188052)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWorkoutDao() : null;
    }
}
