package leetcode;

public class CountCharsInString {

    public static void main(String[] args) {

        String s = "tgdnclnahwwljnwmkaqddd";

        char[] array = s.toCharArray();


        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }

            System.out.println(array[i] + " - " + count);
        }
    }
}
