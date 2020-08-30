package question

import kotlin.math.max

/**
 * @author liupeidong
 * Created on 2020/8/31 1:00
 */
class Question_5500_getMaxLen {

    /**
    示例  1：

    输入：nums = [1,-2,-3,4]
    输出：4
    解释：数组本身乘积就是正数，值为 24 。
    示例 2：

    输入：nums = [0,1,-2,-3,-4]
    输出：3
    解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
    注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。*/

    fun getMaxLen(nums: IntArray): Int {
        var mul = 1
        var left = -1
        var right = -1
        var start = 0
        var max = 0
        for (i in nums.indices) {
            if (nums[i] == 0) {
                max = if (mul > 0) {
                    Math.max(max, i - start)
                } else {
                    if (right == -1) {
                        max(max(left - start, i - left - 1), max)
                    } else {
                        max(max(max(left - start, i - left - 1), max(right - start, i - right - 1)), max)
                    }
                }
                left = -1
                right = -1
                mul = 1
                start = i + 1
            } else {
                if (nums[i] < 0 && left == -1) {
                    left = i
                } else if (nums[i] < 0 && left != -1) {
                    right = i
                }
                mul = if (nums[i] > 0) {
                    mul
                } else {
                    mul * -1
                }
                max = if (mul > 0) {
                    Math.max(max, i - start + 1)
                } else {
                    if (right == -1) {
                        max(max(left - start, i - left), max)
                    } else {
                        max(max(max(left - start, i - left), max(right - start, i - right)), max)
                    }
                }
            }
        }
        return max
    }
}