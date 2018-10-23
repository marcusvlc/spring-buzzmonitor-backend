package com.buzzmonitor.backend.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * https://docs.spring.io/spring-social-facebook/docs/2.0.3.RELEASE/apidocs/org/springframework/social/facebook/api/Comment.html
 */

@Document(indexName="comment", type="comment")
public class EComment {

	@Id
	private String id;
	private String message;

	@Field(type = FieldType.Date)
	private Date createdTime;

	private EUser user;

	public EComment() {
	}

	public EComment(String id, String message, Date createdTime, EUser user) {
		this.id = id;
		this.message = message;
		this.createdTime = createdTime;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public EUser getUser() {
		return user;
	}

	public void setUser(EUser user) {
		this.user = user;
	}

}
