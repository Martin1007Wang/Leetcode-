//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 1620, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return nSumTarget(nums, 4, 0, target);
        }

        public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
            int size = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (n < 2 || size < n) return res;
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