package com.itt.database;

public class HqlQueries {
	
	public static final String FETCH_LEAVE_RECORDS = "select lr from LeaveRecords lr where lr.leaveID= :id";

	public static final String FETCH_LEAVE_BALANCE = "select lb from LeaveBalance lb where lb.employeeId= :id";

	public static final String RELOAD_EMPLOYEE = "select e from Employee e where e.employeeId= :id";
	
	public static final String FETCH_PENDING_RECORDS = "select lr from LeaveRecords lr where lr.employeeId= :id and leaveStatus= :type";

	public static final String FETCH_APPROVRED_RECORDS = "select lr from LeaveRecords lr where lr.employeeId= :id and leaveStatus= :type";

	public static final String FETCH_REVOKED_RECORDS = "select lr from LeaveRecords lr where lr.employeeId= :id and leaveStatus= :type";
	
	public static final String FETCH_EXECUTIVES_FROM_MANAGER = "select mg.myExecutives from Manager mg where mg.myEmployeeId = :id";

	public static final String FETCH_EXECUTIVES_FROM_LEADS = "select lds.myExecutives from Leads lds where lds.myEmployeeId = :id";
	
	public static final String FETCH_LEADS_FROM_MANAGER = "select mg.myLeads from Manager mg where mg.myEmployeeId = :id";

	public static final String FETCH_EMPLOYEE_DETAILS = "select lr.employeeId from LeaveRecords lr where lr.leaveID= :id";
}
