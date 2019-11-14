package com.zaloni.flipkart.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.zaloni.shoppingkart.dao.IUserDAO;
import com.zaloni.shoppingkart.entities.User;
import com.zaloni.shoppingkart.service.AuthenticationServiceImpl;
import com.zaloni.shoppingkart.service.IAuthenticationService;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationServiceImplTest {
	
	@Mock
	private IUserDAO userDAO;
	
	
	@InjectMocks IAuthenticationService sut=new AuthenticationServiceImpl();
	
	@Before
	public void initializeMockito() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testValidateRequestForLogin() {
		
		User user=new User();
		Mockito.when(sut.validateRequestForLogin(Mockito.eq("admin111"), Mockito.eq("pass"))).thenReturn(null);
	}

}
