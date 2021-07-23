package com.stackroute.recommendation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.recommendation.model.Recommended;

@Repository
public interface RecommendedRepository extends MongoRepository<Recommended, Integer>{

}
