package com.example.greeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.greeting.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	

}
