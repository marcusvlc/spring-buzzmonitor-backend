package com.buzzmonitor.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.buzzmonitor.backend.entity.EPost;

@Repository
public interface PostRepository extends ElasticsearchRepository<EPost, String> {

	List<EPost> findAll();

	Page<EPost> findAll(Pageable pageable);

}
