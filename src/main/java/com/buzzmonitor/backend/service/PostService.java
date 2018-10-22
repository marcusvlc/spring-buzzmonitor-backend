package com.buzzmonitor.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buzzmonitor.backend.entity.Comment;
import com.buzzmonitor.backend.entity.EPost;
import com.buzzmonitor.backend.entity.User;
import com.buzzmonitor.backend.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public void savePost(EPost p) {
		postRepository.save(p);
	}
	
	public EPost createPost(String id, User user, String message, Date createdTime, Date updatedTime, List<Comment> comments) {
		 EPost p = new EPost(id, user, message, createdTime, updatedTime);
		 p.setComments(comments);
		 return p;
	}

}
