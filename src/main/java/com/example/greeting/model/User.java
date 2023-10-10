package com.example.greeting.model;

import java.time.LocalDate;

import com.example.greeting.dto.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Msg")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String fName;
	private String lName;
	private LocalDate updateDate;
	
	/*public User(String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
	}*/
	
	public User(UserDTO userDTO) {
		
		this.fName = userDTO.fName;
		this.lName = userDTO.lName;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + "]";
	}
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	
	

}
