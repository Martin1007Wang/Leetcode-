//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
//
// Related Topics栈 | 链表 | 数学 
//
// 👍 634, 👎 0 
//
//
//
//

import java.util.Stack;

public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> st1 = new Stack<>();
            Stack<Integer> st2 = new Stack<>();
            Stack<Integer> sta = new Stack<>();
            while (l1 != null) {
                st1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                st2.push(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            while (!st1.isEmpty() || !st2.isEmpty() || carry != 0) {
                int x = st1.isEmpty() ? 0 : st1.pop();
                int y = st2.isEmpty() ? 0 : st2.pop();
                int cur = x + y + carry;
                carry = cur / 10;
                cur = cur % 10;
                sta.push(cur);
            }
            while (!sta.isEmpty()){
                p.next=new ListNode(sta.pop());
                p=p.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}