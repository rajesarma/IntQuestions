package ds.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class lru {
    static Deque<Integer> q = new LinkedList<>();
    static Map<Integer, LruCache> map = new HashMap<>();
    int LruCache_CAPACITY = 4;

    public String get(int key) {
        if (map.containsKey(key)) {
            LruCache current = map.get(key);
            q.remove(current.key);
            q.addFirst(current.key);
            return current.value;
        }
        return "Not exist";
    }

    public void put(int key, String value) {
        if (map.containsKey(key)) {
            LruCache current = map.get(key);
            q.remove(current.key);
        } else {
            if (q.size() == LruCache_CAPACITY) {
                int temp = q.removeLast();
                map.remove(temp);
            }
        }
        LruCache newItem = new LruCache(key, value);
        q.addFirst(newItem.key);
        map.put(key, newItem);
    }

    public static void main(String[] args) {
        lru LruCache = new lru();
        LruCache.put(1, "Value_1");
        LruCache.put(2, "Value_2");
        LruCache.put(3, "Value_3");
        LruCache.put(4, "Value_4");
        System.out.println(LruCache.get(2));
        System.out.println(q);
        System.out.println(LruCache.get(4));
        System.out.println(q);
        System.out.println(LruCache.get(5));
        LruCache.put(5, "Value_5");
        System.out.println(q);
        System.out.println();
    }
}