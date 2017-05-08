package com.zeyu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zeyu.dao.FeedBackDao;
import com.zeyu.dao.UserDao;
import com.zeyu.entity.FeedBack;
import com.zeyu.entity.User;
import com.zeyu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;
	@Resource
	FeedBackDao feedBackDao;

	@Override
	public boolean add(User user) {
		userDao.add(user);
		return true;
	}

	@Override
	public boolean delete(String user_id) {

		try {
			userDao.deleteByIds("data.user_id=" + user_id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		userDao.update(user);
		return true;
	}

	@Override
	public User judge(User user) {

		try {
			User orienUser = userDao.findByProperty("user_name='" + user.getUser_name() + "'").get(0);

			if (user.getUser_name().equals(orienUser.getUser_name())
					&& user.getUser_pass().equals(orienUser.getUser_pass())) {
				return orienUser;
			}
		} catch (Exception e) {

		}
		return null;

	}

	@Override
	public List<User> findAll() {
		List<User> list = userDao.findAll();
		return list;
	}

	@Override
	public boolean feedBack(FeedBack feedBack) {
		feedBackDao.add(feedBack);
		return true;
	}

	@Override
	public List<User> findByKind(int user_kind) {
		return userDao.findByProperty("user_kind='" + user_kind + "'");
	}

	@Override
	public User findByTele(String user_tele) {
		List<User> users = userDao.findByProperty("user_tele='" + user_tele + "'");
		if (users != null) {
			if (users.size() >= 1)
				return users.get(0);
		}
		return null;
	}

	@Override
	public List<User> findByUser(String user_name) {
		// TODO Auto-generated method stub
		return userDao.findByProperty("user_name='" + user_name + "'");
	}

	@Override
	public User findByEmail(String user_email) {
		List<User> users = userDao.findByProperty("user_email='" + user_email + "'");
		if (users != null) {
			if (users.size() >= 1)
				return users.get(0);
		}
		return null;
	}

	@Override
	public User admincheck(String name, String password) {
		String a = "0";
		return userDao.findByProperty("user_kind="+a+"and user_name="+name+"and user_pass="+password).get(0);
	}

	@Override
	public User findByUserToken(String user_token) {
		
		return userDao.findByProperty("user_token='"+user_token+"'").get(0);
	}

}
