package question;

/**
 * @author liupeidong
 * Created on 2019/4/9 22:28
 */
public class Question_5_LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj"));
    }

    public static String longestPalindrome(String s) {
        String s1 = new StringBuffer(s).reverse().toString();
        String s3 = "";
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String s2 = s.substring(i, j + 1);
                if (s1.contains(s2)) {
                    if (s2.length() == 1 && max <= 1) {
                        s3 = s2;
                        max = 1;
                        continue;
                    }
                    if (i == (s.length() - s1.indexOf(s2) - s2.length())) {
                        if (s2.length() > max) {
                            max = s2.length();
                            s3 = s2;
                        }
                    }
                }
            }
        }
        return s3;
    }

    public static String longestPalindrome2(String s) {
        String s1 = new StringBuffer(s).reverse().toString();
        int start = 0, end = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            
        }
    }
}
