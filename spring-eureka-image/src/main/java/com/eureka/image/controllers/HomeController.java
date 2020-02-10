package com.eureka.image.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.image.entities.Image;
import com.eureka.image.repository.CourseRepository;

@RestController
@RequestMapping("/images")
public class HomeController {
	@Autowired
	private CourseRepository courseRepository;
		
	@GetMapping("/getall")
	public List<Image> getImages() {
		return courseRepository.findAll();
	}
	
	@PostMapping("/add")
	public Image addImage(@RequestBody Image image) {
		return courseRepository.save(image);
	}
}
