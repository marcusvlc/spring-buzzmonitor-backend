package com.buzzmonitor.backend.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * https://developers.facebook.com/docs/graph-api/reference/v3.1/post
 * https://docs.spring.io/spring-social-facebook/docs/2.0.3.RELEASE/apidocs/org/springframework/social/facebook/api/Post.html
 */
@Document(indexName = "post", type = "default")
public class EPost {

	@Id
	private String id;

	private User user;

	private String message;

	@Field(type = FieldType.Date)
	private Date createdTime;

	@Field(type = FieldType.Date)
	private Date updatedTime;

	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Comment> comments;

//    @Field(type = FieldType.Nested, includeInParent = true)
//    private List<Post> sharedPosts;

	public EPost() {
	}

	public EPost(String id, User user, String message, Date createdTime, Date updatedTime) {
		this.id = id;
		this.user = user;
		this.message = message;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
