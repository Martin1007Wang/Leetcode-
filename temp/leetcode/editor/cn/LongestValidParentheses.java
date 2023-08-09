//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics栈 | 字符串 | 动态规划 
//
// 👍 2292, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.Arrays;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length();
            if (n == 0) return 0;
            int[] dp = new int[n];
            dp[0] = 0;
            int maxVal = 0;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = 2;
                        if (i - 2 >= 0) {
                            dp[i] = dp[i - 2] + dp[i];
                        }
                    } else if (dp[i - 1] > 0) {
                        if ((i - dp[i - 1] - 1) >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                            dp[i] = dp[i - 1] + 2;
                            if ((i - dp[i - 1] - 2) >= 0) {
                                dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                            }
                        }
                    }
                }
            }
            maxVal = Arrays.stream(dp).max().getAsInt();
            return maxVal;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}