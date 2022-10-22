package medium.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 01背包
 *
 * <p>物品i，重wi，价值vi，背包承重mw，怎么装价值最高
 *
 * @author by liangzj
 * @since 2022/10/16 22:43
 */
public class ZeroOneKnapsackMain {

    public static void main(String[] args) {
        //
        List<Goods> allGoods = new ArrayList<>();
        allGoods.add(new Goods(0, 100, 20));
        allGoods.add(new Goods(1, 14, 18));
        allGoods.add(new Goods(2, 10, 15));
        allGoods.add(new Goods(3, 1, 25));

        List<Integer> max = maxValue(allGoods, 116);

        System.out.println(max);
    }

    private static List<Integer> maxValue(List<Goods> allGoods, int maxWeight) {
        List<List<Goods>> allKnapsack = new ArrayList<>();

        for (int i = 0; i < allGoods.size() - 1; i++) {
            if (allGoods.get(i).weight == maxWeight) {
                allKnapsack.add(Collections.singletonList(allGoods.get(i)));
                continue;
            }
            if (allGoods.get(i).weight > maxWeight) {
                continue;
            }

            if (allGoods.get(i).weight < maxWeight) {
                allKnapsack.add(Collections.singletonList(allGoods.get(i)));
            }

            for (int j = i + 1; j < allGoods.size(); j++) {
                int curWeight = allGoods.get(i).weight;
                if (curWeight + allGoods.get(j).weight > maxWeight) {
                    continue;
                }

                List<Goods> knapsack = new ArrayList<>();
                knapsack.add(allGoods.get(i));

                // 获取所有组合
                addMaxWeight(j, allGoods.get(i).weight, allKnapsack, knapsack, allGoods, maxWeight);
            }
        }

        // 获取所有组合中价值最高的
        List<List<Goods>> sorted =
                allKnapsack.stream()
                        .sorted(
                                Comparator.comparing(
                                        ls ->
                                                ls.stream()
                                                        .map(goods -> goods.weight)
                                                        .collect(
                                                                Collectors.summingInt(
                                                                        Integer::intValue))))
                        .collect(Collectors.toList());

        return sorted.get(sorted.size() - 1).stream()
                .map(goods -> goods.code)
                .collect(Collectors.toList());
    }

    private static void addMaxWeight(
            int cur,
            int curWeight,
            List<List<Goods>> allKnapsack,
            List<Goods> knapsack,
            List<Goods> allGoods,
            int maxWeight) {
        // 到最后一个商品了，或重量到8了，判断要不要加入背包
        if (cur == allGoods.size() - 1 || curWeight == maxWeight) {
            if (knapsack != null && knapsack.size() > 0) {
                if (allGoods.get(cur).weight + curWeight <= maxWeight) {
                    knapsack.add(allGoods.get(cur));
                }
                // 放到结果集中
                allKnapsack.add(knapsack);
            }
            return;
        }

        // 如果不超重，就放到背包里
        if (curWeight + allGoods.get(cur).weight <= maxWeight) {
            if (knapsack == null) {
                knapsack = new ArrayList<>();
            }
            knapsack.add(allGoods.get(cur));
            // 继续判断下一个物品要不要放
            addMaxWeight(
                    ++cur,
                    curWeight + allGoods.get(cur).weight,
                    allKnapsack,
                    knapsack,
                    allGoods,
                    maxWeight);
        } else {
            addMaxWeight(++cur, curWeight, allKnapsack, knapsack, allGoods, maxWeight);
        }
    }

    private static class Goods {
        public int code;
        public int weight;
        public int value;

        public Goods(int code, int weight, int value) {
            this.code = code;
            this.weight = weight;
            this.value = value;
        }

        public Goods() {}
    }
}
