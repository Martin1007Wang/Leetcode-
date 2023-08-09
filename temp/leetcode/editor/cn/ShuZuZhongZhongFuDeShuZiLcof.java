//找出数组中重复的数字。 
//
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
//请找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
//
// Related Topics数组 | 哈希表 | 排序 
//
// 👍 1185, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.ArrayList;
import java.util.List;

public class ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            //遍历数组，创建一个新的数组，将第一次出现的加入新数组，重复出现的返回，由于是任意一个，返回第一个
            List<Integer> a = new ArrayList<Integer>();
            for (int i=0;i<nums.length;i++){
                if (a.contains(nums[i])){
                    return nums[i];
                }else{
                    a.add(nums[i]);
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}