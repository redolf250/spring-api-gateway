package com.redolf.apikeygenerator.repository;

import com.redolf.apikeygenerator.model.ApiKeySpec;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiKeySpecRepository extends MongoRepository<ApiKeySpec,String> {
    List<ApiKeySpec> findApiKeySpecByUsername(String username);
}
