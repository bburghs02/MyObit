package com.myobit.domain;

import javax.persistence.Entity;

/**
 * Created by Phillip on 7/3/2016.
 */
@Entity
public class Relationship extends BaseEntity {

    private Person primary;
    private Person secondary;
    private RelationshipType relationshipType;
    private boolean executor;

    public Person getPrimary() {
        return primary;
    }

    public void setPrimary(Person primary) {
        this.primary = primary;
    }

    public Person getSeconday() {
        return secondary;
    }

    public void setSeconday(Person seconday) {
        this.secondary = seconday;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

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
