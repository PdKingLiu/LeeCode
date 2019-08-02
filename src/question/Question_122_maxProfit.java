package question;

/**
 * @author liupeidong
 * Created on 2019/8/2 19:49
 */
public class Question_122_maxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int saraly = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                saraly += prices[i] - prices[i - 1];
            }
        }
        return saraly;
    }
}
