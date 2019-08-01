package org.tguduru.ds.lab.java;

/**
 * Sum of the digits of a given number.
 *
 * @author Guduru, Thirupathi Reddy
 * @modified 7/26/16.
 */
public class DigitsSum {
    public static void main(String[] args) {
        int n = 12255;
        int r = 0;
        while (n != 0) {
            r += n % 10;
            n = n / 10;
        }
        System.out.println(r);
        char c = 'A';
        System.out.println("Char Value " + (int) c);
    }
}
