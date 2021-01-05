import java.util.HashMap;

public class HashMapDemo {
//    private static final long serialVersionUID = 362498820763181265L;
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//    static final int TREEIFY_THRESHOLD = 8;
//    static final int UNTREEIFY_THRESHOLD = 6;
//    static final int MIN_TREEIFY_CAPACITY = 64;
//    final float loadFactor;
//
//
//
//    public HashMap(int initialCapacity, float loadFactor) {
//        if (initialCapacity < 0)
//            throw new IllegalArgumentException("Illegal initial capacity: " +
//                    initialCapacity);
//        if (initialCapacity > MAXIMUM_CAPACITY)
//            initialCapacity = MAXIMUM_CAPACITY;
//        if (loadFactor <= 0 || Float.isNaN(loadFactor))
//            throw new IllegalArgumentException("Illegal load factor: " +
//                    loadFactor);
//        this.loadFactor = loadFactor;
//        this.threshold = tableSizeFor(initialCapacity);
//    }

























    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        HashMap hashMap1 = new HashMap(12);
        hashMap1.put("a","a");
    }
}
