package com.itt.modal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "Executive")
public class ExecutiveEntity implements Serializable {
	
	
	@Id
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EXECUTIVE_ID", referencedColumnName = "EMPLOYEE_ID")
	private EmployeeEntity myEmployeeId;
	
	
	@ManyToOne
	@JoinColumn(name="myLeads",referencedColumnName = "LEAD_ID")
	private LeadsEntity myLead;
	
	@ManyToOne
	@JoinColumn(name="myManagers",referencedColumnName = "MANAGER_ID")
	private ManagerEntity myManager;

	public EmployeeEntity getMyEmployeeId() {
		return myEmployeeId;
	}

	public void setMyEmployeeId(EmployeeEntity myEmployeeId) {
		this.myEmployeeId = myEmployeeId;
	}

	public LeadsEntity getMyLead() {
		return myLead;
	}

	public void setMyLead(LeadsEntity myLead) {
		this.myLead = myLead;
	}

	public ManagerEntity getMyManager() {
		return myManager;
	}

	public void setMyManager(ManagerEntity myManager) {
		this.myManager = myManager;
	}

}
