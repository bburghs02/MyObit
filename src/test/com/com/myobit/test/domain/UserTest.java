package com.myobit.test.domain;

import com.myobit.domain.User;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Phillip on 6/26/2016.
 */
public class UserTest extends TestCase {

    @Test
    public void testUserCreate() {
        User user = new User();
        user.setUsername("potato");
        user.setPassword("password");
        user.setEnabled(true);

        assertEquals("username is not potato","potato",user.getUsername());
        assertNotSame("password should not be password","password",user.getPassword());
        assertTrue("user is not enabled",user.isEnabled());
    }

}