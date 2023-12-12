package com.itt.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itt.modal.EmployeeEntity;

@Repository
@Transactional
public class ForgetPasswordDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public EmployeeEntity verifyUserInDao(String employeeID,String email,java.sql.Date dob)
	{
		String queryStatement = "SELECT e from Employee e where e.employeeId= :id "
				+ "and e.employeeDOB=:dob and e.employeeMail= :mail";
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<EmployeeEntity> query = session.createQuery(queryStatement);
		query.setParameter("id", employeeID);
		query.setParameter("dob", dob);
		query.setParameter("mail", email);
		EmployeeEntity employee = query.uniqueResult();
		return employee;
	}
	
	public void resetPasswordDao(EmployeeEntity validEmployee)
	{
		this.hibernateTemplate.update(validEmployee);
	}
	
}
