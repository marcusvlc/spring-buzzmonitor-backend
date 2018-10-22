package com.buzzmonitor.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.buzzmonitor.backend.entity.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

	Page<User> findAll();

}
