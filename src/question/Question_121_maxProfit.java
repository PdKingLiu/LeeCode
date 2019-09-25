package question;

/**
 * @author liupeidong
 * Created on 2019/9/24 23:56
 */
public class Question_121_maxProfit {

    /*给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

        如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

        注意你不能在买入股票前卖出股票。

        示例 1:

        输入: [7,1,5,3,6,4]
        输出: 5
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
             注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
        示例 2:

        输入: [7,6,4,3,1]
        输出: 0
        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 */


    /*
    * 双重循环，每次从前面找值最小的股票
    * */

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxTem;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            maxTem = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxTem = Math.max(maxTem, prices[i] - prices[j]);
            }
            max = maxTem < 0 ? max : Math.max(max, maxTem);
        }
        return max;
    }

    /*
    * 一次循环，记录此点之前值最小的股票min
    * 若当前股票价比之前的小则更新min，否则比较当前股票-min和最大差值max
    * */

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }
            if (prices[i] - min > 0) {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}
