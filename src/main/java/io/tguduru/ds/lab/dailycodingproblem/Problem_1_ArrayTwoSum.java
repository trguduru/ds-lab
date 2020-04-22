package io.tguduru.ds.lab.dailycodingproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This problem was recently asked by Google.
 *
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * <p>
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * <p>
 * Bonus: Can you do this in one pass?
 * <p>
 * <p>
 * https://leetcode.com/problems/two-sum/
 *
 * @author Guduru, Thirupathi Reddy
 * created 9/15/19
 */
public class Problem_1_ArrayTwoSum {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 6, 23, 4, 67,6, 5, 8,8};
        int sum = 9;
        Map<Integer, Integer> integerMap = new HashMap<>();
        List<SumPair> sumPairs = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = sum - numbers[i];
            if (integerMap.containsKey(numbers[i])) { // means pair found
                Pair first = new Pair(numbers[integerMap.get(numbers[i])], integerMap.get(numbers[i]));
                Pair second = new Pair(numbers[i], i);
                SumPair sumPair = new SumPair(first, second);
                sumPairs.add(sumPair);
            } else { // not found so add it to the map
                integerMap.put(diff, i);
            }
        }

        sumPairs.forEach(System.out::println);
    }

    static class Pair {
        int number, index;

        public Pair(int number, int index) {
            this.number = number;
            this.index = index;
        }

        public int getNumber() {
            return number;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Pair{");
            sb.append("number=").append(number);
            sb.append(", index=").append(index);
            sb.append('}');
            return sb.toString();
        }
    }

    static class SumPair {
        Pair first, second;

        public SumPair(Pair first, Pair second) {
            this.first = first;
            this.second = second;
        }

        public Pair getFirst() {
            return first;
        }

        public Pair getSecond() {
            return second;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("SumPair{");
            sb.append("first=").append(first);
            sb.append(", second=").append(second);
            sb.append('}');
            return sb.toString();
        }
    }
}
