package io.tguduru.ds.lab.crackingcode.stack;

import java.util.Stack;

/**
 * Implementation of Towers of Hanoi game.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/9/16.
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 5; // number of disks
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            Tower tower = new Tower(i);
            towers[i] = tower;
        }
        for (int i = n; i > 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);
        towers[2].print();
        int moves = 0;
        for (int i = 0; i < 3; i++) {
            moves += towers[i].moves;
        }
        System.out.println("No of moves: " + (moves - n)); // subtract source towers push operations before start of the game.
    }

    static class Tower {
        Stack<Integer> disks;
        int index;
        int moves = 0;

        public Tower(int index) {
            this.index = index;
            disks = new Stack<>();
        }

        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.err.println("Unable to push");
            } else {
                moves++;
                disks.push(d);
            }
        }

        public void print() {
            while (!disks.isEmpty()) {
                System.out.println(disks.pop());
            }
        }

        public void moveTopTo(Tower t) {
            t.add(disks.pop());
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {

            if (n > 0) {
                moveDisks(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }
    }
}
