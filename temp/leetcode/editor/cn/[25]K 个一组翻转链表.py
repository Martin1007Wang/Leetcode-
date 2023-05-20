
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverse(self,left:ListNode,right:ListNode)->ListNode:
        pre,cur=None,left
        while cur != right:
            nxt=cur.next
            cur.next=pre
            pre=cur
            cur=nxt
        return pre
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None:
            return None
        a,b = head,head
        for i in range(k):
            if not b:#如果不足k个，则不用反转，属于base case
                return head
            b=b.next
        new_head=self.reverse(a,b)
        #递归下一次反转的链表，并链接
        a.next=self.reverseKGroup(b,k)
        return new_head
# leetcode submit region end(Prohibit modification and deletion)
