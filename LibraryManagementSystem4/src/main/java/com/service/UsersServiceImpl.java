package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.UserNotFoundException;
import com.entities.Users;
import com.repository.UsersRepository;
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired 
	UsersRepository userrepo;
	
	@Override
	public Users registerUserDetails(Users user) {
		userrepo.save(user);
		return user;
	}

	@Override
	public Users loginValidate(Users user) throws Throwable {
		Optional<Users> u1=userrepo.findById(user.getUserid());//.orElseThrow();
		if(!u1.isEmpty())
		{
			if(u1.get().getPassword().equals(user.getPassword()))
			{
				return user;
			}
			else
			{
				throw new UserNotFoundException("Wrong Password");
			}
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public List<Users> viewAllUsers() {
		List<Users> l1 = userrepo.findAll();		
		return l1;
	}

	@Override
	public Users updateUserDetails(Users user) {
		int userid = user.getUserid();
		Users u1 =userrepo.findById(userid).orElseThrow();
		u1.setPassword(user.getPassword());
		u1.setFirstName(user.getFirstName());
		u1.setLastName(user.getLastName());
		u1.setMobileno(user.getMobileno());
		u1.setEmail(user.getEmail());
		u1.setDateofbirth(user.getDateofbirth());
		u1.setSubscriptiondate(user.getSubscriptiondate());
		u1.setSubexpiredate(user.getSubexpiredate());
		u1.setSubscriptionstatus(user.getSubscriptionstatus());
		userrepo.save(u1);
		return u1;
	}

	@Override
	public Users deleteUserDetails(Users user) {
		userrepo.delete(user);
		return user;
	}

	@Override
	public Users getEmail(String email) {
		Users em =userrepo.findByEmail(email);
		return em;
	}

	@Override
	public Users getMobileno(String mobileno) {
		Users mb =userrepo.findByMobileno(mobileno);
		return mb;
	}

}