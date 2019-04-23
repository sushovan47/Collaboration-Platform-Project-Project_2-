package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="forumIdSeq",sequenceName="forumId_seq")
public class Forum
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forumIdSeq")
	
	private int ForumId;
	private String ForumName;
	private String ForumContent;
	private String username;
	private Date createDate;
	private String status;
	public int getForumId() {
		return ForumId;
	}
	public void setForumId(int forumId) {
		ForumId = forumId;
	}
	public String getForunName() {
		return ForumName;
	}
	public void setForumName(String forumName) {
		ForumName = forumName;
	}
	public String getForumContent() {
		return ForumContent;
	}
	public void setForumContent(String forumContent) {
		ForumContent = forumContent;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
