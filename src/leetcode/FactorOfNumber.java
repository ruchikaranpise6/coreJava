package leetcode;

import java.util.ArrayList;

public class FactorOfNumber {

    public static void main(String[] args) {

        int n = 100;
        ArrayList response = new ArrayList();
        for (int i = 1; i <= n/i; i++) {
            if (n % i == 0) {
                response.add(i);
                response.add(n/i);
            }
        }

        response.forEach(v -> System.out.println(v));
    }
}
