package leetcode;

public class JavaCoding {

    public static void main(String[] args) {
        String input = "aaa";
        String substring = "aa";
        subStringCount(input, substring);

    }

    static int subStringCount(String input, String substring) {
        int count = 0;
        if (input.length() >= substring.length()) {

            int j = 0;
            for (int i = 0; i < input.length() - substring.length(); i++) {

                for (j = 0; j < substring.length(); j++) {

                    if (substring.charAt(j) != input.charAt(i + j)) {
                        break;
                    }
                }

                if (j == substring.length()) {
                    count++;
                }
            }
        }
        System.out.println("Substring count - " + count);
        return count;
    }
}
