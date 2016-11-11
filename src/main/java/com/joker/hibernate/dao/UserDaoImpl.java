package com.joker.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joker.hibernate.model.M_User;

@Transactional
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, M_User> implements UserDao {

	public M_User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public M_User findBySSO(String sso) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(M_User user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	 @SuppressWarnings("unchecked")
	 public List<M_User> findAllUsers() {
	    	
	        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
	        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
	        List<M_User> users = (List<M_User>) criteria.list();
	         
	        return users;
	 }

}
