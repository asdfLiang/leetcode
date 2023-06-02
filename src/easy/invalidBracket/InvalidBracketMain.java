package easy.invalidBracket;

import java.util.*;

/**
 * 20. 有效的括号
 *
 * @since 2023/6/2 22:11
 * @author by liangzj
 */
public class InvalidBracketMain {
    public static void main(String[] args) {
        InvalidBracketMain object = new InvalidBracketMain();
        System.out.println(object.isValid("()"));
    }

    Map<Character, Character> bracketMap =
            new HashMap<>() {
                {
                    put(')', '(');
                    put(']', '[');
                    put('}', '{');
                }
            };

    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            // 左括号，直接入栈
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else if (stack.isEmpty() || !stack.pop().equals(bracketMap.get(c))) {
                // 右括号，1.没有左括号 2.左括号不匹配，直接返回
                return false;
            }
        }

        return stack.isEmpty();
    }
}
