package question_by_kotlin

class Solution {

    /*
    * 方法一：O（n*n）超时
    * */

    fun minWindow(s: String, t: String): String {
        var tMap = HashMap<Char, Int>()
        var sMap = HashMap<Char, Int>()
        t.forEach { tMap[it] = tMap.getOrDefault(it, 0) + 1 }
        var min = Int.MAX_VALUE
        var result = ""
        for (i in s.indices) {
            sMap.clear()
            for (j in i downTo 0) {
                if (!tMap.containsKey(s[j])) {
                    continue
                } else {
                    if (sMap.containsKey(s[j])) {
                        if (sMap[s[j]] != tMap[s[j]]) {
                            sMap[s[j]] = sMap[s[j]]!! + 1
                        }
                    } else {
                        sMap[s[j]] = 1
                    }
                }
                if (tMap.equals(sMap)) {
                    if (min > i - j + 1) {
                        min = Math.min(min, i - j + 1)
                        result = s.substring(j, i + 1)
                    }
                    break
                }
            }
        }
        return result
    }

    /*
    * 方法二：理论上是O(N)
    * 因为t串字符个数最多是26个，为常数
    * 最差情况 O(2*N*26)
    * */

    fun minWindow2(s: String, t: String): String {
        var tMap = HashMap<Char, Int>()
        for (ch in t) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1)
        }
        var left = 0
        var right = -1
        var sMap = HashMap<Char, Int>()
        var min = Int.MAX_VALUE
        var result = ""
        while (++right < s.length) {
            var ch = s[right]
            if (tMap.containsKey(ch)) {
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1)
            }
            while (left <= right && isEquals(sMap, tMap)) {
                var ch2 = s[left]
                if (right - left + 1 < min) {
                    min = right - left + 1
                    result = s.substring(left, right + 1)
                }
                if (sMap.containsKey(ch2)) {
                    sMap.put(ch2, sMap.get(ch2)!! - 1)
                }
                left++
            }
        }
        return result
    }

    private fun isEquals(sMap: java.util.HashMap<Char, Int>, tMap: java.util.HashMap<Char, Int>): Boolean {
        tMap.forEach {
            if (!sMap.containsKey(it.key)) {
                return false
            }
            if (sMap.get(it.key)!! < it.value) {
                return false
            }
        }
        return true
    }
}
