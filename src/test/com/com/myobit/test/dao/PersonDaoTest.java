package com.myobit.test.dao;

import com.myobit.dao.PersonDaoImpl;
import com.myobit.domain.Address;
import com.myobit.domain.AddressType;
import com.myobit.domain.Person;
import com.myobit.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.Calendar;

import static java.lang.Math.toIntExact;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Phillip on 5/22/2016.
 */
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class PersonDaoTest {

    @Autowired
    private PersonDaoImpl personDao;

    private long testId;

    @Before
    public void createTestPerson() {
        Person testPerson = new Person();
        testPerson.setFirstName("John");
        testPerson.setLastName("Doe");

        Calendar dob = Calendar.getInstance();
        dob.set(1950, Calendar.JANUARY, 01,8,00);
        testPerson.setDateOfBirth(dob);

        Calendar dod = Calendar.getInstance();
        dod.set(2000,Calendar.FEBRUARY,28,8,00);
        testPerson.setDateOfDeath(dod);

        Address address = new Address("1234 Fake Street","Apartment 1","Atlanta","GA","30316");
        address.setType(AddressType.VACATION.getType());

        ArrayList<Address> addresses = new ArrayList<Address>();
        addresses.add(address);
        testPerson.setAddresses(addresses);

        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setEnabled(true);

        testPerson.setUser(user);

        personDao.addNew(testPerson);

        this.testId = testPerson.getId();
    }

    @After
    public void deleteTestPerson() {
        Person toDelete = personDao.getByFirstNameLastName("John","Doe");
        personDao.deleteAllAddresses(toDelete);
        personDao.delete(toDelete);
        int i = 0;
    }

    @Test
    public void testPersonDaoCreate() {
        Person retrievedPerson = personDao.getByFirstNameLastName("John", "Doe");
        assertEquals("First Name is not John", "John", retrievedPerson.getFirstName());
        assertEquals("Address line 1 is not 1234 Fake Street","1234 Fake Street",retrievedPerson.getAddresses().get(0).getLine1());
        assertEquals("Address is not a vacation address",AddressType.VACATION.getType(),retrievedPerson.getAddresses().get(0).getType());
        assertEquals("DoB is not 1950",1950,retrievedPerson.getDateOfBirth().get(Calendar.YEAR));
    }

    @Test
    public void testPersonFindByFirstNameLastName() {
        Person retrievedPerson = personDao.getByFirstNameLastName("John", "Doe");
        assertEquals("First Name is not John","John",retrievedPerson.getFirstName());
        assertEquals("Last Name is not Doe","Doe",retrievedPerson.getLastName());
    }

    @Test
    public void testPersonWithMultipleAddresses() {
        Person retrievedPerson = personDao.getByFirstNameLastName("John","Doe");
        Address secondAddress = new Address("555 blah","apartment blah","Skokie","IL","12345");
        secondAddress.setType(AddressType.HOME.getType());
        retrievedPerson.getAddresses().add(secondAddress);
        personDao.update(retrievedPerson);
        retrievedPerson = personDao.getByFirstNameLastName("John","Doe");
        assertEquals("Person does not have 2 addresses",retrievedPerson.getAddresses().size(),2);
    }

    @Test
    public void testCountAll() {
        assertEquals("There's more than two people",2,personDao.getAll().size());
    }

    @Test
    public void testMultiplePeopleSameAddress() {
        Calendar dod = Calendar.getInstance();
        dod.set(2020,Calendar.JANUARY,01);
        Person johnDoe = personDao.getByFirstNameLastName("John","Doe");
        Person janeDoe = new Person();
        janeDoe.setFirstName("Jane");
        janeDoe.setLastName("Doe");
        personDao.addNew(janeDoe);
        johnDoe.getAddresses().get(0).getPersons().add(janeDoe);
        personDao.update(johnDoe);
        personDao.refresh(janeDoe);
        assertEquals("John and Jane have addresses with different IDs", johnDoe.getAddresses().get(0).getId(), janeDoe.getAddresses().get(0).getId());
        personDao.deleteAllAddresses(janeDoe);
        personDao.deleteByFirstNameLastName("Jane","Doe");
    }

    @Test
    public void testAddPersonWithUser(){
        Person testPerson = personDao.getbyId(toIntExact(this.testId));
        assertEquals("test person's username is not test","test",testPerson.getUser().getUsername());
    }
}