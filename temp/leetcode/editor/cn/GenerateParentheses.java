//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 3270, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            if (n == 0) {
                return res;
            }
            backTrack(res, new StringBuilder(), n, n);
            return res;
        }

        public void backTrack(List<String> res, StringBuilder track, int left, int right) {
            if (left == 0 && right == 0) {
                res.add(track.toString());
                return;
            }
            if (left > right) {
                return;
            }
            //左括号没满，可以添加一个左括号
            if (left > 0) {
                //向下一层
                backTrack(res, track.append("("), left - 1, right);
                //撤销选择，回溯
                track.deleteCharAt(track.length() - 1);

            }
            if (right > 0) {
                backTrack(res, track.append(")"), left, right - 1);
                track.deleteCharAt(track.length() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}