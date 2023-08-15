package leetcode;

public class InterviewQuestion {

    public static void main(String[] args) {
        String input = "*1 Rental $70,000Shopping  $299. Expenses $800 . House$2,00,000.";
        System.out.println(calculateSum(input));
    }


    static int calculateSum(String input) {

        int sum = 0;

        String[] arrayofwords = input.split("\\$");

        for (String word : arrayofwords) {

            String s = extractNumber(word);

            if (!s.isEmpty() && !s.isBlank()) {

                sum = sum + Integer.valueOf(s);
            }

        }
        return sum;
    }

    static String extractNumber(String word) {
        String number = "";
        char[] chars = word.toCharArray();
        for (char c : chars) {

            if (Character.isDigit(c)) {
                number = number + c;
            }

        }

        return number;
    }
}
