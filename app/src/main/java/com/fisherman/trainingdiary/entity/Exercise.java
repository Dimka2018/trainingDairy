package com.fisherman.trainingdiary.entity;

import com.fisherman.trainingdiary.activity.view.adapter.AdapterApplyable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

import javax.inject.Inject;

@Entity(createInDb = false)
public class Exercise implements AdapterApplyable, Serializable {

    private static final long serialVersionUID = 1L;

    @Id(autoincrement = true)
    private Long id;
    private String name;

    @Inject
    public Exercise() {
    }

    @Generated(hash = 1333421746)
    public Exercise(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public String getValue() {
        return name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercise exercise = (Exercise) o;

        return id.equals(exercise.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
