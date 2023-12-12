package com.itt.modal;

import java.io.Serializable;
import java.text.ParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.itt.util.DateHelper;

@Entity(name = "LeaveRecords")
public class LeaveRecordsEntity implements Serializable{
	
	@Id
	@Column(name="leave_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leaveID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "EMPLOYEE_ID",name = "employee_id")
	private EmployeeEntity employeeId;
	
	@Column(name="leave_comment")
	private String leaveComment;
	
	@Column(name="leave_Type")
	private String leaveType;
	
	@Column(name="leave_Status")
	private String leaveStatus; 
	
	@Column(name="number_of_days")
	private int numberOfDays;
	
	@Column(name="from_date")
	private java.sql.Date fromDate;
	
	@Column(name="to_date")
	private java.sql.Date toDate;

	public int getLeaveID() {
		return leaveID;
	}

	public void setLeaveID(int leaveID) {
		this.leaveID = leaveID;
	}

	public EmployeeEntity getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeEntity employeeId) {
		this.employeeId = employeeId;
	}

	public String getLeaveComment() {
		return leaveComment;
	}

	public void setLeaveComment(String leaveComment) {
		this.leaveComment = leaveComment;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public java.sql.Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) throws ParseException {
		this.fromDate =  new java.sql.Date(DateHelper.readDate(fromDate).getTime());
	}

	public java.sql.Date getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) throws ParseException {
		this.toDate = new java.sql.Date(DateHelper.readDate(toDate).getTime());
	}

}