package com.joker.hibernate.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.joker.hibernate.PersistenceConfig;
import com.joker.hibernate.model.M_User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	
	@Test
	public void whenFetchAllUser(){
		userDao.findAllUsers();
		
	}
	
	@Test
	public void whenAddingNewUser(){
		M_User user = new M_User();
		
		user.setUserId(2);
		user.setFirstName("Ayn Sophia");
		user.setLastName("Vivar");
		user.setPassword("Passw0rd");
		user.setUserName("avivar");
		user.setRegDate("20161111");
		
		userDao.save(user);
	}
	

}
