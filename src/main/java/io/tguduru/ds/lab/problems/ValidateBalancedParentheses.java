package io.tguduru.ds.lab.problems;

import java.util.Scanner;
import java.util.Stack;

/**
 * Imagine you are building a compiler. Before running any code, the compiler must check that the parentheses in the program are balanced. Every opening bracket must have a corresponding closing bracket. We can approximate this using strings.
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * - Open brackets are closed by the same type of brackets.
 * - Open brackets are closed in the correct order.
 * - Note that an empty string is also considered valid.
 * <p>
 * Example:
 * Input: "((()))"
 * Output: True
 * <p>
 * Input: "[()]{}"
 * Output: True
 * <p>
 * Input: "({[)]"
 * Output: False
 *
 * @author Guduru, Thirupathi Reddy
 * created 2/25/20
 */
public class ValidateBalancedParentheses {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        validateBalancedParentheses(s);
    }

    private static void validateBalancedParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (char c : chars) {
            if (characters.size() > 0) { // peek the stack and see a open and close braces
                switch (c) {

                    case '(':
                    case '{':
                    case '[':
                        characters.push(c);
                        break;
                    case ')':
                        if (characters.peek() == '(')
                            characters.pop();
                        else
                            characters.push(c);
                        break;
                    case '}':
                        if (characters.peek() == '{')
                            characters.pop();
                        else
                            characters.push(c);
                        break;
                    case ']':
                        if (characters.peek() == '[')
                            characters.pop();
                        else
                            characters.push(c);
                        break;
                }
            } else
                characters.push(c);
        }

        if (characters.isEmpty()) {
            System.out.println("Valid operation");
        } else {
            System.out.println("Invalid Operation");
        }
    }
}
