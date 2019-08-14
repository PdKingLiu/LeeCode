package question;

/**
 * @author liupeidong
 * Created on 2019/8/14 11:19
 */
public class Question_75_sortColors {

    /*给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

        此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

        注意:
        不能使用代码库中的排序函数来解决这道题。

        示例:

        输入: [2,0,2,1,1,0]
        输出: [0,0,1,1,2,2]
        进阶：

        一个直观的解决方案是使用计数排序的两趟扫描算法。
        首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
        你能想出一个仅使用常数空间的一趟扫描算法吗？ */

    public static void sortColors(int[] nums) {
        int front = 0;
        int index1 = nums.length;
        int index2 = nums.length;
        while (front != nums.length && front < index1 && front < index2) {
            if (nums[front] == 2) {
                if (index1 >= index2) {
                    nums[front] = nums[index2 - 1];
                    nums[index2 - 1] = 2;
                    index2--;
                } else {
                    nums[front] = nums[index1 - 1];
                    nums[index1 - 1] = 1;
                    nums[index2 - 1] = 2;
                    index1--;
                    index2--;
                }
            } else if (nums[front] == 1) {
                if (index1 == nums.length) {
                    nums[front] = nums[index2 - 1];
                    nums[index2 - 1] = 1;
                    index1 = index2 - 1;
                } else {
                    nums[front] = nums[index1 - 1];
                    nums[index1 - 1] = 1;
                    index1--;
                }
            } else {
                front++;
            }
        }
    }
}
