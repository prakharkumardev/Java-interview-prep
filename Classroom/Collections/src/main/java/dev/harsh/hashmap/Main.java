package dev.harsh.hashmap;

import dev.harsh.hashmap.strategy.CustomHashingStrategy;
import dev.harsh.hashmap.strategy.HashingStrategy;
import dev.harsh.hashmap.strategy.InternalHashingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static class InnerClass{
        public static void addNumbers(List<? super Double> list) {
            list.add(1.0);
            list.add(2.0);
            list.add(3.0);

            for(Object integer : list){
                System.out.println(integer);
            }
        }
        public static void iterate(List<? extends Number> list){
            for(Number integer : list){
                System.out.println(integer);
            }
        }

        public static void main(String[] args) {
            List<Number> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            addNumbers(list);

        }
    }

    public static void main(String[] args) {
        HashingStrategy hashingStrategy = new InternalHashingStrategy();
        MyMap<String> map = new MyHashMap<>(hashingStrategy);
        map.put("abc", "1");
        map.put("def", "2");
        map.put("ghi", "3");
        map.put("jkl", "4");
        map.put("mno", "5");
        map.put("pqr", "6");
        map.put("stu", "7");
        map.put("vwx", "8");
        map.put("yz", "9");
        map.put("ab1", "10");
        map.put("cd2", "11");
        map.put("ef3", "12");
        map.put("gh4", "13");
        map.put("ij5", "14");
        map.put("kl6", "15");
        map.put("mn7", "16");
        map.put("op8", "17");
        map.put("qr9", "18");
        map.put("st0", "19");
        map.put("uv1", "20");
        map.putIfAbsent("yz","5");
        System.out.println(map.get("yz"));
        System.out.println(map.search("abc"));
        System.out.println(map.remove("abc"));
        System.out.println(map);
    }
}
