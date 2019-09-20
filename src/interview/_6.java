import java.util.Scanner;
public class _6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int len = scanner.nextInt();
            String string = scanner.next();
            if (len == 11 && string.charAt(0) == '8') {
                System.out.println("YES");
                continue;
            }
            if (len < 11) {
                System.out.println("NO");
                continue;
            }
            int index = string.indexOf('8');
            if (index < 0) {
                System.out.println("NO");
            } else {
                int temLen = string.length() - index;
                if (temLen >= 11) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

}
