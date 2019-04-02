package question;

/**
 * @author liupeidong
 * Created on 2019/4/2 9:27
 */
public class Question_7_IntReversal {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        String num = String.valueOf(x);
        StringBuilder center = new StringBuilder();
        if (x < 0) {
            center.append(num, 1, num.length());
            center = center.reverse();
            long end = Long.parseLong(center.toString());
            if (end >= (long) Integer.MAX_VALUE || end <= (long) Integer.MIN_VALUE) {
                return 0;
            } else {
                return ((int) end) * -1;
            }
        } else if (x == 0) {
            return 0;
        } else {
            center.append(num);
            center = center.reverse();
            long end = Long.parseLong(center.toString());
            if (end >= (long) Integer.MAX_VALUE || end <= (long) Integer.MIN_VALUE) {
                return 0;
            } else {
                return (int) end;
            }
        }
    }
}
