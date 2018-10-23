package com.buzzmonitor.backend.controller;
//
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.buzzmonitor.backend.entity.EPost;
import com.buzzmonitor.backend.entity.EUser;
import com.buzzmonitor.backend.repository.UserRepository;
import com.buzzmonitor.backend.service.PostService;
//
@RestController
public class PopulateController {

	Facebook facebook = FacebookAuthController.facebook;
	@Autowired
	PostService postService;

	CommentOperations commentOp;

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/populate/{n}")
	public ResponseEntity<EUser> populate(@PathVariable int n) {
		
		
		String [] fields = { "id", "name", "updated_time", "gender", "email"};
		User userProfile = facebook.fetchObject("me", User.class, fields);
		
		EUser userAuth = new EUser(userProfile.getId(), 
								   userProfile.getName(), 
								   new Date(),
								   userProfile.getGender(),
								   userProfile.getEmail());
		
		PagingParameters paging = new PagingParameters(n, 0, null, null);
		
		List<Post> nPosts = facebook.feedOperations().getFeed(paging);
		
		commentOp = facebook.commentOperations();
		
		for(int i = 0; i < nPosts.size(); i++) {
						
			EPost post = postService.createPost(nPosts.get(i).getId(), 
												userAuth, nPosts.get(i).getMessage(), 
												nPosts.get(i).getCreatedTime(), 
												new Date(), 
												commentOp.getComments(nPosts.get(i).getId()),
												nPosts.get(i).getShares());
			postService.savePost(post);
		}
		
		userRepository.save(userAuth);
		
		return new ResponseEntity<EUser>(userAuth, HttpStatus.CREATED);
	}

}
