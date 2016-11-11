package com.joker.hibernate.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joker.hibernate.dao.UserDao;
import com.joker.hibernate.model.M_User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public M_User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public M_User findBySSO(String sso) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveUser(M_User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(M_User user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	public List<M_User> findAllUsers() {
		return userDao.findAllUsers();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
