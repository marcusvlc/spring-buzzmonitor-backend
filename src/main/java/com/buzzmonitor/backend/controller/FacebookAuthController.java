package com.buzzmonitor.backend.controller;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacebookAuthController  {

    public static Facebook facebook;
    private ConnectionRepository connectionRepository;

    public FacebookAuthController(Facebook facebook, ConnectionRepository connectionRepository) {
        FacebookAuthController.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }
    
 
    @GetMapping("/")
    public String getFacebookFeed(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        
        model.addAttribute("feed", feed);
        return "hello";
        
    }
    

}
