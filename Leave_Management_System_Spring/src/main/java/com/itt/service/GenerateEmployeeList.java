package com.itt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itt.dao.FetchEmployeeListDao;
import com.itt.modal.EmployeeEntity;

@Service
public class GenerateEmployeeList {
	
	@Autowired
	FetchEmployeeListDao fetchEmployeeListDao;
	
	public List<EmployeeEntity> getExecEmployeeEntities()
	{
		return fetchEmployeeListDao.fetchExecutiveEntities();
	}
	public List<EmployeeEntity> getLeadsEmployeeEntities()
	{
		return fetchEmployeeListDao.fetchLeadsEntities();
	}
	public List<EmployeeEntity> getManagerEmployeeEntities()
	{
		return fetchEmployeeListDao.fetchManagerEntities();
	}


}
