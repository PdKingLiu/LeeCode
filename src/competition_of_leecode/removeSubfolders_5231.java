package competition_of_leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liupeidong
 * Created on 2019/10/20 12:10
 */
public class removeSubfolders_5231 {

    /*5231. 删除子文件夹 显示英文描述

        用户通过次数454
        用户尝试次数668
        通过次数458
        提交次数1420
        题目难度Medium

        你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。

        我们这样定义「子文件夹」：

        如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的子文件夹。
        文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：

        / 后跟一个或者多个小写英文字母。
        例如，/leetcode 和 /leetcode/problems 都是有效的路径，而空字符串和 / 不是。

        示例 1：

        输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
        输出：["/a","/c/d","/c/f"]
        解释："/a/b/" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
        示例 2：

        输入：folder = ["/a","/a/b/c","/a/b/d"]
        输出：["/a"]
        解释：文件夹 "/a/b/c" 和 "/a/b/d/" 都会被删除，因为它们都是 "/a" 的子文件夹。
        示例 3：

        输入：folder = ["/a/b/c","/a/b/d","/a/b/ca"]
        输出：["/a/b/c","/a/b/ca","/a/b/d"]

        提示：

        1 <= folder.length <= 4 * 10^4
        2 <= folder[i].length <= 100
        folder[i] 只包含小写字母和 /
        folder[i] 总是以字符 / 起始
        每个文件夹名都是唯一的*/

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        for (int i = 0; i < folder.length; i++) {
            String s = folder[i];
            if (s.equals("")) {
                continue;
            }
            s = s + "/";
            for (int j = 0; j < folder.length; j++) {
                if (j != i && !folder[j].equals("")) {
                    if (folder[j].contains(s)) {
                        folder[j] = "";
                    }
                }
            }
        }
        List<String> list = new ArrayList<>(folder.length + 10);
        for (String s : folder) {
            if (!s.equals("")) {
                list.add(s);
            }
        }
        return list;
    }

}
