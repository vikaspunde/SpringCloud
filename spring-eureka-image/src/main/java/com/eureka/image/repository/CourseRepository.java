package com.eureka.image.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eureka.image.entities.Image;

@Repository
public interface CourseRepository extends JpaRepository<Image, Integer>{

}
