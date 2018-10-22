package com.grokonez.facebookdata.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Comment;
import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookObject;
import org.springframework.social.facebook.api.MessageTag;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacebookFetchFeeds  {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;
    private CommentOperations commentOp;

    public FacebookFetchFeeds(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping("/")
    public String getFacebookFeed(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        
        String id = feed.get(1).getId();
        Post p = feed.get(0);
        
        System.out.println(p.getCreatedTime());
		commentOp = facebook.commentOperations();
		PagedList<Comment> comments = commentOp.getComments(id);
		
		System.out.println(comments.size());
		for(int i = 0; i < comments.size(); i++) {
			System.out.println(comments.get(i).getMessage());
		}
        
        model.addAttribute("feed", feed);
        return "hello";
        
    }

}
