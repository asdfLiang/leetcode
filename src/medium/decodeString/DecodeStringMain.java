package medium.decodeString;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 394. �ַ�������
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
                // ���ֻ�ȡ���������ֺ�ѹ��
                stack.push(getDigit(s));
            } else if ('[' == s.charAt(i) || Character.isLetter(s.charAt(i))) {
                // �����Ż���ĸֱ��ѹ��
                stack.push(String.valueOf(s.charAt(i++)));
            } else {
                // �����ſ�ʼ����
                ++i;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peek())) sub.push(stack.pop());

                // �ַ����ظ�ƴ��
                stack.pop(); // "["
                String subString = getString(sub);
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
