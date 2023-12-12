package com.itt.date_testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mockito.Mockito;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itt.dao.UtilityDao;

public class DateTest {
	
	
	public void testWeekendDateDifference() throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = dateFormat.parse("08/12/2023");
		Date date2 = dateFormat.parse("12/12/2023");
		
		UtilityDao utilityDao = new UtilityDao();
		
		HibernateTemplate hibrernateTemplate = Mockito.mock(HibernateTemplate.class);
		
		utilityDao.hibernateTemplate = hibrernateTemplate;
		
		java.sql.Date from = new java.sql.Date(date1.getTime());
		java.sql.Date to = new java.sql.Date(date2.getTime());
		
		assertEquals(3, utilityDao.getDateDiffernce(from, to));
		
		
	}

}
