import evictionStrategy.EvictionPolicy;
import evictionStrategy.EvictionPolicyFactory;
import evictionStrategy.EvictionPolicyType;
import exception.CustomException;
import models.Cache;
import service.CacheService;
import service.CacheServiceImpl;

import java.util.HashMap;

public class ApplicationRunner {
    public static void main(String[] args) throws CustomException {
        EvictionPolicy fifo = EvictionPolicyFactory.getEvictionPolicy(EvictionPolicyType.FIFO);
        EvictionPolicy lru = EvictionPolicyFactory.getEvictionPolicy(EvictionPolicyType.LRU);

        Cache cache = new Cache(new HashMap<>(), 3, fifo);
        CacheService cacheService = CacheServiceImpl.getInstance(cache);

        cacheService.addElement(1, "vivek");
        cacheService.addElement(2, "phone");
        System.out.println("Value for key : " + cacheService.getElement(1));
        cacheService.addElement(3, "pen");
    }
}
