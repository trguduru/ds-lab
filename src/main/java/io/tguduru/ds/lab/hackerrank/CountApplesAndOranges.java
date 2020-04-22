package io.tguduru.ds.lab.hackerrank;

/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 *
 * @author Guduru, Thirupathi Reddy
 * created 9/16/19
 */
public class CountApplesAndOranges {
    public static void main(String[] args) {
        int s = 7;
        int t = 11;
        int appleTree = 5;
        int orangesTree = 15;
        int numberOfApples = 3;
        int[] appleLandedDistance = {-2,2,1};
        int numberOfOranges = 3;
        int[] orangesLandedDistance = {5,-6};

        countApplesAndOranges(s, t, appleTree, orangesTree, appleLandedDistance, orangesLandedDistance);
    }

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

        //count apples
        int appleCount = 0;
        for (int i = 0; i < apples.length; i++) {
            if (apples[i] > 0 && (a + apples[i]) >= s) {
                appleCount++;
            }
        }

        int orangesCount = 0;
        for (int i = 0; i < oranges.length; i++) {
            if (oranges[i] < 0 && (b + oranges[i]) <= t) {
                orangesCount++;
            }
        }

        System.out.println(appleCount);
        System.out.println(orangesCount);
    }
}
