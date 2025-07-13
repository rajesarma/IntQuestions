package com.lakshmi.ds.lfu;

import java.util.Map;

public class LfuCache {

    private Map<Integer, Data> map;
    private int capacity;

    public LfuCache(Map<Integer, Data> map, int capacity) {
        this.map = map;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            incrementFrequency(key);
        } else {
            put(key);
        }
        return map.get(key).value;
    }

    private void put(int key) {
        if (map.size() == capacity) {
            int lfuKey = findLfu();
            map.remove(lfuKey);
        }
        Data data = new Data(key, 1);
        map.put(key, data);
    }

    private int findLfu() {
        int lfuKey = 0;
        int minFrequency = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Data> e : map.entrySet()) {
            if (e.getValue().frequency < minFrequency) {
                minFrequency = e.getValue().frequency;
                lfuKey = e.getKey();
            }
        }
        return lfuKey;
    }

    private void incrementFrequency(int key) {
        if (map.containsKey(key)) {
            map.get(key).frequency += 1;
        }
    }


    static class Data {
        int value;
        int frequency;

        public Data(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }
}
