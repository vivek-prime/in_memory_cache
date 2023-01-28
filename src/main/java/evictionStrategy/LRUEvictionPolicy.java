package evictionStrategy;

import models.Value;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy implements EvictionPolicy {
    @Override
    public void removeElement(HashMap<Integer, Value> cacheStorage) {
        Object deletedKey = null;
        Timestamp earliest = null;
        for (Map.Entry<Integer, Value> entry : cacheStorage.entrySet()) {
            if (earliest == null || entry.getValue().getTimestamp().before(earliest)) {
                deletedKey = entry.getKey();
                earliest = entry.getValue().getTimestamp();
            }
        }
        System.out.println("deletedKey - " + deletedKey);
    }
}
