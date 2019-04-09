package question;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author liupeidong
 * Created on 2019/4/9 23:14
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("liupeidong", "刘沛栋");
        map.put("yangjiahao", "杨佳豪");
        map.put("wangshun", "王舜");
        map.put("wangaiji", "王埃及");
        map.put("tianweikang", "田伟康");
        map.put("wangzepeng", "王泽鹏");
        map.put("maierdan", "买尔旦");
        map.put("lixinyi", "李昕怡");
        map.put("hujianwen", "胡鉴文");
        map.put("wangshuai", "王帅");
        map.put("chentengchuang", "陈腾创");
        map.put("songzebing", "宋泽斌");
        map.put("xuwenting", "许文婷");
        map.put("mayixin", "马翌新");
        map.put("shiyongxue", "史永雪");
        map.put("zhangruiting", "张瑞婷");
        map.put("zhourongyao", "周荣耀");
        map.put("genazhen", "葛娜珍");
        String[] strings = new String[]{"liupeidong", "yangjiahao", "wangshun",
                "wangaiji", "tianweikang", "wangzepeng", "maierdan", "lixinyi", "hujianwen"};
        String[] strings2 = new String[]{"wangshuai", "chentengchuang", "songzebing", "xuwenting",
                "mayixin", "shiyongxue", "zhangruiting", "zhourongyao", "genazhen"};
        Arrays.sort(strings);
        Arrays.sort(strings2);
        for (String s : strings) {
            System.out.print(map.get(s)+" ");
        }
        System.out.println();
        for (String s : strings2) {
            System.out.print(map.get(s)+" ");
        }
    }
}
