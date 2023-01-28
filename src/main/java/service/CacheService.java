package service;

import exception.CustomException;

public interface CacheService {
    void addElement(int key, String value);

    String getElement(int key) throws CustomException;

    void removeElement();
}
