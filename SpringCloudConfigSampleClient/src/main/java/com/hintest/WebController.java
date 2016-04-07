package com.hintest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hinlam on 13/3/16.
 */
@RestController
@RefreshScope
public class WebController {

    @Value("${eureka.client.service-url.defaultZone}")
    String eurekaUrl;

    @Value("${vcap.application.instance_index}")
    String index;

    @RequestMapping("/")
    public String sayHello(){

        return "My index: " + index + "<br/>Eureka URL is: " + eurekaUrl + "<br/>";
    }
}
