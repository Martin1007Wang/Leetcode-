//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
//
// Related Topics贪心 | 数组 | 动态规划 | 排序 
//
// 👍 257, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        Solution solution = new GreatestSumDivisibleByThree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumDivThree(int[] nums) {
            //计算数组的总和和3取模，如果余数为2，减去一个最小的和3取模为2或两个最小的和3取模为1；
            //如果余数为1，减去一个和3取模为1或者减去两个和3取模为2；
            Arrays.sort(nums);
            int sum = 0;
            List<Integer> one = new ArrayList<Integer>();
            List<Integer> two = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 3 == 1) {
                    one.add(nums[i]);
                } else if (nums[i] % 3 == 2) {
                    two.add(nums[i]);
                }
                sum += nums[i];
            }
            int c = sum % 3;
            int temp1 = 0;
            int temp2 = 0;
            if (c == 0) {
                return sum;
            } else if (c == 1) {
                if (one.size() == 0 && two.size() < 2) {
                    return 0;
                }
                if (one.size() > 0) {
                    temp1 = sum - one.get(0);
                }
                if (two.size() > 1) {
                    temp2 = sum - two.get(0) - two.get(1);
                }
            } else {
                if (two.size() == 0 && (one.size() < 2)) {
                    return 0;
                }
                if (two.size() > 0) {
                    temp1 = sum - two.get(0);
                }
                if (one.size() > 1) {
                    temp2 = sum - one.get(0) - one.get(1);
                }
            }
            return temp1 > temp2 ? temp1 : temp2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}