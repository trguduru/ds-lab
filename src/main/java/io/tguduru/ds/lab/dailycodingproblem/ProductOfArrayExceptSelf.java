package io.tguduru.ds.lab.dailycodingproblem;

import java.util.Arrays;

/**
 * This problem was asked by Uber.
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 * <p>
 * https://leetcode.com/problems/product-of-array-except-self/
 * <p>
 * <p>
 * Constraints :
 * 1. Zeros allowed
 * 2. Negatives allowed
 * 3. Solve without division
 *
 * @author Guduru, Thirupathi Reddy
 * created 9/15/19
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        productsWithDivision(numbers);
        productWithoutDivision(numbers);
    }

    private static void productWithoutDivision(int[] numbers) {
    }


    private static void productsWithDivision(int[] numbers) {
        int totalProduct = 1;
        boolean isZeroFound = false;
        int zerosCount = 0;
        for (int number : numbers) {
            if (number == 0) {
                isZeroFound = true;
                zerosCount++;
                continue;
            }
            totalProduct = totalProduct * number;
        }
        int productsArray[] = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (isZeroFound && numbers[i] > 0) { // zero exists and not zero index means all others will be zero
                productsArray[i] = 0;
            } else if (numbers[i] > 0) { // no zero then do the regular one
                int productExceptThisNumber = totalProduct / numbers[i];
                productsArray[i] = productExceptThisNumber;
            } else { // zero index will have the total product
                if (zerosCount == numbers.length)
                    productsArray[i] = 0;
                else
                    productsArray[i] = totalProduct;
            }
        }
        System.out.println(totalProduct);
        System.out.println(Arrays.toString(productsArray));
    }
}
