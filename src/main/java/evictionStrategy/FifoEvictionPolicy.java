package evictionStrategy;

import models.ValueField;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class FifoEvictionPolicy implements EvictionPolicy {
    @Override
    public void removeElement(HashMap<Integer, ValueField> cacheStorage) {
        Object deletedKey = null;
        Object value = null;
        Timestamp earliest = null;
        for (Map.Entry<Integer, ValueField> entry : cacheStorage.entrySet()) {
            if (earliest == null || entry.getValue().getEntryTimestamp().before(earliest)) {
                deletedKey = entry.getKey();
                value = entry.getValue().getValue();
                earliest = entry.getValue().getEntryTimestamp();
            }
        }
        System.out.println("deletedKey - " + deletedKey + " , value - " + value);
    }
}
