package com.myobit.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Phillip on 7/3/2016.
 */
@Entity
public class Relationship extends BaseEntity {

    private Person primary;
    private Person secondary;
    private String relationshipType;
    private boolean executor;

    @ManyToOne
    @JoinColumn(name = "PrimaryId")
    @Cascade(CascadeType.ALL)
    public Person getPrimary() {
        return primary;
    }

    public void setPrimary(Person primary) {
        this.primary = primary;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    @ManyToOne
    @JoinColumn(name = "SecondaryId")
    @Cascade(CascadeType.ALL)
    public Person getSecondary() {
        return secondary;
    }

    public void setSecondary(Person secondary) {
        this.secondary = secondary;
    }

    public boolean isExecutor() {
        return executor;
    }

    public void setExecutor(boolean executor) {
        this.executor = executor;
    }
}
