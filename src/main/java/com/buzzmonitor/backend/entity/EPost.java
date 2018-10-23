package com.buzzmonitor.backend.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "post", type = "default")
public class EPost {

	@Id
	private String id;

	private EUser user;

	private String message;

	@Field(type = FieldType.Date)
	private Date createdTime;

	@Field(type = FieldType.Date)
	private Date updatedTime;

	@Field(type = FieldType.Nested, includeInParent = true)
	private List<EComment> comments;
	
	private int numberOfShares;

	public EPost() {
	}

	public EPost(String id, EUser user, String message, Date createdTime, Date updatedTime, int numberOfShares) {
		this.id = id;
		this.user = user;
		this.message = message;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.comments = new ArrayList<EComment>();
		this.numberOfShares = numberOfShares;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EUser getUser() {
		return user;
	}

	public void setUser(EUser user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public List<EComment> getComments() {
		return comments;
	}

	public void setComments(List<EComment> comments) {
		this.comments = comments;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	
	

}
