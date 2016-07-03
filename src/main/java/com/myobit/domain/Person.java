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
}