package hot100.easyBracketValid;

import java.util.*;

/**
 * 20. 有效的括号
 *
 * @since 2024/3/6 12:07
 * @author by liangzj
 */
public class BracketValid {
    static Map<Character, Character> bracketMap =
            new HashMap<>() {
                {
                    put(')', '(');
                    put(']', '[');
                    put('}', '{');
                }
            };

    public static void main(String[] args) {
        System.out.println(isValid(")"));
    }

    public static boolean isValid(String s) {
        int len = s.length();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!bracketMap.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || !Objects.equals(bracketMap.get(c), stack.pop())) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
