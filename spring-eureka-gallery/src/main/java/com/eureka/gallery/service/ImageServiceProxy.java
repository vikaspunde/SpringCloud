package com.eureka.gallery.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("spring-eureka-zuul")
@RibbonClient("image-service")
public interface ImageServiceProxy {
	
	@GetMapping("/image-service/images/getall")
	public List<Object> getallimages();
}
