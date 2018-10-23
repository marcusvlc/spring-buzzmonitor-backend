package com.buzzmonitor.backend.service;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Comment;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.stereotype.Service;

import com.buzzmonitor.backend.entity.EComment;
import com.buzzmonitor.backend.entity.EPost;
import com.buzzmonitor.backend.entity.EUser;
import com.buzzmonitor.backend.repository.CommentRepository;
import com.buzzmonitor.backend.repository.PostRepository;

@Service
public class PostService {
	

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	public void savePost(EPost p) {
		postRepository.save(p);
	}
	
	public EPost createPost(String id, EUser user, String message, Date createdTime, Date updatedTime, PagedList<Comment> comments, int sharesCount) {
		 EPost p = new EPost(id, user, message, createdTime, updatedTime, sharesCount);
		 
		 
		 if(comments != null) {
			 ArrayList<EComment> eComments = new ArrayList<EComment>();
			 
			 for(int i = 0; i < comments.size(); i++) {
				 EComment ec = new EComment(comments.get(i).getId(), 
											comments.get(i).getMessage(), 
											comments.get(i).getCreatedTime(), 
											user);
				 
				 commentRepository.save(ec);
				 
				 eComments.add(ec);
				 
			 }
			 
			 p.setComments(eComments);
		 }
		 
		 return p;
	}

}
