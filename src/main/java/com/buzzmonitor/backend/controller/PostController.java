package com.buzzmonitor.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.buzzmonitor.backend.entity.EPost;
import com.buzzmonitor.backend.repository.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/posts/{n}")
	public List<EPost> getAllPosts(@PathVariable int n) {
		Pageable pg = new PageRequest(0, n, Sort.Direction.DESC, "createdTime");
		Page<EPost> page = postRepository.findAll(pg);
		return page.getContent();
	}
}
