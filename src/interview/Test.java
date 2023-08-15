package interview;


public class Test {

    public static void main(String[] args) {
        printFibonnaci(50);

    }


    static void printFibonnaci(int n) {
        int number1 = 1;
        int number2 = 1;
        System.out.println(" " + number1 + " " + number2);
        for (int i = 3; i <= n; i++) {
                int temp = number2;
                number2 = Math.addExact(number1, number2);
                number1 = temp;
                System.out.println(" ," + number2);
        }
    }
}
