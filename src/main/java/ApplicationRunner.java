import evictionStrategy.FifoEvictionPolicy;
import exception.CustomException;
import models.Cache;
import service.CacheService;
import service.CacheServiceImpl;

import java.util.HashMap;

public class ApplicationRunner {
    public static void main(String[] args) throws CustomException {
//        Cache cache = new Cache(new HashMap<>(), 3, new LRUEvictionPolicy());
        Cache cache = new Cache(new HashMap<>(), 3, new FifoEvictionPolicy());
        CacheService cacheService = CacheServiceImpl.getInstance(cache);

        cacheService.addElement(1, "vivek");
        cacheService.addElement(2, "phone");
        System.out.println("Value for key : " + cacheService.getElement(1));
        cacheService.addElement(3, "pen");
    }
}
