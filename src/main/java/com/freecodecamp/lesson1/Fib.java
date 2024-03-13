package main.java.com.freecodecamp.lesson1;

import java.util.HashMap;

class Source {
    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public static int fib(int n, HashMap<Integer, Integer> memo) {
        // Base case
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        int[] expected = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 };

        for (int i = 0; i < expected.length; i++) {

            if (fib(i) != expected[i]) {
                System.out.println("Test failed for " + i);
                return;
            } else {
                System.out.println("Test passed for " + i);
            }
        }
    }
}