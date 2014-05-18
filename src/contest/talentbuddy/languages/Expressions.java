package contest.talentbuddy.languages;

import java.util.Stack;

public class Expressions {

    public static void main(String[] args) {

    }

    public static void compute_expression(String expr) {
        int result = 0;
        boolean prevSignIsMinus = false;
        StringBuilder num = new StringBuilder();
        Stack<Boolean> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            switch (ch) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    num.append(ch);
                    break;
                case '-':
                    if(num.length() > 0) {
                        int value = Integer.parseInt(num.toString());
                        if(prevSignIsMinus) result -= value;
                        else result += value;
                    }
                    prevSignIsMinus = true;
                    break;
                case '+':
                    if(num.length() > 0) {
                        int value = Integer.parseInt(num.toString());
                        if(prevSignIsMinus) result -= value;
                        else result += value;
                    }
                    prevSignIsMinus = false;
                case '(':
                    stack.push(prevSignIsMinus ? false: true);
                    break;
                case ')':
                    if(num.length() > 0) {
                        int value = Integer.parseInt(num.toString());
                        if(prevSignIsMinus) result -= value;
                        else result += value;
                    }
                    stack.pop();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

    }
}
