//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 430, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

public class CongWeiDaoTouDaYinLianBiaoLcof {

    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 记录链表长度
        int len = 0;
        // 结果数组
        int[] res;
        // 结果数组中的指针
        int p = 0;

        public int[] reversePrint(ListNode head) {
            tranverse(head);
            return res;
        }

        public void tranverse(ListNode head) {
            if (head == null) {
                // 到达链表尾部，此时知道了链表的总长度 创建结果数组
                res = new int[len];
                return;
            }
            len++;
            tranverse(head.next);
            res[p] = head.val;
            p++;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}