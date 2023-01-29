package evictionStrategy;

import models.ValueField;

import java.util.HashMap;

public interface EvictionPolicy {
    void removeElement(HashMap<Integer, ValueField> cacheStorage);
}
