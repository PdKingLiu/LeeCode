package question;

/**
 * @author liupeidong
 * Created on 2019/9/29 9:47
 */
public class Question_69_mySqrt {

    /*实现 int sqrt(int x) 函数。

        计算并返回 x 的平方根，其中 x 是非负整数。

        由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

        示例 1:

        输入: 4
        输出: 2
        示例 2:

        输入: 8
        输出: 2
        说明: 8 的平方根是 2.82842...,
             由于返回类型是整数，小数部分将被舍去。 */

    /*
    * 先二分获得近似值
    * 最后判断是大了还是刚好
    * */

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long left = 0;
        long right = x / 2 + 1;
        long middle = 0;
        while (left <= right) {
            middle = (left + right + 1) / 2;
            long t = middle * middle;
            if (t > x) {
                right = middle - 1;
            } else if (t == x) {
                break;
            } else {
                left = middle + 1;
            }
        }
        if (middle * middle > x) {
            return (int) (middle - 1);
        } else {
            return (int) middle;
        }
    }
}
