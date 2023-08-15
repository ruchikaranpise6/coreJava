package leetcode;

import java.util.Arrays;

public class AppendDot {

    public static void main(String[] args) {
        String s1 = "hello world";
        String s2 = "hello pune.";
        System.out.println(appendMsg(s1));
        System.out.println(appendMsg(s2));

    }

    static String appendMsg(String... var){
        StringBuilder message = new StringBuilder();
        Arrays.stream(var).forEach(s -> message.append(s));
        if(message.toString().charAt(message.length()-1) != '.'){
            message.append('.');
        }
        return message.toString();
    }

}
