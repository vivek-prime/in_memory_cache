package evictionStrategy;

import models.ValueField;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy implements EvictionPolicy {
    @Override
    public void removeElement(HashMap<Integer, ValueField> cacheStorage) {
        Object deletedKey = null;
        Object value = null;
        Timestamp earliest = null;
        for (Map.Entry<Integer, ValueField> entry : cacheStorage.entrySet()) {
            if (earliest == null || entry.getValue().getCurrentTimestamp().before(earliest)) {
                deletedKey = entry.getKey();
                value = entry.getValue().getValue();
                earliest = entry.getValue().getCurrentTimestamp();
            }
        }
        System.out.println("deletedKey - " + deletedKey + " , value - " + value);
    }
}
