package medium.greedy;

/**
 * 134.
 *
 * <p>超时
 *
 * @author by liangzj
 * @since 2022/10/22 8:31
 */
public class CanCompleteCircuitMain {
    public static void main(String[] args) {
        //
        int[] gas = new int[] {2, 3, 4};
        int[] cost = new int[] {3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));

        int[] gas1 = new int[] {1, 2, 3, 4, 5};
        int[] cost1 = new int[] {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas1, cost1));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int cur = 0; cur < gas.length; cur++) {
            if (toNext(cur, cur, gas[cur], gas, cost)) {
                return cur;
            }
        }

        return -1;
    }

    private static boolean toNext(int end, int cur, int curGas, int[] gas, int[] cost) {
        if ((cur + 1) % gas.length == end && curGas >= cost[cur]) {
            return true;
        }

        if (curGas < cost[cur]) {
            return false;
        }

        int next = (cur + 1) % gas.length;
        return toNext(end, next, curGas - cost[cur] + gas[next], gas, cost);
    }
}
