package io.tguduru.ds.lab.leetcode.linkedin;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 * Note:
 * 1. 1 <= w.length <= 10000
 * 2. 1 <= w[i] <= 10^5
 * 3. pickIndex will be called at most 10000 times.
 *
 * Example 1:
 * Input:
 *
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 *
 * Output: [null,0]
 *
 * Example 2:
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 *
 * @author Guduru, Thirupathi Reddy
 * created 8/28/19
 */
public class RandonPickWeight {
    Random random;
    int[] wSums;

    public RandonPickWeight(int[] w) {
        this.random = new Random();
        for (int i = 1; i < w.length; ++i)
            w[i] += w[i - 1];
        this.wSums = w;
    }

    public int pickIndex() {
        int v = random.nextInt(wSums[wSums.length-1]);
        int ind = Arrays.binarySearch(wSums,v);
        if(ind>=0) return ind+1;
        else return -ind-1;
    }
    public static void main(String[] args) {
        int[] w = {1,3};
        RandonPickWeight randonPickWeight = new RandonPickWeight(w);
        for (int i = 0; i < 12; i++) {
            System.out.print(randonPickWeight.pickIndex() + "\t");
        }
    }
}
