package main.java.com.freecodecamp.lesson1;

import java.util.HashMap;

public class Trib {
    public static int tribonacci(int n) {
        return tribonacci(n, new HashMap<>());
    }

    public static int tribonacci(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = tribonacci(n - 1, memo) + tribonacci(n - 2, memo) + tribonacci(n - 3, memo);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        int[] expected = { 0, 1, 1, 2, 4, 7, 13, 24, 44, 81 };

        for (int i = 0; i < expected.length; i++) {

            if (tribonacci(i) != expected[i]) {
                System.out.println("Test failed for " + i);
                return;
            } else {
                System.out.println("Test passed for " + i);
            }
        }
    }
}
