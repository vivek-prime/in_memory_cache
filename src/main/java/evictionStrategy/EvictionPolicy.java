package evictionStrategy;

import models.Value;

import java.util.HashMap;

public interface EvictionPolicy {
    void removeElement(HashMap<Integer, Value> cacheStorage);
}
