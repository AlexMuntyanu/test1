package com.springapp.notes.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
    user.setUsername(USERNAME);
    user.setPassword(PASS);
    user.setEnabled(1);
  }

  @Test
  public void testCreateAndGet() throws Exception {
    repo.save(user);
    final User found = repo.findOne(USERNAME);
    assertNotNull(found);
    assertEquals(PASS, found.getPassword());
  }
}
