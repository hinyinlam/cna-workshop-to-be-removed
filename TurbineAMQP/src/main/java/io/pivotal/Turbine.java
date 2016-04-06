package io.pivotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.amqp.EnableTurbineAmqp;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineAmqp
public class Turbine {

    public static void main(String[] args) {

        SpringApplication.run(Turbine.class, args);
    }


}
