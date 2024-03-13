package main.java.com.freecodecamp.lesson2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SumPossible {

    public static boolean sumPossible(int amount, List<Integer> numbers) {
        return sumPossible(amount, numbers, new HashMap<>());
    }

    public static boolean sumPossible(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        // Base
        if (amount == 0) {
            return true;
        }

        if (amount < 0) {
            return false;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        for (int num : numbers) {
            int sumAmount = amount - num;
            if (sumPossible(sumAmount, numbers, memo)) {
                // If I can make my sub amounts I can make the full amount
                memo.put(amount, true);
                return true;
            }
        }

        memo.put(amount, false);
        return false;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);
        int amount = 14;
        System.out.println(sumPossible(amount, numbers));
    }

}
