package _0150;

import java.util.Stack;

class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i] + "";
            if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                stack.push(str);
            } else {
                if (str.equals("+")) {

                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    stack.push((b + a) + ""); //×¢ÒâÊÇ£¨b+a£© (b/a) ...

                } else if (str.equals("-")) {

                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    stack.push((b - a) + "");

                } else if (str.equals("*")) {

                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    stack.push((b * a) + "");

                } else {

                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    stack.push((b / a) + "");

                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
