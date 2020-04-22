package io.tguduru.ds.lab.problems;

import java.util.Arrays;

/**
 * Given a sorted array, A, with possibly duplicated elements, find the indices of the first and last occurrences of a target element, x. Return -1 if the target is not found.
 * <p>
 * Example:
 * Input: A = [1,3,3,5,7,8,9,9,9,15], target = 9
 * Output: [6,8]
 * <p>
 * Input: A = [100, 150, 150, 153], target = 150
 * Output: [1,2]
 * <p>
 * Input: A = [1,2,3,4,5,6,10], target = 9
 * Output: [-1, -1]
 * <p>
 * <p>
 * <p>
 * Q:
 * 1. What if the duplicate not found? Can we return as [1,-1] for found position
 *
 * @author Guduru, Thirupathi Reddy
 * created 2/26/20
 */
public class FirstAndLastIndicesOfAnElementOfArray {
    public static void main(String[] args) {
        int[] input = {5, 7, 7, 8, 8, 10};
        int[] output = findFirstAndLastPosition(input, 8);
        System.out.println(Arrays.toString(output));

    }

    private static int[] findFirstAndLastPosition(int[] input, int element) {
        if (input == null || input.length == 0)
            return new int[]{-1, -1};
        if (input.length == 1) {
            if (input[0] == element)
                return new int[]{0, 0};
            else
                return new int[]{-1, -1};
        }
        int firstIndex = -1, lastIndex = -1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == element && firstIndex == -1) {
                firstIndex = lastIndex = i;
                if (i + 1 < input.length && input[i + 1] == element) {
                    for (int j = i; j < input.length; j++) {
                        if (input[j] == element)
                            continue;
                        else
                            lastIndex = j - 1;
                    }
                }
            }
        }
        return new int[]{firstIndex, lastIndex};
    }
}
