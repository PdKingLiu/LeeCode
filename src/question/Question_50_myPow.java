package question;

/**
 * @author liupeidong
 * Created on 2019/8/7 20:21
 */
public class Question_50_myPow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            return 1 / (Pow(x, Integer.MAX_VALUE) * x);
        } else {
            double result = Pow(x, Math.abs(n));
            return n > 0 ? result : 1 / result;
        }
    }
    private double Pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        int d = n / 2;
        double result = Pow(x, d);
        result = result * result;
        if (n % 2 == 1) {
            result = result * x;
        }
        return result;
    }
}
