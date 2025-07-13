package com.lakshmi.interviews.oracle;

import java.util.*;

public class LruCache {
    //    { 1, 2, 3, 4, 1, 2, 5, 1, 2, 3 }
//    capacity = 3
    static class LruCacheBlock {
        int key;
        int value;

        public LruCacheBlock(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Deque<Integer> queue = new LinkedList<>();
    Map<Integer, LruCacheBlock> map = new HashMap<>();

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LruCacheBlock lruCacheBlock = map.get(key);
            queue.remove(lruCacheBlock.key);
            queue.addFirst(lruCacheBlock.key);
            return lruCacheBlock.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LruCacheBlock lruCacheBlock = map.get(key);
            queue.remove(lruCacheBlock.key);
        } else {
            if (map.size() == capacity) {
                int temp = queue.removeLast();
                map.remove(temp);
            }
        }
        LruCacheBlock lruCacheBlock = new LruCacheBlock(key, value);
        queue.addFirst(key);
        map.put(key, lruCacheBlock);
    }

    public void display() {
        Set<Map.Entry<Integer, LruCacheBlock>> entries = map.entrySet();
        for(Map.Entry<Integer, LruCacheBlock> e: entries) {
            System.out.println("Key : "+ e.getKey() + ", Value : " + e.getValue().value);
        }
        System.out.println("------------");
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);
        lruCache.put(1, 1);
        lruCache.display();
        lruCache.put(2, 2);
        lruCache.display();
        lruCache.put(3, 3);
        lruCache.display();
        lruCache.put(4, 4);
        lruCache.display();
        lruCache.put(2, 2);
        lruCache.display();
        lruCache.put(2, 2);
        lruCache.display();

    }
}
