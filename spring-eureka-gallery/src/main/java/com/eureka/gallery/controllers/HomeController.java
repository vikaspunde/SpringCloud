package com.eureka.gallery.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.gallery.entities.Gallery;
import com.eureka.gallery.service.ImageServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/")
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ImageServiceProxy imageServiceProxy; 
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	}
  
	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping("/{id}")
	public Gallery getGallery(@PathVariable final int id) {
		LOGGER.info("Creating gallery object ... ");
		Gallery gallery = new Gallery();
		gallery.setId(id);
		List<Object> images = imageServiceProxy.getallimages();
		gallery.setImages(images);
		return gallery;
	}

	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}
	
	// a fallback method to be called if failure happened
	public Gallery fallback(int galleryId, Throwable hystrixCommand) {
		return new Gallery(galleryId);
	}
}