package com.lucsuo.credit.p2p.test.entity;

import java.util.List;

public class CommunicationScore {

	private String submitTime;
	private String submitPerson;
	private List<QueryCommunicationInfo> queryList;
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getSubmitPerson() {
		return submitPerson;
	}
	public void setSubmitPerson(String submitPerson) {
		this.submitPerson = submitPerson;
	}
	public List<QueryCommunicationInfo> getQueryList() {
		return queryList;
	}
	public void setQueryList(List<QueryCommunicationInfo> queryList) {
		this.queryList = queryList;
	} 
	
	
}
	