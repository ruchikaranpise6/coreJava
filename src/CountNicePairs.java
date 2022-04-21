public class CountNicePairs {

    public static void main(String[] args) {
        System.out.println(countNicePairs(new int[]{13, 10, 35, 24,76}));
    }

    public static int countNicePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int rev(int number) {
        int reverse = 0;
        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        return reverse;
    }
}
