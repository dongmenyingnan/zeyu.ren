package com.zeyu.service;

import java.util.List;

import com.zeyu.entity.FeedBack;
import com.zeyu.entity.User;


public interface UserService {
	public boolean add(User user);
	public boolean feedBack(FeedBack feedBack);
	public boolean delete(String user_id);
	public boolean update(User user);
	public User judge(User user);
	public List<User> findAll();
	public List<User> findByKind(int user_kind);
	public List<User> findByUser(String user_name);
	public User findByTele(String user_tele);
	public User findByEmail(String user_email);
}
