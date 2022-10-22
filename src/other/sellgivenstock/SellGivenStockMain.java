package other.sellgivenstock;

import other.sellgivenstock.algorithm.SellGivenStockSolution;

public class SellGivenStockMain {
    public static void main(String[] args) {
        SellGivenStockSolution solution = new SellGivenStockSolution();
        int[] prices = {7,6,4,3,1};
        System.out.println(solution.maxProfit(prices));
    }
}
