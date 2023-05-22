package com.jsp.springbootcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springbootcrud.dao.UserDao;
import com.jsp.springbootcrud.dto.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public User saveUser(User user) {
		return userDao.saveUser(user);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	public boolean deletUserById(int id) {
		return userDao.deletUserById(id);
	}

	public User updateUserById(int id, User user) {
		User u = userDao.getUserById(id);
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		if (u != null) {

			return userDao.updateUserById(id, u);
		} 
		else {
			return null;
		}
	}

}
