package com.hintest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@EnableWebMvc
@RestController
@EnableEurekaClient
public class AtomicNumProducerApplication {

	public static void main(String[] args) {

		SpringApplication.run(AtomicNumProducerApplication.class, args);
	}

	@Value("${vcap.application.instance_index}")
	String containerIndex;

	AtomicLong counter=new AtomicLong(0l);

	@RequestMapping(value = "/counter", produces = "application/json")
	public String addAndGetCounterValue(){
		counter.addAndGet(1l);
		return "{\"counter\":" + counter.get() + ", \"container_index\":"+ containerIndex + "}";
	}


}

