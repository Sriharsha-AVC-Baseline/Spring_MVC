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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "Manager")
public class ManagerEntity implements Serializable{
	
	@Id
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "EMPLOYEE_ID",name="MANAGER_ID")
	private EmployeeEntity myEmployeeId;
	
	
	@Column(name = "leads_under_me")
	private int leadsUnderMe;
	
	@OneToMany(mappedBy = "myManager")
	private List<ExecutiveEntity> myExecutives;
	
	@OneToMany(mappedBy = "myManager")
	private List<LeadsEntity> myLeads;
	
	
	public EmployeeEntity getMyEmployeeId() {
		return myEmployeeId;
	}


	public void setMyEmployeeId(EmployeeEntity myEmployeeId) {
		this.myEmployeeId = myEmployeeId;
	}


	public int getLeadsUnderMe() {
		return leadsUnderMe;
	}


	public void setLeadsUnderMe(int leadsUnderMe) {
		this.leadsUnderMe = leadsUnderMe;
	}


	public List<ExecutiveEntity> getMyExecutives() {
		return myExecutives;
	}


	public void setMyExecutives(List<ExecutiveEntity> myExecutives) {
		this.myExecutives = myExecutives;
	}


	public List<LeadsEntity> getMyLeads() {
		return myLeads;
	}


	public void setMyLeads(List<LeadsEntity> myLeads) {
		this.myLeads = myLeads;
	}



	

}
