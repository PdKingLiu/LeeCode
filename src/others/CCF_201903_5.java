package others;

import java.util.*;

/**
 * @author liupeidong
 * Created on 2019/9/13 22:17
 */
public class CCF_201903_5 {

    /*  试题编号：	201903-5
        试题名称：	317号子任务
        时间限制：	1.0s
        内存限制：	512.0MB     */

    static class Point {
        int point;
        int kind;
        HashMap<Point, Integer> map;

        public Point(int point, int kind, HashMap<Point, Integer> map) {
            this.point = point;
            this.kind = kind;
            this.map = map;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        int[] arr = new int[n];
        HashMap<Integer, Point> hashMap = new HashMap<>(n + 10);
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            Point point = new Point(i, arr[i], new HashMap<>(1000));
            hashMap.put(i, point);
        }
        for (int i = 0; i < m; i++) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            int weight = scanner.nextInt();
            hashMap.get(a1 - 1).map.put(hashMap.get(a2 - 1), weight);
            hashMap.get(a2 - 1).map.put(hashMap.get(a1 - 1), weight);
        }
        long l = System.currentTimeMillis();
        for (Integer aInte : hashMap.keySet()) {
            HashMap<Point,Integer> set = new HashMap<>(1000);
            List<Integer> list = new ArrayList<>(1000);
            boolean[] isUsed = new boolean[n];
            isUsed[aInte] = true;
            Integer len = 0;
            DFS(hashMap.get(aInte), set, isUsed, len);
            int min = 0;
            for (Point p : set.keySet()) {
                list.add(set.get(p));
            }
            Collections.sort(list);
            int end = list.size() < k ? list.size() : k;
            for (int i = 0; i < end; i++) {
                min += list.get(i);
            }
            stringBuffer.append(min).append("\n");
        }
        System.out.println(stringBuffer.toString());
        System.out.println(System.currentTimeMillis() - l);
    }

    private static void DFS(Point point, HashMap<Point,Integer> set, boolean[] isUsed, Integer len) {
        if (point.kind == 1) {
            if (!set.containsKey(point)) {
                set.put(point, len);
            } else {
                int v = set.get(point);
                if (v > len) {
                    set.put(point, len);
                }
            }
        }
        if (point.map == null || point.map.size() == 0) {
            return;
        }
        for (Point poi : point.map.keySet()) {
            if (!isUsed[poi.point] && poi != point) {
                len += point.map.get(poi);
                isUsed[poi.point] = true;
                DFS(poi, set, isUsed, len);
                isUsed[poi.point] = false;
                len -= point.map.get(poi);
            }
        }
    }

}
