package medium.evalRPN;

import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值
 *
 * @since 2023/4/22 1:24
 * @author by liangzj
 */
public class EvalRPNMain {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"4", "13", "5", "/", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        // 存放数字的栈
        LinkedList<String> numberStack = new LinkedList<>();

        for (String token : tokens) {
            // 是数字放到栈中
            if (isNumber(token)) {
                numberStack.push(token);
                continue;
            }

            // 不是数字取出栈顶的两数，计算后将结果压回栈中
            String number1 = numberStack.pop();
            String number2 = numberStack.pop();
            numberStack.push(count(Integer.parseInt(number2), Integer.parseInt(number1), token));
        }

        return Integer.parseInt(numberStack.pop());
    }

    public static String count(int number1, int number2, String operator) {
        return String.valueOf(
                switch (operator) {
                    case "+" -> number1 + number2;
                    case "-" -> number1 - number2;
                    case "*" -> number1 * number2;
                    case "/" -> number1 / number2;
                    default -> 0;
                });
    }

    public static boolean isNumber(String token) {
        return Character.isDigit(token.charAt(token.length() - 1));
    }
}
