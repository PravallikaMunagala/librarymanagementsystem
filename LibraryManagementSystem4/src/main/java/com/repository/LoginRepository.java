package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer>
{
	//@Query(value="Select login from Login login where login.name=:name")
	Login findByUserName(String userName);
}