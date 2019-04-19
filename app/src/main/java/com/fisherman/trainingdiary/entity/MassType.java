package com.fisherman.trainingdiary.entity;

import com.fisherman.trainingdiary.activity.view.adapter.AdapterApplyable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

import javax.inject.Inject;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Entity(createInDb = false)
public class MassType implements Serializable, AdapterApplyable {

    private static final long serialVersionUID = 1L;

    @Id(autoincrement = true)
    private Long id;
    private String name;

    @Inject
    public MassType() {
    }

    @Generated(hash = 1072073826)
    public MassType(Long id, String name) {
        this.id = id;
        this.name = name;
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
    public boolean isActive() {
        return false;
    }

    @Override
    public String getValue() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
