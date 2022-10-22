package other.sellgivenstock.algorithm;

/**
 * 买卖股票的最佳时机 II
 *
 * @author liangzj
 * @date 2020/07/04 16:59:34
 */
public class SellGivenStockSolution {

    /**
     * 入参是每日的股票价格
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 买入日期，-1代表没有买入
        int purchaseDay = -1;
        // 当前日期，从第一天开始
        int currentDay = 0;
        // 利润，初始为0
        int profit = 0;

        while (currentDay < prices.length - 1) {
            // 如果后一天要涨
            if (prices[currentDay + 1] >= prices[currentDay]) {
                // 没买就买，因为至少知道明天会涨
                if (purchaseDay == -1) {
                    purchaseDay = currentDay;
                } else {
                    // 已经买了啥也不做，等它涨，直到遇到第二天要跌，或者到了最后一天
                }
            } else { // 如果后一天要跌
                // 如果已经买了就卖出
                if (purchaseDay != -1) {
                    profit += (prices[currentDay] - prices[purchaseDay]);
                    purchaseDay = -1;
                } else {
                    // 没买就啥也不做，因为在跌，等要涨了再买
                }
            }

            // 如果是最后一天了，手上还有，则卖出
            if ((currentDay + 1 == prices.length - 1) && purchaseDay != -1) {
                profit += (prices[currentDay + 1] - prices[purchaseDay]);
                break;
            }
            currentDay++;
        }

        return profit;
    }


}
