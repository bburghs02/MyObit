package com.myobit.test.dao;

import com.myobit.dao.UserDaoImpl;
import com.myobit.domain.Authority;
import com.myobit.domain.Person;
import com.myobit.domain.User;
import com.myobit.util.UserUtils;
import junit.framework.TestCase;
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

/**
 * Created by Phillip on 6/26/2016.
 */
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class UserDaoTest extends TestCase {

    @Autowired
    private UserDaoImpl userDao;

    private long testId;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");
        user.setEnabled(true);

        Person testPerson = new Person();
        testPerson.setFirstName("tuber");
        testPerson.setLastName("tuber");

        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");

        user.addAuthority(authority);

        user.setPerson(testPerson);

        userDao.addNew(user);

        this.testId = user.getId();
    }

    @After
    public void tearDown() throws Exception {
        userDao.delete(userDao.getbyId(toIntExact(this.testId)));

    }

    @Test
    public void testCreate() {
        assertNotNull("test user is null",userDao.getbyId(toIntExact(this.testId)));
    }

    @Test
    public void testRemoveAuthority() {
        User testUser = userDao.getbyId(toIntExact(this.testId));
        testUser.addAuthority(new Authority("ROLE_ADMIN"));
        assertEquals("user doesn't have two authorities",2,testUser.getAuthorities().size());
        testUser.removeAuthority(UserUtils.ROLE_ADMIN);

    }
}