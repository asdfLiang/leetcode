package medium.greedy;

/**
 * 134.
 *
 * <p>超时
 *
 * @author by liangzj
 * @since 2022/10/22 8:31
 */
public class CanCompleteCircuitV2Main {
    public static void main(String[] args) {

        int[] gas = new int[] {2, 3, 4};
        int[] cost = new int[] {3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));

        int[] gas1 = new int[] {1, 2, 3, 4, 5};
        int[] cost1 = new int[] {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas1, cost1));

        int[] gas2 = new int[] {3, 3, 4};
        int[] cost2 = new int[] {3, 4, 4};
        System.out.println(canCompleteCircuit(gas2, cost2));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int step;
        for (int start = 0; start < len; start++) {
            step = start;
            int curGas = gas[step];
            int curCost = cost[step];

            while (curGas >= curCost) {
                step = (step + 1) % len;
                if (step == start) {
                    break;
                }

                curGas += gas[step];
                curCost += cost[step];
            }

            if (step == start && curGas >= curCost) {
                return start;
            } else if (step > start) {
                start = step;
            }
        }

        return -1;
    }
}
