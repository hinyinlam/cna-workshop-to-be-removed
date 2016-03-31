package io.pivotal;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hinlam on 31/3/16.
 */
@FeignClient(name = "CNA-ATOMIC-NUM-PRODUCER", fallback = AtomicNumClientFallback.class)
public interface AtomicNumClient {

    @RequestMapping(method = RequestMethod.GET, value = "/counter", produces = "application/json")
    Map<String, Long> getCounter();

}

class AtomicNumClientFallback implements AtomicNumClient{

    @Override
    public Map<String, Long> getCounter() {
        Map<String, Long> fallbackResult = new HashMap<String, Long>();
        fallbackResult.put("counter", -1l);
        fallbackResult.put("counter_index", -1l);
        return fallbackResult;
    }
}
