package models;

import evictionStrategy.EvictionPolicy;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class Cache {
    private HashMap<Integer, ValueField> storage;
    private int capacity;
    private EvictionPolicy evictionPolicy;
}
