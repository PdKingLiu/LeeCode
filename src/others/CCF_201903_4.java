package others;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liupeidong
 * Created on 2019/9/13 17:43
 */
public class CCF_201903_4 {

    /*  CCF
        试题编号：	201903-4
        试题名称：	消息传递接口
        时间限制：	1.0s
        内存限制：	512.0MB */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fenshu = scanner.nextInt();
        int jincheng = scanner.nextInt();
        scanner.nextLine();
        HashMap<Integer, Deque<String>> hashMap = new HashMap<>(fenshu + 10);
        for (int i = 0; i < fenshu; i++) {
            hashMap.clear();
            for (int j = 0; j < jincheng; j++) {
                String[] strings = scanner.nextLine().split(" ");
                Deque<String> deque = new LinkedList<>();
                for (int k = strings.length - 1; k >= 0; k--) {
                    deque.push(strings[k]);
                }
                hashMap.put(j, deque);
            }
            while (true) {
                boolean isContiue = true;
                for (int j = 0; j < hashMap.size(); j++) {
                    Deque<String> deque = hashMap.get(j);
                    if (deque.isEmpty()) {
                        continue;
                    }
                    String s = deque.peek();
                    char c = s.charAt(0);
                    String c2 = s.substring(1);
                    if (c == 'S') {
                        Deque<String> deque1 = hashMap.get(Integer.parseInt(c2));
                        if (deque1.isEmpty()) {
                            continue;
                        }
                        String s1 = deque1.peek();
                        if (s1.equals("R" + j)) {
                            j--;
                            isContiue = false;
                            deque1.pop();
                            deque.pop();
                        }
                    }
                }
                if (isContiue) {
                    break;
                }
            }
            int flag = 0;
            for (Integer a : hashMap.keySet()) {
                if (!hashMap.get(a).isEmpty()) {
                    flag = 1;
                }
            }
            System.out.println(flag);
        }
    }
}
