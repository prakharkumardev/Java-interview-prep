package dev.harsh.builderBuffer;

public class BuilderBufferScenario {
    public static String reversedString(String input) {
        //Base Case
        if(input.isEmpty()){
            return input;
        }

        String out =  reversedString(input.substring(1)) + input.charAt(0);
        System.out.println(input);
        return out;
    }
    public static StringBuilder reversedString(StringBuilder input) {
        //Base Case
        if(input.length() == 1){
            return input;
        }

        StringBuilder out =  reversedString(input.deleteCharAt(0)).append(input.charAt(0));
        System.out.println(input);
        return out;
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("abc");
        builder.append("def");
        String data = builder.toString().intern();
        String data1 = "abcdef";
        System.out.println(data1 == data);
        System.out.println(builder);
        builder.reverse();
        System.out.println(builder);

        StringBuffer buffer = new StringBuffer("abc");
        buffer.append("def");
        String data3 = buffer.toString().intern();
        String data4 = "abcdef";
        System.out.println(data3 == data4);
        System.out.println(builder);

        System.out.println(reversedString("abc"));
        System.out.println(reversedString(new StringBuilder("abc")));

    }
}
