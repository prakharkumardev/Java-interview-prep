package dev.harsh;

import java.util.*;

public class Main {
    static String s = "123456789looooooool";

    public static boolean countGreaterThanOne(char ch){
        System.out.println(ch);
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(ch) != null && map.get(ch) > 1) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        List<Integer> list =  List.of(1,2,2,3,4,1,5);
        Map<Character, Integer> map = new HashMap<>();
        Character c1 = s.chars().parallel().mapToObj(c -> (char) c).filter(Main::countGreaterThanOne).findFirst()
                .orElseThrow(RuntimeException::new);
        System.out.println(c1);

    }
}