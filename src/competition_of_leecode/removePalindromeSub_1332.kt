package question_by_kotlin


/*
* 结果只三种情况：1、2、0
* 1：本身就是回文串
* 2：本身不是回文串，但是可以分成两个只含a或只含b的子序列
* 0：空串
* */
fun removePalindromeSub(s: String): Int {
    return when (s) {
        "" -> {
            0
        }
        StringBuffer(s).reverse().toString() -> {
            1
        }
        else -> {
            2
        }
    }
}