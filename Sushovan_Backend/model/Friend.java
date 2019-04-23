package com.coll.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Friend 
{
	@Id
	
	String freindId;
	String username;
	String friendName;
	String status;
	public String getFreindId() {
		return freindId;
	}
	public void setFreindId(String freindId) {
		this.freindId = freindId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
