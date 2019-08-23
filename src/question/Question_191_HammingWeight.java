package question;

/**
 * @author liupeidong
 * Created on 2019/4/21 22:38
 */
public class Question_191_HammingWeight {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    /*
    1.末尾为0
    00000000000000001000000000001000

    减1后 最后一位1变0 后面的0变1

    00000000000000001000000000000111

            &操作后末尾的1消除

    2.末尾为1
    00000000000000001000000000001011

    减1操作后 直接去掉末尾的1

    */
}
