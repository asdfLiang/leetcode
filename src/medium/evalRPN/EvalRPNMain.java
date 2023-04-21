package medium.evalRPN;

import java.util.LinkedList;

/**
 * 150. �沨�����ʽ��ֵ
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

        // ������ֵ�ջ
        LinkedList<String> numberStack = new LinkedList<>();

        for (String token : tokens) {
            // �����ַŵ�ջ��
            if (isNumber(token)) {
                numberStack.push(token);
                continue;
            }

            // ��������ȡ��ջ��������������󽫽��ѹ��ջ��
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
