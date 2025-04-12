import java.util.*;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static int DEFAULT_INITIAL_CAPACITY = 4;
    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    private LinkedList<MyMap.Entry<K, V>>[] table;
    private int size = 0;

    public MyHashMap() {
        table = new LinkedList[DEFAULT_INITIAL_CAPACITY];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void clear() {
        size = 0;
        table = new LinkedList[DEFAULT_INITIAL_CAPACITY];
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<MyMap.Entry<K, V>> bucket = table[index];
        if (bucket != null) {
            for (MyMap.Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (LinkedList<MyMap.Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (MyMap.Entry<K, V> entry : bucket) {
                    if (entry.getValue().equals(value)) return true;
                }
            }
        }
        return false;
    }

    public java.util.Set<MyMap.Entry<K, V>> entrySet() {
        Set<MyMap.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MyMap.Entry<K, V>> bucket : table) {
            if (bucket != null) set.addAll(bucket);
        }
        return set;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<MyMap.Entry<K, V>> bucket = table[index];
        if (bucket != null) {
            for (MyMap.Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) return entry.getValue();
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public java.util.Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (LinkedList<MyMap.Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (MyMap.Entry<K, V> entry : bucket) {
                    set.add(entry.getKey());
                }
            }
        }
        return set;
    }

    public V put(K key, V value) {
        int index = hash(key);
        if (table[index] == null)
            table[index] = new LinkedList<>();

        for (MyMap.Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.value = value;
                return oldValue;
            }
        }

        table[index].add(new MyMap.Entry<>(key, value));
        size++;
        return value;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<MyMap.Entry<K, V>> bucket = table[index];
        if (bucket != null) {
            Iterator<MyMap.Entry<K, V>> iter = bucket.iterator();
            while (iter.hasNext()) {
                if (iter.next().getKey().equals(key)) {
                    iter.remove();
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public java.util.Set<V> values() {
        Set<V> set = new HashSet<>();
        for (LinkedList<MyMap.Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (MyMap.Entry<K, V> entry : bucket) {
                    set.add(entry.getValue());
                }
            }
        }
        return set;
    }
}
