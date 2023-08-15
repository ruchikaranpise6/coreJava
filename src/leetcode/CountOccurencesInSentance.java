package leetcode;

import java.util.HashMap;

public class CountOccurencesInSentance {

    public static void main(String[] args) {

        String input = "This is a good programming statement and this statement has repeated words.";
        HashMap<String, Integer> response = new HashMap<>();
        String[] inputArray = input.split(" ");
        int length = inputArray.length;
        for (int i = 0; i < length; i++) {

            if (response.containsKey(inputArray[i])) {
                int count = response.get(inputArray[i]) + 1;
                response.put(inputArray[i], count);
            } else {
                response.put(inputArray[i], 1);
            }
        }

        response.forEach((k, v) -> System.out.println("Word - " + k + " occurrence - " + v));
    }
}
