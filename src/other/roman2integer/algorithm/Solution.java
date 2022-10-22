package other.roman2integer.algorithm;

public class Solution {

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 == s.length()) {
                return result + getIntByRomans(s.charAt(i));
            }
            String curRoman = s.substring(i, i + 2);
            if (getIntByRomans(curRoman) == 0) {
                result += getIntByRomans(s.charAt(i));
                i++;
            } else {
                result += getIntByRomans(curRoman);
                i += 2;
            }
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

    private int getIntByRomans(String roman) {
        switch (roman) {
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
            default:
                return 0;
        }
    }
}
