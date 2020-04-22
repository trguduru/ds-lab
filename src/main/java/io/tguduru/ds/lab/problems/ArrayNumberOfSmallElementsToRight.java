package io.tguduru.ds.lab.problems;

import java.util.Arrays;

/**
 * This problem was asked by Google.
 * <p>
 * Given an array of integers, return a new array where each element in the new array is the number of smaller elements to the right of that element in the original input array.
 * <p>
 * For example, given the array [3, 4, 9, 6, 1], return [1, 1, 2, 1, 0], since:
 * <p>
 * There is 1 smaller element to the right of 3
 * There is 1 smaller element to the right of 4
 * There are 2 smaller elements to the right of 9
 * There is 1 smaller element to the right of 6
 * There are no smaller elements to the right of 1
 * <p>
 * <p>
 * Follow up Questions:
 * 1. is the array contains always positives ( >0 ) always?
 * 2. are there any time complexity requirements? this could be a O(nXn).
 *
 * @author Guduru, Thirupathi Reddy
 * created 2/25/20
 */
public class ArrayNumberOfSmallElementsToRight {
    public static void main(String[] args) {
        int[] input = {3, 4, 9, 6, 1, 5, 89, 33, 2, 45, 2, 5};
        printSmallerNumbersArray(input);
    }

    private static void printSmallerNumbersArray(int[] input) {
        if (input.length == 0) {
            System.out.println("Empty Array");
        }

        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int curVal = input[i];
            int smallElementCount = 0;
            for (int j = i + 1; j < input.length; j++) {
                if (curVal > input[j]) {
                    smallElementCount++;
                }
            }

            result[i] = smallElementCount;
        }

        System.out.println(Arrays.toString(result));
    }
}
