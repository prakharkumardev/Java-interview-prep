package dev.harsh.hashmap;

public interface MyMap<V>{
    boolean isEmpty();
    boolean search(String key);
    void put(String key,V value);
    V get(String key);
    boolean remove(String key);
    void putIfAbsent(String key,V value);
}
