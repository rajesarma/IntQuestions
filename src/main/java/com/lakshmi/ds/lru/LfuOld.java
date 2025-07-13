package com.lakshmi.ds.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LfuOld {
    private int initialCapacity = 10;

    private LinkedHashMap<Integer, Cache> cacheMap = new LinkedHashMap<>();
    public LfuOld(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public void addCacheEntry(int key, String data) {
        if (!isFull()) {
            Cache temp = new Cache();
            temp.setData(data);
            temp.setFrequency(0);
            cacheMap.put(key, temp);
        } else {
            int entryKeyToBeRemoved = getLFUKey();
            cacheMap.remove(entryKeyToBeRemoved);
            Cache temp = new Cache();
            temp.setData(data);
            temp.setFrequency(0);
            cacheMap.put(key, temp);
        }
    }

    public int getLFUKey() {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Cache> entry : cacheMap.entrySet()) {
            if (minFreq > entry.getValue().frequency) {
                key = entry.getKey();
                minFreq = entry.getValue().frequency;
            }
        }
        return key;
    }

    public String getCacheEntry(int key) {
        if (cacheMap.containsKey(key))  // cache hit
        {
            Cache temp = cacheMap.get(key);
            temp.frequency++;
            cacheMap.put(key, temp);
            return temp.data;
        }
        return null; // cache miss
    }

    public boolean isFull() {
        if (cacheMap.size() == initialCapacity) {
            return true;
        }
        return false;
    }

    class Cache {
        private String data;
        private int frequency;
        private Cache() {
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }
}