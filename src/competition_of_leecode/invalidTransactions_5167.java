package competition_of_leecode;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/8/25 10:32
 */
public class invalidTransactions_5167 {

    public List<String> invalidTransactions(String[] transactions) {
        HashSet<Order> set = new HashSet<>();
        List<Order> orderList = new LinkedList<>();
        for (String string : transactions) {
            String[] strings = string.split(",");
            orderList.add(new Order(strings[0], Long.parseLong(strings[1]), Long.parseLong(strings[2]), strings[3]));
        }
        Collections.sort(orderList, (o1, o2) -> {
            int a = o1.name.compareTo(o2.name);
            if (a == 0) {
                return (int) (o1.time - o2.time);
            } else {
                return a;
            }
        });
        for (int i = 0; i < orderList.size(); i++) {
            Order o1 = orderList.get(i);
            if (o1.price > 1000) {
                set.add(o1);
            }
            for (int j = i; j < orderList.size() && orderList.get(j).name.equals(o1.name); j++) {
                Order order = orderList.get(j);
                if ((order.time - o1.time) <= 60 && !order.place.equals(o1.place)) {
                    set.add(o1);
                    set.add(order);
                }
            }
        }
        List<String> list = new LinkedList<>();
        for (Order order : set) {
            list.add(order.toString());
        }
        return list;
    }

    static class Order {
        String name;
        long time;
        long price;
        String place;
        @Override
        public String toString() {
            return name + "," + time + "," + price + "," + place;
        }
        public Order(String name, long time, long price, String place) {
            this.name = name;
            this.time = time;
            this.price = price;
            this.place = place;
        }
    }
}
