package com.joker.hibernate.service;

import java.util.List;

import com.joker.hibernate.model.M_User;

public interface UserService {
	
    M_User findById(int id);
    
    M_User findBySSO(String sso);
     
    void saveUser(M_User user);
     
    void updateUser(M_User user);
     
    void deleteUserBySSO(String sso);
 
    List<M_User> findAllUsers(); 
     
    boolean isUserSSOUnique(Integer id, String sso);
}
