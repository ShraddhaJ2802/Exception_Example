package com.example.greeting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.greeting.dto.UserDTO;
import com.example.greeting.model.User;
import com.example.greeting.service.UserService;

import jakarta.validation.Valid;

@RestController

public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*@PostMapping("/add")
	 public User addUser(@RequestBody User user)
	 {
		User userData = userService.addUser(user);
		return userData;
	 }*/
	
	@PostMapping("/add")
	 public User addUser(@Valid @RequestBody UserDTO user)
	 {
		User userData = userService.addUser(user);
		return userData;
	 }
	
	@GetMapping("/getalll")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable int id)
	{
		return userService.getByUserId(id);
	}
	
	/*@PutMapping("/update/{id}")
	public User updateUser(@PathVariable int id , @RequestBody User user )
	{
		return userService.updateUser(id,user);
	}*/
	
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable int id , @RequestBody UserDTO user )
	{
		return userService.updateUser(id,user);
	}
	@DeleteMapping("/delete/{id}")
	public void DeleteUser(@PathVariable int id  )
	{
		 userService.DeleteUser(id);
	}
	
}
