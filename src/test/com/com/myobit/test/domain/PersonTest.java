package com.myobit.test.domain;

import com.myobit.domain.Address;
import com.myobit.domain.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Phillip on 5/21/2016.
 */
public class PersonTest {


    @Test
    public void testPersonCreate() {
        Person person = new Person();
        assertTrue(person != null);
    }

    @Test
    public void testPersonFirstName() {
        Person person = new Person();
        person.setFirstName("John");
        assertEquals("First Names are not equal","John",person.getFirstName());
    }

    @Test
    public void testPersonLastName() {
        Person person = new Person();
        person.setLastName("Doe");
        assertEquals("Last Names are not equal","Doe",person.getLastName());
    }

    @Test
    public void testPersonAddress() {
        Person person = new Person();
        ArrayList<Address> addresses = new ArrayList<Address>();
        Address address = new Address();
        address.setLine1("1234 Fake Street");
        addresses.add(address);
        person.setAddresses(addresses);
        person.getAddresses().get(0).setLine1("1234 Fake Street");
        assertEquals("Address line 1 is not equal","1234 Fake Street",person.getAddresses().get(0).getLine1());
    }

    @Test
    public void testPersonConstructor(){
        Address address = new Address("555 Blah Road","Apartment 123","Atlanta","GA","30316");
        Calendar dod = Calendar.getInstance();
        dod.set(1950,Calendar.JANUARY,01);
        Person person = new Person("Test","Person",dod,address);
        assertEquals("First name is not Test","Test",person.getFirstName());
    }
}
