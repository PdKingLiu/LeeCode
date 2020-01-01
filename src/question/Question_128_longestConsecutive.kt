package question_by_kotlin

fun longestConsecutive(nums: IntArray): Int {
    var set: HashSet<Int> = HashSet(nums.toSet())
    var max: Int = 0
    set.forEach {
        if (!set.contains(it - 1)) {
            var numTem = it
            var maxTem = 1
            while (set.contains(numTem + 1)) {
                maxTem++
                numTem++
            }
            max = Math.max(max, maxTem)
        }
    }
    return max
}