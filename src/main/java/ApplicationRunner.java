import evictionStrategy.LRUEvictionPolicy;
import exception.CustomException;
import models.Cache;
import service.CacheService;
import service.CacheServiceImpl;

import java.util.HashMap;

public class ApplicationRunner {
    public static void main(String[] args) throws CustomException {
        Cache cache = new Cache(new HashMap<>(), 3, new LRUEvictionPolicy());
        CacheService cacheService = CacheServiceImpl.getInstance(cache);

        cacheService.addElement(1, "vivek");
        cacheService.addElement(2, "phone");
        System.out.println(cacheService.getElement(1));
        cacheService.addElement(3, "pen");
    }
}
