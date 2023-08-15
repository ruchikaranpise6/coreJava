package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringOperations {
    public static void main(String[] args) {

        //String to char array
        String string = "ABCDabcd";
        char[] charArray = string.toCharArray();
        calculateLengthOfArray(charArray);

        //Array to arraylist
        List characterList = Arrays.asList(charArray);

        //listToArray
        Object[] objArray = characterList.toArray();
    }

    static int calculateLengthOfArray(char[] charArray) {
        int i = 0;
        for (char c : charArray) {
            i++;
        }
        System.out.println("Length of array : " + i);
        return i;
    }
}
