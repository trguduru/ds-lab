package io.tguduru.ds.lab.leetcode.linkedin;

import java.util.Arrays;

/**
 * @author Guduru, Thirupathi Reddy
 * created 9/12/19
 */
public class CoinChange {
    public static void main(String[] args) {
        int amount = 13;
        int[] coins = {1, 1, 3};
        Arrays.sort(coins);
        int coinsCount[] = new int[amount + 1];
        Arrays.fill(coinsCount, amount + 1);
        coinsCount[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i)
                    coinsCount[i] = Math.min(coinsCount[i], 1 + coinsCount[i - coins[j]]);
                else
                    break;
            }
        }
        System.out.println(coinsCount[amount] < amount ? coinsCount[amount] : -1);
    }
}
