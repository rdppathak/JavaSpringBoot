package com.Company.MindEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class MindEntity {
    private long id;
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
}