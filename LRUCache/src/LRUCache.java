import java.util.HashMap;

public class LRUCache {

    HashMap<Integer, Integer> cache;


    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {

        if(!cache.containsKey(key)) return -1;
        return cache.get(key);
    }

    public void put(int key, int value) {

    }

    public static void main(String[] args) {

    }

}
