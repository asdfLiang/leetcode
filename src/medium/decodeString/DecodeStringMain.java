package medium.decodeString;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 *
 * @since 2023/4/23 22:56
 * @author by liangzj
 */
public class DecodeStringMain {

    public static void main(String[] args) {
        DecodeStringMain obj = new DecodeStringMain();
        System.out.println(obj.decodeString("3[a]2[bc]"));
        //        DecodeStringMain obj2 = new DecodeStringMain();
        //        System.out.println(obj2.decodeString("3[a2[c]]"));
    }

    int i = 0;

    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        int length = s.length();

        while (i < length) {
            if (Character.isDigit(s.charAt(i))) {
                // 数字获取到完整数字后压入
                stack.push(getDigit(s));
            } else if ('[' == s.charAt(i) || Character.isLetter(s.charAt(i))) {
                // 左括号或字母直接压入
                stack.push(String.valueOf(s.charAt(i++)));
            } else { // 右括号开始弹出
                ++i;
                // 拼接子字符串
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peek())) sub.push(stack.pop());
                stack.pop(); // "["
                String subString = getString(sub);
                // 压入重复次数的子字符串
                stack.push(subString.repeat(Integer.parseInt(stack.pop())));
            }
        }

        Collections.reverse(stack);
        return getString(stack);
    }

    public String getDigit(String s) {
        StringBuilder digitBuilder = new StringBuilder();

        while (Character.isDigit(s.charAt(i))) {
            digitBuilder.append(s.charAt(i++));
        }
        return digitBuilder.toString();
    }

    public String getString(LinkedList<String> sub) {
        StringBuilder builder = new StringBuilder();

        while (!sub.isEmpty()) {
            builder.append(sub.pop());
        }

        return builder.toString();
    }
}
