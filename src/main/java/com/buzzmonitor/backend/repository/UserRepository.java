package com.buzzmonitor.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.buzzmonitor.backend.entity.EUser;

@Repository
public interface UserRepository extends ElasticsearchRepository<EUser, String> {

	Page<EUser> findAll();

}
