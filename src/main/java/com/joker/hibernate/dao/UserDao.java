package com.joker.hibernate.dao;

import java.util.List;

import com.joker.hibernate.model.M_User;

public interface UserDao {
	
	M_User findById(int id);
    
	M_User findBySSO(String sso);
     
    void save(M_User user);
     
    void deleteBySSO(String sso);
     
    List<M_User> findAllUsers();
    
}
