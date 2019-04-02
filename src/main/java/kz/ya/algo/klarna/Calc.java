package kz.ya.algo.klarna;

import java.util.Stack;

/**
 *
 * @author yerlana
 */
public class Calc {

    public static void main(String[] args) {
        System.out.println(evaluate(""));
        System.out.println(evaluate("1 2 3"));
        System.out.println(evaluate("1 2 3.5"));
        System.out.println(evaluate("1 3 +"));
        System.out.println(evaluate("1 3 *"));
        System.out.println(evaluate("1 3 -"));
        System.out.println(evaluate("4 2 /"));
        System.out.println(evaluate("10000 123 +"));
        System.out.println(evaluate("5 1 2 + 4 * + 3 -"));
    }

    public static double evaluate(String expr) {
        if (expr.isEmpty()) { // if empty, then return 0
            return 0;
        }
        Stack<Double> numbers = new Stack<>(); // stack for numbers
        
        // split string by empty space
        // iterate through each element
        for (String element : expr.split(" ")) {
            if (element.equals("+")) {
                // if element is equal to ADD
                Double n = numbers.pop();
                numbers.push(numbers.pop() + n);
            } else if (element.equals("-")) {
                // if element is equal to SUBTRACT
                Double n = numbers.pop();
                numbers.push(numbers.pop() - n);
            } else if (element.equals("*")) {
                // if element is equal to MULTIPLY
                Double n = numbers.pop();
                numbers.push(numbers.pop() * n);
            } else if (element.equals("/")) {
                // if element is equal to DIVIDE
                Double n = numbers.pop();
                numbers.push(numbers.pop() / n);
            } else {
                // else it is number, add it to stack
                numbers.push(Double.valueOf(element));
            }
        }
        
        // return final value
        return numbers.pop();
    }
}
