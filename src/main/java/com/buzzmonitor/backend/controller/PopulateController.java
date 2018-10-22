package com.buzzmonitor.backend.controller;
//
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.buzzmonitor.backend.entity.EPost;
import com.buzzmonitor.backend.entity.User;
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
	public ResponseEntity<User> populate(@PathVariable int n) {
		
		User user = new User("blabla", 
							 "blabla", 
							 new Date());
		
		
		PagingParameters paging = new PagingParameters(n, 0, null, null);
		
		List<Post> nPosts = facebook.feedOperations().getFeed(paging);
		
		for(int i = 0; i < nPosts.size(); i++) {
			
			EPost post = postService.createPost(nPosts.get(i).getId(), 
												user, nPosts.get(i).getMessage(), 
												nPosts.get(i).getCreatedTime(), 
												new Date(), 
												null); // COLOCAR OS COMMENTS DE CADA POST
			System.out.println(post.getMessage());
			postService.savePost(post);
		}
		
		userRepository.save(user);
		
		return null;
	}

}
