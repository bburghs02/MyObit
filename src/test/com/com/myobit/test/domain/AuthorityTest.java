package com.myobit.test.domain;

import com.myobit.domain.Authority;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Created by Phillip on 7/1/2016.
 */
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class AuthorityTest extends TestCase {

    @Test
    public void testCreate(){
        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        assertEquals("somehow the user has the wrong role","ROLE_USER",authority.getAuthority());
    }

}