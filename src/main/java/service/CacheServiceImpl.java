package service;

import exception.CustomException;
import lombok.Data;
import models.Cache;
import models.Value;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;

@Data
public class CacheServiceImpl implements CacheService {
    private Cache cache;
    private static CacheServiceImpl cacheService = null;

    private CacheServiceImpl(Cache cache) {
        this.cache = cache;
    }

    public static CacheServiceImpl getInstance(Cache cache) {
        if (cacheService == null)
            cacheService = new CacheServiceImpl(cache);
        return cacheService;
    }

    @Override
    public void addElement(int key, String value) {
        HashMap<Integer, Value> cacheStorage = cache.getStorage();
        if (cacheStorage.containsKey(key)) {
            Value valueField = cacheStorage.get(key);
            valueField.setValue(value);
            valueField.setTimestamp(Timestamp.from(Instant.now()));
        } else
            cacheStorage.put(key, new Value(value, Timestamp.from(Instant.now())));
        if (cacheStorage.size() == cache.getCapacity())
            removeElement();
    }

    @Override
    public String getElement(int key) throws CustomException {
        if (!cache.getStorage().containsKey(key))
            throw new CustomException("Given Key not present : " + key);
        cache.getStorage().get(key).setTimestamp(Timestamp.from(Instant.now()));
        return cache.getStorage().get(key).getValue();
    }

    @Override
    public void removeElement() {
        cache.getEvictionPolicy().removeElement(cache.getStorage());
    }
}
