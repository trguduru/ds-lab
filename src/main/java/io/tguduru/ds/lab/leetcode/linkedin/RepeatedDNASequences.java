package io.tguduru.ds.lab.leetcode.linkedin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * @author Guduru, Thirupathi Reddy
 * created 8/28/19
 */
public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        int start = 0, end = 10;
        List<String> duplicate = new ArrayList<>();
        Set<String> duplicateCheck = new HashSet<>();

        //TODO: add boundary conditions.
        for (int i = 0; i < s.length(); i++) {
            int endPosition = end + i;
            if (endPosition <= s.length()) {
                String subString = s.substring(start + i, end + i);
                boolean isDuplicate = duplicateCheck.contains(subString);
                if (isDuplicate && !duplicate.contains(subString)) {
                    duplicate.add(subString);
                }
                duplicateCheck.add(subString);
            }
        }
        duplicate.forEach(System.out::println);
    }
}
