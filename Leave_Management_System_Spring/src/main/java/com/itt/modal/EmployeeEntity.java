package com.itt.modal;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.itt.util.DateHelper;

@Entity(name = "Employee")
public class EmployeeEntity implements Serializable {
	
	

	// Primary key
	
	@Id
	@Column(name = "EMPLOYEE_ID")
	private String employeeId;
	
	// General Details
	
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	
	@Transient
	private String employeeSurName;
	
	@Column(name = "EMPLOYEE_PASS")
	private String employeePass;
	
	
	/*
	 * @Transient private String houseNumber;
	 * 
	 * @Transient private String streetName;
	 * 
	 * @Transient private String district;
	 * 
	 * @Transient private String state;
	 * 
	 * @Transient private String pinCode;
	 */

	@Column(name = "EMPLOYEE_MAIL")
	private String employeeMail;
	
	@Column(name = "EMPLOYEE_GENDER")
	private String employeeGender;
	
	@Column(name="EMPLOYEE_PHONE")
	private String employeePhone;
	
	@Transient
	private String countryCode;
	
	@Column(name = "EMPLOYEE_DESIGNATION")
	private String employeeDesignation;
	
	@Column(name = "EMPLOYEE_DOB")
	private java.sql.Date employeeDOB;
	
	
	// Foreign keys
	
	@OneToOne(mappedBy = "employeeId",fetch = FetchType.EAGER)
	private LeaveBalanceEntity leaveBalanceEntity;
	
	@OneToOne(mappedBy = "myEmployeeId")
	private ManagerEntity manager;
	
	@OneToOne(mappedBy = "myEmployeeId")
	private LeadsEntity lead;
	
	@OneToOne(mappedBy = "myEmployeeId")
	private ExecutiveEntity executive;
	
	@OneToMany(mappedBy = "employeeId",fetch = FetchType.EAGER)
	private List<LeaveRecordsEntity> leaveRecordsEntity;
	
	

	public LeaveBalanceEntity getLeaveBalanceEntity() {
		return leaveBalanceEntity;
	}

	public void setLeaveBalanceEntity(LeaveBalanceEntity leaveBalanceEntity) {
		this.leaveBalanceEntity = leaveBalanceEntity;
	}

	public List<LeaveRecordsEntity> getLeaveRecordsEntity() {
		return leaveRecordsEntity;
	}

	public void setLeaveRecordsEntity(List<LeaveRecordsEntity> leaveRecordsEntity) {
		this.leaveRecordsEntity = leaveRecordsEntity;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	
	  public void setEmployeeId(String employeeId) { 
		  this.employeeId = employeeId; 
		  }
	 

	public String getEmployeePass() {
		return employeePass;
	}

	public void setEmployeePass(String employeePass) {
		this.employeePass = employeePass;
	}



	public String getEmployeeMail() {
		return employeeMail;
	}

	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = this.countryCode+ employeePhone;
	}
	

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public java.sql.Date getEmployeeDOB() {
		return employeeDOB;
	}

	public void setEmployeeDOB(String employeeDOB) throws ParseException {
		this.employeeDOB = new java.sql.Date(DateHelper.readDate(employeeDOB).getTime());
	}
	
	public String getEmployeeSurName() {
		return employeeSurName;
	}

	public void setEmployeeSurName(String employeeSurName) {
		this.employeeSurName = employeeSurName;
	}

	

}
