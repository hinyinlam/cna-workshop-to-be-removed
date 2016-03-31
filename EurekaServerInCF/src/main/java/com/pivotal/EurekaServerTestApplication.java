package com.pivotal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.app.ApplicationInstanceInfo;
*/

@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
@RestController
public class EurekaServerTestApplication {

	public static void main(String[] args) {

		SpringApplication.run(EurekaServerTestApplication.class, args);
	}

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/")
	public String sayHello(){
		StringBuilder sb = new StringBuilder();
		List<String> services = discoveryClient.getServices();
		for(String service: services){
			List<ServiceInstance> instances = discoveryClient.getInstances(service);
			for(ServiceInstance instance:instances){
				sb.append("Host: " + instance.getHost() + " Port: " + instance.getPort() + " Service ID: " + instance.getServiceId() + " Uri: " + instance.getUri());
				for(String metaKey: instance.getMetadata().keySet()){
					sb.append("Meta data["+metaKey+"]:" + instance.getMetadata().get(metaKey));
				}
			}
		}
		return sb.toString();
	}
}


