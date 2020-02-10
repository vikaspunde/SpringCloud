package com.eureka.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eureka.auth.model.AppUser;

@Repository
public interface AuthRepository extends MongoRepository<AppUser, Integer>{

}
