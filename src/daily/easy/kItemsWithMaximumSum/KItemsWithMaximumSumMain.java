package daily.easy.kItemsWithMaximumSum;
/**
 * 2600. K 件物品的最大和
 *
 * @since 2023/7/5 21:01
 * @author by liangzj
 */
public class KItemsWithMaximumSumMain {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k == 0) return 0;
        if (numOnes >= k) return k;

        k = k - numOnes;

        if (numZeros >= k) return numOnes;
        k = k - numZeros;

        return numOnes - k;
    }
}
