package com.buzzmonitor.backend.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * https://developers.facebook.com/docs/graph-api/reference/user/
 * https://docs.spring.io/spring-social-facebook/docs/2.0.3.RELEASE/apidocs/org/springframework/social/facebook/api/User.html
 */
@Document(indexName = "user", type = "default")
public class EUser {

	@Id
	private String id;

	private String name;

	@Field(type = FieldType.Date)
	private Date updatedTime;
	
	private String gender;
	
	private String email;

	public EUser() {
	}

	public EUser(String id, String name, Date updatedTime, String gender, String email) {
		this.id = id;
		this.name = name;
		this.updatedTime = updatedTime;
		this.email = email;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
