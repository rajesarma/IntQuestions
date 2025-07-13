package com.lakshmi.ds.lru;

import java.util.HashMap;
import java.util.Map;

public class lfu {

    int cacheSize;
    Map<Integer, LfuCache> map;

    public lfu(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
    }

    // Method to check the value in the cache
    public void get(int value) {
        if (!map.containsKey(value)) {
            put(value);
        } else {
            incrementFrequency(value);
        }
    }

    public void incrementFrequency(int value) {
        if (map.containsKey(value)) {
            map.get(value).frequency += 1;
        }
    }

    // Function to Insert a new node in the heap
    public void put(int value) {
//        System.out.println("New cache value " + value);
        if (map.size() == cacheSize) {
            // remove least frequently used
            int lfuKey = findLfu();
            System.out.println("Cache value " + lfuKey + " removed.");
            map.remove(lfuKey);
        }

        LfuCache newCache = new LfuCache(value, 1);
        map.put(value, newCache);
        System.out.println("New Cache value " + value + " inserted.");
    }

    // Function to find the LFU block
    public int findLfu() {
        int lfuKey = 0;
        int minFrequency = Integer.MAX_VALUE;
        for (Map.Entry<Integer, LfuCache> entry : map.entrySet()) {
            if (entry.getValue().frequency < minFrequency) {
                minFrequency = entry.getValue().frequency;
                lfuKey = entry.getKey();
            }
        }
        return lfuKey;
    }

    public static void main(String[] args) {
        lfu lfuCache = new lfu(4);
        lfuCache.get(1);
        lfuCache.get(2);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(2);
        lfuCache.get(4);
        lfuCache.get(5);
    }
}