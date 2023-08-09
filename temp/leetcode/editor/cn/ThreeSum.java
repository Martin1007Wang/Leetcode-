//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 6053, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            return nSumTarget(nums, 3, 0, 0);
        }

        /* 注意：调用这个函数之前一定要先给 nums 排序 */
        // n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
        public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
            int size = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (n < 2 || size < n) return null;
            if (n == 2) {
                int lo = start, hi = size - 1;
                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    int left = nums[lo], right = nums[hi];
                    if (sum < target) {
                        while (lo < hi && nums[lo] == left) lo++;
                    } else if (sum > target) {
                        while (lo < hi && nums[hi] == right) hi--;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(left, right)));
                        while (lo < hi && nums[lo] == left) lo++;
                        while (lo < hi && nums[hi] == left) hi--;
                    }
                }
            } else {
                for (int i = start; i < size; i++) {
                    List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                    for (List<Integer> arr : sub) {
                        List<Integer> narr = new ArrayList<>();
                        narr.add(nums[i]);
                        for (Integer each : arr) narr.add(each);
                        res.add(narr);
                    }
                    while (i < size - 1 && nums[i] == nums[i + 1]) i++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}