package com.fisherman.trainingdiary.entity;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import lombok.Data;

@Data
@Entity(createInDb = false)
public class Trainee {

    @Id(autoincrement = true)
    private Long id;
    private Long profileId;

    @ToMany(referencedJoinProperty = "traineeId")
    private List<History> historyList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 283041767)
    private transient TraineeDao myDao;

    public Trainee() {
    }

    @Generated(hash = 983819358)
    public Trainee(Long id, Long profileId) {
        this.id = id;
        this.profileId = profileId;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1785213996)
    public List<History> getHistoryList() {
        if (historyList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HistoryDao targetDao = daoSession.getHistoryDao();
            List<History> historyListNew = targetDao._queryTrainee_HistoryList(id);
            synchronized (this) {
                if (historyList == null) {
                    historyList = historyListNew;
                }
            }
        }
        return historyList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 466944887)
    public synchronized void resetHistoryList() {
        historyList = null;
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

    public Long getProfileId() {
        return this.profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 114499540)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTraineeDao() : null;
    }

}
