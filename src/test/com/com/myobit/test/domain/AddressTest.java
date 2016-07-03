package com.myobit.test.domain;


import com.myobit.domain.Address;
import com.myobit.util.LocationUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Phillip on 5/21/2016.
 */
public class AddressTest {

    @Test
    public void testAddressCreate() {
        Address address = new Address();
        assertTrue("address is null",address != null);
    }

    @Test
    public void testAddressLine1() {
        Address address = new Address();
        address.setLine1("1234 Fake Street");
        assertEquals("address line 1's are not equal","1234 Fake Street",address.getLine1());
    }

    @Test
    public void testAddressLine2() {
        Address address = new Address();
        address.setLine2("Apt 444");
        assertEquals("address line 2's are not equal","Apt 444",address.getLine2());
    }

    @Test
    public void testAddressCity() {
        Address address = new Address();
        address.setCity("Atlanta");
        assertEquals("address city's are not equal","Atlanta",address.getCity());
    }

    @Test
    public void testAddressState() {
        Address address = new Address();
        address.setState(LocationUtils.States.Georgia.getUspsCode());
        assertEquals("State code is not the same","GA",address.getState());
    }

    @Test
    public void testAddressZip() {
        Address address = new Address();
        address.setZip("30316");
        assertEquals("Zip Code is not the same","30316",address.getZip());
    }
}
