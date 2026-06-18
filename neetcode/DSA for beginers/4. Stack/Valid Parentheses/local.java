// Valid Parentheses

// You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
// The input string s is valid if and only if:

// Every open bracket is closed by the same type of close bracket.
// Open brackets are closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
// Return true if s is a valid string, and false otherwise.

// Example 1:
// Input: s = "[]"
// Output: true

// Example 2:
// Input: s = "([{}])"
// Output: true

// Example 3:
// Input: s = "[(])"
// Output: false

// Explanation: The brackets are not closed in the correct order.

// Constraints:
// 1 <= s.length <= 1000

import java.util.Stack;

class Main {
    public static void main(String[] args) {
        String s = "([{}])";

        boolean flag = isValid(s);

        System.out.print(flag);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                default:
                    stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}