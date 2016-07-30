package com.myobit.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Phillip on 5/21/2016.
 */
@Entity
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
    private Calendar dateOfBirth;
    private Calendar dateOfDeath;
    private List<Address> addresses;
    private User user;
    private List<Relationship> primaryRelationships;
    private List<Relationship> secondaryRelationships;
    private List<Obituary> obituaries;

    public Person() {
    }

    public Person(String firstName, String lastName, Calendar dateOfDeath, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfDeath = dateOfDeath;
        if (this.addresses == null) {
            this.addresses = new ArrayList<Address>();
        }
        this.addresses.add(address);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDateOfDeath(Calendar dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Calendar getDateOfDeath() {
        return dateOfDeath;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH,CascadeType.SAVE_UPDATE})
    @JoinTable(
            name="PersonAddress",
            joinColumns = @JoinColumn( name="PersonId"),
            inverseJoinColumns = @JoinColumn( name="AddressId")
    )
    public List<Address> getAddresses() {
        return addresses;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @OneToOne(mappedBy = "person",orphanRemoval = true  , fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if (user != null) {
            user.setPerson(this);
        }
        this.user = user;
    }

    @OneToMany(mappedBy = "primary",fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    public List<Relationship> getPrimaryRelationships() {
        if (primaryRelationships == null) {
            primaryRelationships = new ArrayList<Relationship>();
        }
        return primaryRelationships;
    }

    public void setPrimaryRelationships(List<Relationship> primaryRelationships) {
        this.primaryRelationships = primaryRelationships;
    }

    @OneToMany(mappedBy = "secondary", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    public List<Relationship> getSecondaryRelationships() {
        return secondaryRelationships;
    }

    public void setSecondaryRelationships(List<Relationship> secondaryRelationships) {
        this.secondaryRelationships = secondaryRelationships;
    }

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    public List<Obituary> getObituaries() {
        if (obituaries == null) {
            obituaries = new ArrayList<Obituary>();
        }
        return obituaries;
    }

    public void setObituaries(List<Obituary> obituaries) {
        this.obituaries = obituaries;
    }
}
