package com.zeyu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zeyu.dao.UserDao;
import com.zeyu.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	public UserDaoImpl(){
		super(User.class);
	}
}
