package leetcode;

import java.util.HashMap;
import java.util.Map;

class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        int output = romanToInteger.romanToInt("MCMXCIV");
        System.out.println(output);
    }
    public int romanToInt(String s) {
        Integer output;
        Integer previousValue = 0;
        Map<Character, Integer> hm = new HashMap<>();

        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        char[] array = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            array[i] = s.charAt(i);
        }

        output = hm.get(array[0]);
        previousValue = output;
        for (int i = 1; i < array.length; i++) {

            Integer value1 = hm.get(array[i]);
            if (previousValue < value1) {
                output = output - previousValue;
                output = output + value1 - previousValue;
            } else {
                output = output + value1;
            }
            previousValue = value1;
        }
        hm.clear();
        return output;
    }
}