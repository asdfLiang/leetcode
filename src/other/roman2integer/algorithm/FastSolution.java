package other.roman2integer.algorithm;

public class FastSolution {

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (i + 1 >= s.length()) {
                return result + getIntByRomans(s.charAt(i));
            }
            int curValue = getIntByRomans(s.charAt(i));
            int outValue = getIntByRomans(s.charAt(i + 1));
            result += (outValue > curValue ? -curValue : curValue);
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
