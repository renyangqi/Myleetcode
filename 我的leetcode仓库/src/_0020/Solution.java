package _0020;

import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            }
            if (character == ')' || character == ']' || character == '}') {
                if(stack.isEmpty()){
                    return false;
                }
                if (stack.pop() != reverse(character)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static Character reverse(Character character) {
        if(character == ')'){
            return '(';
        }
        if(character == ']'){
            return '[';
        }
            return '{';

    }

    public static void main(String[] args) {
        boolean valid = isValid("()");
    }
}

