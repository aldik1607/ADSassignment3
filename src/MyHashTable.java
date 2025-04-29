public class MyHashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 11;
    private HashNode<K, V>[] table;
    private int numBuckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        this.numBuckets = DEFAULT_CAPACITY;
        this.table = new HashNode[numBuckets];
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int capacity) {
        this.numBuckets = capacity;
        this.table = new HashNode[numBuckets];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % numBuckets;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }

        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> current = table[index];
        HashNode<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }

        return null;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public K getKey(V value) {
        for (int i = 0; i < numBuckets; i++) {
            HashNode<K, V> current = table[i];
            while (current != null) {
                if (current.value.equals(value)) return current.key;
                current = current.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int bucketSize(int index) {
        int count = 0;
        HashNode<K, V> current = table[index];
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void clear() {
        for (int i = 0; i < numBuckets; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numBuckets; i++) {
            sb.append("Bucket ").append(i).append(": ");
            HashNode<K, V> current = table[i];
            while (current != null) {
                sb.append(current).append(" -> ");
                current = current.next;
            }
            sb.append("null\n");
        }
        return sb.toString();
    }

    private static class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
}
