package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.UserAddress;
import com.repository.UserAddressRepository;
@SpringBootTest
class UserAddressServiceImplTest {
	@Autowired
	UserAddressService useraddservice;
	@MockBean
	UserAddressRepository useraddressrepo;
	@Test
	void testAddUserAddress() {
		UserAddress ua = new UserAddress();
		ua.setAddressId(1);
		ua.setAddress("Marripalem");
		ua.setUsers(null);
		ua.setCity("Visakhapatnam");
		ua.setState("Andhra");
		ua.setPincode(530018);
		Mockito.when(useraddressrepo.save(ua)).thenReturn(ua);
		assertThat(useraddservice.addUserAddress(ua)).isEqualTo(ua);
	}

	@Test
	void testUpdateUserAddressDetails() {
		UserAddress ua = new UserAddress();
		ua.setAddressId(1);
		ua.setAddress("Marripalem");
		ua.setUsers(null);
		ua.setCity("Visakhapatnam");
		ua.setState("Andhra");
		ua.setPincode(530018);
		
		Optional<UserAddress> b2 =  Optional.of(ua);
		Mockito.when(useraddressrepo.findById(1)).thenReturn(b2);
		Mockito.when(useraddressrepo.save(ua)).thenReturn(ua);
		ua.setAddress("Marri");
		ua.setUsers(null);
		ua.setCity("Visakh");
		ua.setState("Andh");
		ua.setPincode(530018);
		assertThat(useraddservice.updateUserAddressDetails(ua)).isEqualTo(ua);
	}

	@Test
	void testDeleteUserAddress() {
		UserAddress ua = new UserAddress();
		ua.setAddressId(1);
		ua.setAddress("Marripalem");
		ua.setUsers(null);
		ua.setCity("Visakhapatnam");
		ua.setState("Andhra");
		ua.setPincode(530018);
		Optional<UserAddress> b2=Optional.of(ua);
		Mockito.when(useraddressrepo.findById(1)).thenReturn(b2);
		Mockito.when(useraddressrepo.existsById(ua.getAddressId())).thenReturn(false);
		assertFalse(useraddressrepo.existsById(ua.getAddressId()));
	}

	@Test
	void testViewAddressByUserId() {
		UserAddress ua = new UserAddress();
		ua.setAddressId(1);
		ua.setAddress("Marripalem");
		ua.setUsers(null);
		ua.setCity("Visakhapatnam");
		ua.setState("Andhra");
		ua.setPincode(530018);
		Optional<UserAddress> c2 = Optional.of(ua);
		Mockito.when(useraddressrepo.findById(1)).thenReturn(c2);
		assertThat(useraddservice.viewAddressByUserId(1)).isEqualTo(ua);
	}

	@Test
	void testViewUserAddressList() {
		UserAddress ua = new UserAddress();
		ua.setAddressId(1);
		ua.setAddress("Marripalem");
		ua.setUsers(null);
		ua.setCity("Visakhaptnam");
		ua.setState("Andhra");
		ua.setPincode(522509);
		
		UserAddress ua1 = new UserAddress();
		ua1.setAddressId(1);
		ua1.setAddress("Marripa");
		ua1.setUsers(null);
		ua1.setCity("Visakha");
		ua1.setState("Andhr");
		ua1.setPincode(530018);
		
		List<UserAddress> addressList = new ArrayList<UserAddress>();
		addressList.add(ua);
		addressList.add(ua1);
		
		Mockito.when(useraddressrepo.findAll()).thenReturn(addressList);
		assertThat(useraddservice.viewUserAddressList()).isEqualTo(addressList);
	}

	
	  @Test
	  void testGetPinCode() 
	  {  
		  UserAddress ua = new UserAddress();
			ua.setAddressId(1);
			ua.setAddress("Marripalem");
			ua.setUsers(null);
			ua.setCity("Visakhapatnam");
			ua.setState("Andhra");
			ua.setPincode(530018);
			Mockito.when(useraddressrepo.findByPincode("530018")).thenReturn(ua);
			assertThat(useraddservice.getPinCode("530018")).isEqualTo(ua);
	  }
	  
	  @Test void testGetState() 
	  { 
		  UserAddress ua = new UserAddress();
			ua.setAddressId(1);
			ua.setAddress("Marripalem");
			ua.setUsers(null);
			ua.setCity("Visakhapatnam");
			ua.setState("Andhra");
			ua.setPincode(522509);
			List<UserAddress> addressList = new ArrayList<UserAddress>();
			addressList.add(ua);
			Mockito.when(useraddressrepo.findByState("Andhra")).thenReturn(addressList);
			//assertThat(useraddservice.getState("Andhra")).isEqualTo(addressList);
	  }
	 

}