//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
//
// Related Topics哈希表 | 数学 | 动态规划 | 堆（优先队列） 
//
// 👍 1083, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            // 三个指向有序链表头结点的指针
            int p2 = 1, p3 = 1, p5 = 1;
            //三个有序链表的头节点的值
            int product2 = 1, product3 = 1, product5 = 1;
            //最终合并的有序链表（结果链表）
            int[] ugly = new int[n + 1];
            //结果链表上的指针
            int p = 1;
            while (p <= n) {
                int min = Math.min(Math.min(product2, product3), product5);
                ugly[p] = min;
                p++;
                if (min == product2) {
                    product2 = 2 * ugly[p2];
                    p2++;
                }
                if (min == product3) {
                    product3 = 3 * ugly[p3];
                    p3++;
                }
                if (min == product5) {
                    product5 = 5 * ugly[p5];
                    p5++;
                }
            }
            return ugly[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}