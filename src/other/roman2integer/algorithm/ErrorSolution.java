package other.roman2integer.algorithm;

public class ErrorSolution {

    public int romanToInt(String s) {
        // 从左边找到最大数字的下标
        int maxIndex = 0;
        int maxValue = getIntByRomans(s.charAt(maxIndex));
        for (int curIndex = 0; curIndex < s.length(); curIndex++) {
            int curValue = getIntByRomans(s.charAt(curIndex));
            if (curValue > maxValue) {
                maxIndex = curIndex;
                maxValue = curValue;
            }
        }

        // 最大值左边减，最大值右边加
        int result = 0;
        for (int curIndex = 0; curIndex < s.length(); curIndex++) {
            int curValue = getIntByRomans(s.charAt(curIndex));
            result += (curIndex < maxIndex ? -curValue : curValue);
        }
        return result;
    }

    private int getIntByRomans(char roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
