package com.example.greeting.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.greeting.Exception.UserCustomException;
import com.example.greeting.dto.UserDTO;
import com.example.greeting.model.User;
import com.example.greeting.repository.UserRepository;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	/*public User addUser(User user) {	
		return userRepository.save(user);
	}*/

	public User addUser(UserDTO user) {	
		User userData = new User(user);
		return userRepository.save(userData);
	}
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	/*public Optional<User> getByUserId(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}*/
	
	public User getByUserId(int id)
	{
		return userRepository.findById(id)
				.orElseThrow(() -> new UserCustomException("user with id:"+id+" not found"));
	}


	/*public User updateUser(int id, User user) {
		
		Optional<User> user_Data = getByUserId(id);
		if(user_Data.isPresent()) {
			user_Data.get().setfName(user.getfName());
			user_Data.get().setlName(user.getlName());
			return userRepository.save(user_Data.get());
			
		}
		return null;
	}*/
	public User updateUser(int id, UserDTO user) {
		
		User user_Data = getByUserId(id);
		if(user_Data !=null) {
			user_Data.setfName(user.fName);
			user_Data.setlName(user.lName);
			user_Data.setUpdateDate(LocalDate.now());
			return userRepository.save(user_Data);
			
		}
		return null;
	}



	public void DeleteUser(int id) {
		// TODO Auto-generated method stub
		User user_Data = getByUserId(id);
		if(user_Data != null) {
			//user_Data.get().setfName(user.getfName());
			//user_Data.get().setlName(user.getlName());
			userRepository.deleteById(id);
		}
		
	}

	

}
