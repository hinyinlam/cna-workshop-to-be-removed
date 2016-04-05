package io.pivotal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hinlam on 5/4/2016.
 *
 */

public class AtomicNumClientFallback implements AtomicNumClient{

    @Override
    public Map<String, Long> getCounter() {
        Map<String, Long> fallbackResult = new HashMap<String, Long>();
        fallbackResult.put("counter", -1l);
        fallbackResult.put("container_index", -1l);
        return fallbackResult;
    }
}
