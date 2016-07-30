package com.myobit.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by Phillip on 7/29/2016.
 */
@Entity
public class Obituary extends BaseEntity {

    private String content;
    private Date dateAdded;
    @Enumerated(EnumType.STRING)
    private ObitStatus status;
    private Person person;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ObitStatus getStatus() {
        return status;
    }

    public void setStatus(ObitStatus status) {
        this.status = status;
    }

    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
