package medium.backtrace;

import java.util.*;

/**
 * 22. 括号生成
 *
 * @author by liangzj
 * @since 2022/10/22 13:35
 */
public class GenerateParenthesisMain {
    public static void main(String[] args) {
        //
        List<String> strings = generateParenthesis(2);
        System.out.println(strings);
    }

    public static List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }

        Set<String> res = new HashSet<>();
        String temp;

        for (String s : generateParenthesis(n - 1)) {
            for (int i = 0; i < (s.length() + 1); i++) {
                temp = s.substring(0, i) + "()" + s.substring(i);
                res.add(temp);
            }
        }

        return new ArrayList(res);
    }
}
