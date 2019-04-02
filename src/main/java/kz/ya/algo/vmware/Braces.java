package kz.ya.algo.vmware;

import java.util.Stack;

/**
 *
 * @author yerlana
 */
public class Braces {

    private static String isParenthesesBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char opening = stack.peek();
                if ((c == ')' && opening == '(') || (c == ']' && opening == '[')
                        || (c == '}' && opening == '{')) {
                    stack.pop();
                }
            }
        }

        if (input.length() > 0 && stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        String[] inputs = {"{[()]}", "{[(])}", "{{[[(())]]}}"};
        
        String[] result = new String[inputs.length];
        
        for (int i = 0; i < inputs.length; i++) {
            String res = isParenthesesBalanced(inputs[i]);
            result[i] = res;
            System.out.println(res);
        }        
    }
}
