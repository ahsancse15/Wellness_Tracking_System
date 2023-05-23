package com.example.FirstDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class register {
	
	@Id
	@SequenceGenerator(
			name = "patient",
			sequenceName = "patient_sequence",
			allocationSize = 1
			)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
            )
	
	private long id;
	private String name;
	private int age;
	private String gender;
	private String number;
	private String email;
	private String password;
	

	public register() {
	}
	
	public register(
			long id,
			String name,
			int age,
			String gender,
			String number,
			String email,
			String password) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.number = number;
		this.email = email;
		this.password = password;
	}
	
	public register(
			String name,
			int age,
			String gender,
			String number,
			String email,
			String password) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.number = number;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		
		return "patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", number='" + number + '\'' +
                "email=" + email + '\'' +
                ", password='" + password +
                '}';
	}
	
}
