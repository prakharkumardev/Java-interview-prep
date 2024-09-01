package dev.harsh.stringLiteralPool;

import java.util.Objects;

public class StringPoolScenarios {
    public static void main(String[] args) {
        String s = "abc";
        String d = "abc";
        System.out.println(s == d);
        String e = "a" + "b" + "c";
        System.out.println(s == e);
        String x = "a" + s.substring(1);
        System.out.println(s == x);
        String z = new String("abc").intern();
        System.out.println(s == z);
        String test =  s.substring(1).intern();
        System.out.println(test == "bc");
        System.out.println(s.equals(d));
        System.out.println(d.equals(s));
        s = null;
//        System.out.println(s.equals(d));
        System.out.println(Objects.equals(s,d));
        System.out.println("abc".equals(s));
        String m = "abc";
        String t = m;
        System.out.println(t == m);
        String print = String.format("a%sc","b").intern();
        System.out.println(print == d);
        d.contentEquals(new StringBuilder("abc").toString());
    }
}
