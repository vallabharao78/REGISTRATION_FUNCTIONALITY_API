package com.vallabha.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vallabha.entity.User;

public interface UserRepo extends JpaRepository<User,Serializable>{

	User findByEmail(String email);

	User findByEmailAndPassword(String userName, String password);


}
