package com.itt.modal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "Leads")
public class LeadsEntity implements Serializable{


	@Id
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "EMPLOYEE_ID",name="LEAD_ID")
	private EmployeeEntity myEmployeeId;
	
	@ManyToOne
	@JoinColumn(name="manager_id", referencedColumnName = "MANAGER_ID")
	private ManagerEntity myManager;
	
	@OneToMany(mappedBy = "myLead")
	private List<ExecutiveEntity> myExecutives;
	
	@Column(name="Executives_under_me")
	private int executivesUnderMe;

	public EmployeeEntity getMyEmployeeId() {
		return myEmployeeId;
	}

	public void setMyEmployeeId(EmployeeEntity myEmployeeId) {
		this.myEmployeeId = myEmployeeId;
	}



	public ManagerEntity getMyManager() {
		return myManager;
	}

	public void setMyManager(ManagerEntity myManager) {
		this.myManager = myManager;
	}

	public List<ExecutiveEntity> getMyExecutives() {
		return myExecutives;
	}

	public void setMyExecutives(List<ExecutiveEntity> myExecutives) {
		this.myExecutives = myExecutives;
	}

	public int getExecutivesUnderMe() {
		return executivesUnderMe;
	}

	public void setExecutivesUnderMe(int executivesUnderMe) {
		this.executivesUnderMe = executivesUnderMe;
	}
}
