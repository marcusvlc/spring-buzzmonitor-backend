package com.buzzmonitor.backend.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.buzzmonitor.backend.entity.EComment;

@Repository
public interface CommentRepository extends ElasticsearchRepository<EComment, String> {

}
