//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics栈 | 数组 | 双指针 | 动态规划 | 单调栈 
//
// 👍 4417, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int res = 0;
            if (height.length == 0) {
                return 0;
            }
            int[] leftMax = new int[height.length];
            leftMax[0] = height[0];
            int[] rightMax = new int[height.length];
            rightMax[rightMax.length - 1] = height[height.length - 1];
            for (int i = 1; i < height.length - 1; i++) {
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
                rightMax[rightMax.length - 1 - i] = Math.max(height[rightMax.length - 1 - i], rightMax[rightMax.length - i]);
            }
            for (int i = 1; i < height.length - 1; i++) res += Math.min(leftMax[i], rightMax[i]) - height[i];
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}