package io.tguduru.ds.lab.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * HackerLand University has the following grading policy:
 * Every student receives a grade in the inclusive range from 0 to 100.
 * Any grade less than 40 is a failing grade.
 * <p>
 * Sam is a professor at the university and likes to round each student's grade according to these rules:
 * <p>
 * If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
 * If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
 * <p>
 * For example, grade=84  will be rounded to 85 but grade=29 will not be rounded because the rounding would result in a number that is less than 40.
 * <p>
 * Given the initial value of grade for each of Sam's n students, write code to automate the rounding process.
 * <p>
 * Function Description:
 * <p>
 * Complete the function gradingStudents in the editor below. It should return an integer array consisting of rounded grades.
 * gradingStudents has the following parameter(s):
 * grades: an array of integers representing grades before rounding
 * Input Format
 * The first line contains a single integer, , the number of students.
 * Each line  of the  subsequent lines contains a single integer, , denoting student 's grade.
 * Constraints
 * <p>
 * <p>
 * Output Format
 * For each , print the rounded grade on a new line.
 * Sample Input:
 * 4
 * 73
 * 67
 * 38
 * 33
 * Sample Output:
 * 75
 * 67
 * 40
 * 33
 * <p>
 * <p>
 * Solution:
 * - find co-efficient only if the number is >= 38 else the grade is as is.
 * - find reminder.
 * - find the difference between the reminder and 5.
 * - if reminder is less than 3 then increment co-efficient by 1 and multiply 5 and then set the grade.
 * - else set the grade as is.
 * <p>
 * https://www.hackerrank.com/challenges/grading/problem
 *
 * @author Guduru, Thirupathi Reddy
 * created 9/15/19
 */
public class GradingStudents {
    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(73, 67, 38, 33);
        List<Integer> finalGrades = findGrade(grades);
        finalGrades.forEach(System.out::println);
    }

    private static List<Integer> findGrade(List<Integer> grades) {
        if (grades.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> finalGrades = new ArrayList<>();
        for (Integer grade : grades) {
            if (grade < 38) {
                finalGrades.add(grade);
            } else {
                int coefficient = grade / 5;
                int reminder = grade % 5;
                int diff = 5 - reminder;
                if (diff < 3) {
                    finalGrades.add((coefficient + 1) * 5);
                } else {
                    finalGrades.add(grade);
                }
            }
        }

        return finalGrades;
    }
}
