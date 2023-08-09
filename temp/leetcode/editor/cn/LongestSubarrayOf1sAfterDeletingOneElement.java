//给你一个二进制数组 nums ，你需要从中删掉一个元素。 
//
// 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。 
//
// 如果不存在这样的子数组，请返回 0 。 
//
// 
//
// 提示 1： 
//
// 
//输入：nums = [1,1,0,1]
//输出：3
//解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1,1,0,1,1,0,1]
//输出：5
//解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1]
//输出：2
//解释：你必须要删除一个元素。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 要么是 0 要么是 1 。 
// 
//
// Related Topics数组 | 动态规划 | 滑动窗口 
//
// 👍 87, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        Solution solution = new LongestSubarrayOf1sAfterDeletingOneElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums) {
            int len = nums.length;
            // dp[i][0] 以 nums[i] 结尾且含有一个 0 的最长连续子数组长度
            // dp[i][1] 以 nums[i] 结尾且全为 1 的最长连续子数组长度
            int[][] dp = new int[len][2];
            dp[0][0] = (nums[0] == 0) ? 1 : 0;
            dp[0][1] = nums[0];
            int maxLen = 0;
            for (int i = 1; i < len; i++) {
                if (nums[i] == 0) {
                    dp[i][0] = dp[i - 1][1] + 1;
                    dp[i][1] = 0;
                } else {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = dp[i - 1][1] + 1;
                }
                if (dp[i][0] > maxLen || dp[i][1] > maxLen) {
                    maxLen = Math.max(dp[i][0], dp[i][1]);
                }
            }
            return maxLen - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}