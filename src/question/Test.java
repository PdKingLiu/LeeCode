package question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/4/9 23:14
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bzgs = sc.nextInt();
        int bzrl = sc.nextInt();
        int[] ybili = new int[bzgs];
        int[] yrongliang = new int[bzgs];
        for (int i = 0; i < bzgs; i++) {
            ybili[i] = sc.nextInt();
        }
        for (int i = 0; i < bzgs; i++) {
            yrongliang[i] = sc.nextInt();
        }
        double tem[] = new double[bzgs];
        int flag = 0;
        int where = -1;
        for (int j = 1; ; j++) {
            double sum = 0;
            for (int i = 0; ; i++) {
                tem[i] += 0.0001 * ybili[i];
                if (tem[i] >= yrongliang[i]) {
                    where = i;
                }
                sum += tem[i];
            }
        }
    }
}
