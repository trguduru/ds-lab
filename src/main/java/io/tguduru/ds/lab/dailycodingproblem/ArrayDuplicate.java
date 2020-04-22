package io.tguduru.ds.lab.dailycodingproblem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Guduru, Thirupathi Reddy
 * created 2/24/20
 */
public class ArrayDuplicate {
    public static void main(String[] args) {
        int numbers[] = {1, 2, 3, 5, 4, 7, 8, 10,25,10};
        int duplicateNumber = findDuplicate(numbers);
        //   System.out.println(duplicateNumber);
        printRepeating(numbers, numbers.length);
    }

    /**
     * Use external data structure to check for duplicates
     *
     * @param numbers
     * @return
     */
    private static int findDuplicate(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Empty Array");
            return 0;
        }
        Set<Integer> uniqueuNumbers = new HashSet<>();
        for (int number : numbers) {

            if (uniqueuNumbers.contains(number))
                return number;
            else {
                uniqueuNumbers.add(number);
            }

        }

        return 0;
    }

    static void printRepeating(int arr[], int size) {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++) {
            if (Math.abs(arr[i]) <= size-1){
                System.out.println(Math.abs(arr[i]));
                if (arr[Math.abs(arr[i])] >= 0)
                    arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
                else
                    //since we touched the element by changing the value to negative means its a repeating number.
                    System.out.println("duplicate: "+Math.abs(arr[i]) + " ");
            }
        }
    }
}
