package com.itt.test.insert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import com.itt.dao.LoginDao;
import com.itt.modal.EmployeeEntity;
import com.itt.service.LoginService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class Login {
	
	@Mock
	LoginDao loginDao;
	
	@Test
	public void testLogin()
	{
		LoginService loginService = new LoginService();
		
		
		loginService.loginDao = loginDao;
		
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmployeeName("AVC");
		entity.setEmployeePass("AVCBaseline");
		
		Mockito.when(loginDao.getDesignation("AVC", "AVCBaseline")).thenReturn(entity);
		
		assertNotNull(loginService.designationPage("AVC", "AVCBaseline"));
	}
	
	@Test
	public void testExceptionHandling()
	{
LoginService loginService = new LoginService();
		
		LoginDao loginDao = mock(LoginDao.class);
		
		loginService.loginDao = loginDao;
		
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmployeeName("AVC");
		entity.setEmployeePass("AVCBaseline");
		
		Mockito.when(loginDao.getDesignation("AVC", "AVCBaseline")).thenReturn(entity);
		
		assertNotNull(loginService.designationPage("AVC", "AVCBaseline"));
	}

}
