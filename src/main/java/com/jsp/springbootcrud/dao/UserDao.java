package com.jsp.springbootcrud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springbootcrud.dto.User;
import com.jsp.springbootcrud.repository.UserRepositotry;

@Repository
public class UserDao {
	@Autowired
	UserRepositotry userRepositotry;

	public User saveUser(User user) {
		return userRepositotry.save(user);

	}
	
	public User getUserById(int id) {
		Optional<User>user =userRepositotry.findById(id);
		if(user != null) {
			return user.get();
		}
		else {
			return null;
		}
	}
	
	public List<User> getAllUser(){
		return userRepositotry.findAll();
	}


	public boolean deletUserById(int id) {
		Optional<User>user =userRepositotry.findById(id);
		if (user != null) {
			userRepositotry.delete(user.get());
			return true;
		}
		else {
			return false;
		}

	}
	public User updateUserById(int id,User user) {
		Optional<User>opt =userRepositotry.findById(id);
		if(opt.isPresent()) {
			return userRepositotry.save(user);
		}
		else {
			return null;
		}

		
	}

}
