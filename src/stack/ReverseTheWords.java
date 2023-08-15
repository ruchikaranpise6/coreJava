package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ReverseTheWords {

    public static void main(String[] args) {
        String input = "Hello World";
        reverseWords(input);
        reverseWordsUsingTokenizer(input);
        reverseWordsUsingJava8(input);
    }

    static void reverseWords(String input) {
        Stack s = new Stack();
        for (int i = 0; i < input.length() - 1; i++) {

            if (input.charAt(i) != ' ') {
                s.push(input.charAt(i));
            } else {
                while (s.isEmpty() == false) {
                    System.out.println(s.pop());
                }
                System.out.println(" ");
            }
        }

        //there may not be a space after last word
        while (s.isEmpty() == false) {
            System.out.println(s.pop());
        }

    }

    static void reverseWordsUsingTokenizer(String input) {
        String word;

        StringTokenizer token = new StringTokenizer(input);

        while (token.hasMoreTokens()) {
            word = token.nextToken();
            System.out.println(new StringBuilder(word).reverse() + " ");
        }
    }

    static void reverseWordsUsingJava8(String input) {
        List<String> words = Arrays.asList(input.split(" "));
        String result = words.stream().map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
