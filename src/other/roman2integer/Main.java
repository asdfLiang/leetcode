package other.roman2integer;


import other.roman2integer.algorithm.FastSolution;

public class Main {
    public static void main(String[] args) {
        FastSolution solution = new FastSolution();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
