package com.springapp.notes.repository;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.springapp.notes.entities.Authority;
import com.springapp.notes.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class UserRepositoryTest {

    private static final String PASS = "dummy-pass";
    private static final String USERNAME = "testUser";

    private User user;

    @Autowired
    private UserRepository repo;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUserName(USERNAME);
        user.setPassword(PASS);
        user.setEnabled(true);
    }

    @Test
    public void testCreateAndGet() throws Exception {
        repo.save(user);
        final User found = repo.findOne(USERNAME);
        assertNotNull(found);
        assertEquals(PASS, found.getPassword());
    }

    /**
     * data dependent
     */
    @Test
    public void testGetRolesForAdmin() throws Exception {
        final User found = repo.findOne("admin");
        assertNotNull(found);
        assertTrue(found.getAuthorities().size() > 0);
        Assert.assertEquals("ROLE_ADMIN", found.getAuthorities().get(0).getAuthority());
    }

    @Test
    public void testUserWithAuth() throws Exception {

        user.getAuthorities().add(new Authority("dummy_role_01", user));
        user.getAuthorities().add(new Authority("dummy_role_02", user));

        repo.save(user);

        final User found = repo.findOne(USERNAME);
        assertTrue(found.getAuthorities().size() == 2);
    }
}