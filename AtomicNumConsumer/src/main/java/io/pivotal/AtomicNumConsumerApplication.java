package io.pivotal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class AtomicNumConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(AtomicNumConsumerApplication.class, args);
    }

    @Autowired
    AtomicNumClient client;

    @RequestMapping("/")
    public String getRemoteData(){
        Map<String, Long> remoteData=client.getCounter();
        return "<h1> I am consumer !</h1><br/>The counter is: <b>" + remoteData.get("counter") + "</b>"+
                "<br/>I get data from producer#: <b>" + remoteData.get("container_index");
    }

}
