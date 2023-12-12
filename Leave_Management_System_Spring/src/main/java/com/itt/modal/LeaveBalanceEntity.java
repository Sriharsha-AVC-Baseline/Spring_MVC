package com.itt.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.itt.constant_values.Leaves;
import com.itt.logic.LeaveDistributor;

@Entity(name = "LeaveBalance")
public class LeaveBalanceEntity implements Serializable{
	
	
	public LeaveBalanceEntity() {
		this.casualLeave = Leaves.CASUAL_LEAVE;
		this.earnedLeave = Leaves.EARNED_LEAVE;
		this.dutyLeave = Leaves.DUTY_LEAVE;
		this.sickLeave = Leaves.SICK_LEAVE;
		this.leaveWithoutPay = Leaves.LEAVE_WITHOUT_PAY;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leaveId;
	
	@OneToOne
	@JoinColumn()
	private EmployeeEntity employeeId;
	
	@Column(name = "Casual_Leave")
	private int casualLeave;
	
	@Column(name = "Earned_Leave")
	private int earnedLeave;
	
	@Column(name = "Duty_Leave")
	private int dutyLeave;
	
	@Column(name = "Sick_Leave")
	private int sickLeave;
	
	@Column(name = "Maternity_Leave")
	private int maternityLeave;
	
	@Column(name = "Parental_Leave")
	private int parentalLeave;
	
	@Column(name = "Leave_Without_Pay")
	private int leaveWithoutPay;

	public int getCasualLeave() {
		return casualLeave;
	}

	public void setCasualLeave(int casualLeave) {
		this.casualLeave = casualLeave;
	}

	public int getEarnedLeave() {
		return earnedLeave;
	}

	public void setEarnedLeave(int earnedLeave) {
		this.earnedLeave = earnedLeave;
	}

	public int getDutyLeave() {
		return dutyLeave;
	}

	public void setDutyLeave(int dutyLeave) {
		this.dutyLeave = dutyLeave;
	}

	public int getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(int sickLeave) {
		this.sickLeave = sickLeave;
	}

	public int getMaternityLeave() {
		return maternityLeave;
	}

	public void setMaternityLeave(int maternityLeave) {
		this.maternityLeave = maternityLeave;
	}

	public int getParentalLeave() {
		return parentalLeave;
	}

	public void setParentalLeave(int parentalLeave) {
		this.parentalLeave = parentalLeave;
	}

	public int getLeaveWithoutPay() {
		return leaveWithoutPay;
	}

	public void setLeaveWithoutPay(int leaveWithoutPay) {
		this.leaveWithoutPay = leaveWithoutPay;
	}
	
	public EmployeeEntity getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeEntity employeeId) {
		this.employeeId = employeeId;
	}
}
