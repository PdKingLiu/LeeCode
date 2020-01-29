package question_by_kotlin

import java.util.*

fun filterRestaurants(
    restaurants: Array<IntArray>,
    veganFriendly: Int,
    maxPrice: Int,
    maxDistance: Int
): List<Int>? {
    class Item(var id: Int, var rate: Int)

    /*
    * 常规做法
    * */
    val list: MutableList<Item> = ArrayList()
    for (arr in restaurants) {
        if (veganFriendly == 1 && arr[2] == 0) {
            continue
        }
        if (arr[3] > maxPrice || arr[4] > maxDistance) {
            continue
        }
        list.add(Item(arr[0], arr[1]))
    }
    list.sortWith(Comparator { o1, o2 ->
        if (o2.rate == o1.rate) {
            o2.id - o1.id
        } else {
            o2.rate - o1.rate
        }
    })
    val list1: MutableList<Int> = ArrayList()
    for (item in list) {
        list1.add(item.id)
    }
    return list1
}
