package com.myobit.test.dao;

import com.myobit.dao.AddressDao;
import com.myobit.dao.AddressDaoImpl;
import com.myobit.domain.Address;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static java.lang.Math.toIntExact;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Phillip on 6/19/2016.
 */
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class AddressDaoTest {

    @Autowired
    private AddressDaoImpl addressDao;

    private long testId;

    @Before
    public void createTestAddress() {
        Address address = new Address("12345 Not Real Avenue","","New York","NY","55555");
        addressDao.addNew(address);
        this.testId = address.getId();
    }

    @After
    public void removeTestAddress() {
        addressDao.delete(addressDao.getbyId(toIntExact(this.testId)));
    }

    @Test
    public void testCreateAddress() {
        Address retrievedAddress = addressDao.getbyId(toIntExact(this.testId));
        assertEquals("Address line 1 is not 12345 Not Real Avenue","12345 Not Real Avenue",retrievedAddress.getLine1());
    }
}
