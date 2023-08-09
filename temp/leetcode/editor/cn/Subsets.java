//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 2073, 👎 0 
//
//
//
//

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> track = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backTrack(nums, 0);
            return res;
        }

        public void backTrack(int[] nums, int start) {
            //前序位置：
            res.add(new LinkedList<>(track));
            //当前的所有可选择的路径
            for (int i = start; i < nums.length; i++) {
                //加入选择到路径(做选择)
                track.add(nums[i]);
                //向下遍历，用start避免重复
                backTrack(nums, i + 1);
                //撤销选择，回溯
                track.remove(track.size() - 1);
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}