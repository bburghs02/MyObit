package com.myobit.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Phillip on 5/21/2016.
 */

@Entity
public class Address extends BaseEntity{
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;
    private List<Person> persons;

    @Enumerated(EnumType.STRING)
    private AddressType type;

    public Address() {
    }

    public Address(String line1, String line2, String city, String state, String zip) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Column
    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    @Column
    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    @Column
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="PersonAddress",
            joinColumns = @JoinColumn( name="AddressId"),
            inverseJoinColumns = @JoinColumn( name="PersonId")
    )
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

}
