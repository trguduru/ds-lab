package io.tguduru.ds.lab.leetcode.linkedin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement:
 *
 *
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.
 * What if we change the game so that players cannot re-use integers?
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 *
 * Example
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 *
 * Output:
 * false
 *
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 *
 * @author Guduru, Thirupathi Reddy
 * created 8/27/19
 */
public class CanIWin {
    public static void main(String[] args) {
        int maxChooseInt = 10;
        int desiredValue = 40;
        boolean player1 = false, player2 = false;
        int playSum = 0;
        for (int i = maxChooseInt; i > 0; i--) {
            if (!player1) {
                player1 = true;
                player2 = false;
            } else {
                player2 = true;
                player1 = false;
            }
            playSum = playSum + i;
            if (playSum >= desiredValue) {
                System.out.println(playSum + "  -  " + desiredValue);
                break;
            }
        }

        System.out.println("Who Wins : Player 1 : " + player1 + " - Player 2 :" + player2);

        System.out.println(new CanIWinSolution().canIWin(10,40));
    }

    static class CanIWinSolution {
        Map<String, Boolean> memo; // key: chosen[] to string, value: canIWinWithSituation return value when chosen to string is key

        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

            if (desiredTotal <= maxChoosableInteger)
                return true;
            if (((1 + maxChoosableInteger) / 2 * maxChoosableInteger) < desiredTotal) {
                return false;
            }
            memo = new HashMap<>();

            return canIWinWithSituation(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1]);
        }

        private boolean canIWinWithSituation(int maxChoosableInteger, int curDesiredTotal, boolean[] chosen) {

            if (curDesiredTotal <= 0) {
                return false;
            }

            String chosenSerialization = Arrays.toString(chosen);
            if (memo.containsKey(chosenSerialization)) {
                return memo.get(chosenSerialization);
            }

            for (int i = 1; i <= maxChoosableInteger; i++) {
                if (chosen[i]) {
                    continue;
                }
                chosen[i] = true;
                if (!canIWinWithSituation(maxChoosableInteger, curDesiredTotal - i, chosen)) {
                    memo.put(chosenSerialization, true);
                    chosen[i] = false;
                    return true;
                }
                chosen[i] = false;
            }
            memo.put(chosenSerialization, false);
            return false;
        }
    }
}
