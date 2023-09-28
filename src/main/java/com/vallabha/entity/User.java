package com.vallabha.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="User")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long phoneNumber;
	private LocalDate dob;
	private Character gender;
	private String country;
	private String state;
	
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public User(Integer userId, String firstName, String lastName, String email, String password, Long phoneNumber,
			LocalDate dob, Character gender, String country, String state, LocalDate createdDate,
			LocalDate updatedDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.gender = gender;
		this.country = country;
		this.state = state;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", gender=" + gender
				+ ", country=" + country + ", state=" + state + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", getUserId()=" + getUserId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getDob()=" + getDob() + ", getGender()=" + getGender()
				+ ", getCountry()=" + getCountry() + ", getState()=" + getState() + ", getCreatedDate()="
				+ getCreatedDate() + ", getUpdatedDate()=" + getUpdatedDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
