package com.service;

import java.util.List;
import java.util.function.IntPredicate;

import com.entities.Login;

public interface LoginService {
	public Login addLoginDetails(Login login);
	public Login updateLoginDetails(Login login) throws Throwable;
	public String deleteLoginDetails(Login login);
	public List<Login> viewloginList();
	public Login viewusersbyid(int loginid) throws Throwable;
	//public Login getByusername(String username);
	public Login findByUserName(String userName);
	
}