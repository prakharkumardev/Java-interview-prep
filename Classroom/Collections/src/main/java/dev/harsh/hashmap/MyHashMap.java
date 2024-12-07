package dev.harsh.hashmap;

import dev.harsh.hashmap.strategy.HashingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class MyHashMap<V> implements MyMap<V>{
    private static final double LOAD_FACTOR = 100;
    private LinkedListNode<V>[] arr;
    private final HashingStrategy hashingStrategy;
    private int capacity;
    private int noOfElements;
    public MyHashMap(HashingStrategy hashingStrategy){
        this.capacity = 5;
        arr = new LinkedListNode[this.capacity];
        this.hashingStrategy = hashingStrategy;
    }

    public void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
    }

    @Override
    public boolean isEmpty() {

        return noOfElements == 0;
    }

    @Override
    public boolean search(String key) {
        return searchInternal(key) != null;
    }

    private LinkedListNode<V> searchInternal(String key){
        int bucketPosition = hashingStrategy.getHashValue(key) % capacity;
        if(arr[bucketPosition] == null){
            return null;
        }
        else{
            LinkedListNode<V> node = arr[bucketPosition];
            while(node != null){
                if(Objects.equals(key,node.getKey())){
                    return node;
                }
                node = node.getNext();
            }
        }
        return null;
    }

    @Override
    public void put(String key, V value) {
        //We need a method to calculate hash
        int hashValue = hashingStrategy.getHashValue(key);
        LinkedListNode<V> node = searchInternal(key);
        //Check the load factor
        if(node == null){
            noOfElements++;
        }
        double loadFactor = noOfElements / (double)capacity;
        if(loadFactor > LOAD_FACTOR){
            //Do re-hashing and again put the keys to the appropriate positions
            capacity = 2 * capacity;
            LinkedListNode<V>[] newArray = new LinkedListNode[capacity];
            //iterate over first arr and extract,rehash and insert
            for(int i = 0 ; i < arr.length ; ++i){
                if(arr[i] == null) continue;
                //Traverse over LinkedList and rehash and insert to new array
                // //(100)-//(101)-//(102)  temp->100   []->//->//->// (300)
                // []->//
                LinkedListNode<V> temp = arr[i];
                while(temp != null){
                    int newHashValue = hashingStrategy.getHashValue(temp.getKey()) % capacity;
                    if(newArray[newHashValue] == null){
                        newArray[newHashValue] = new LinkedListNode<>(temp.getKey(),temp.getValue(),null);
                    }
                    else{
                        // []-> ()->//->// Insert in begin
                        LinkedListNode<V> tempNode = new LinkedListNode<>(temp.getKey(),temp.getValue(),null);
                        tempNode.setNext(newArray[newHashValue]);
                        newArray[newHashValue] = tempNode;
                    }
                    temp = temp.getNext();

                }
            }
            arr = newArray;
        }
        int bucketPosition = hashValue % capacity;
        if(arr[bucketPosition] == null){
            arr[bucketPosition] = new LinkedListNode<>(key,value,null);
        }
        else{
            if(node != null){
                node.setValue(value);
            }
            else{
                // ()//->//->//
                //Insert the node in beg
                LinkedListNode<V> newNode = new LinkedListNode<>(key,value,null);
                newNode.setNext(arr[bucketPosition]);
                arr[bucketPosition] = newNode;
            }
        }

    }

    @Override
    public V get(String key) {
       LinkedListNode<V> node =  searchInternal(key);
       if(node == null){
           return null;
       }
       return node.getValue();
    }

    @Override
    public boolean remove(String key) {
        //For deletion we have to reach the previous node
        int bucketPosition = hashingStrategy.getHashValue(key) % capacity;
        if(arr[bucketPosition] == null){
            return false;
        }
        LinkedListNode<V> node = arr[bucketPosition];
        if(Objects.equals(key,node.getKey())){
            arr[bucketPosition] = node.getNext();
            --noOfElements;
            return true;
        }
        // [] ->//->//
        while(node.getNext() != null){
            if(Objects.equals(node.getNext().getKey(),key)){
                node.setNext(node.getNext().getNext());
                --noOfElements;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }


    @Override
    public void putIfAbsent(String key, V value) {
        boolean isPresent = search(key);
        if(isPresent) return;
        put(key,value);
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
