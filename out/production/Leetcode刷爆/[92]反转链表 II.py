
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

successor=None#记录后继节点
class Solution:
    def reverseN(self, head:ListNode, n:int)->ListNode:
        global successor
        if n==1:
            successor=head.next
            return head
        last=self.reverseN(head.next,n-1)
        head.next.next=head
        head.next=successor
        return last

    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if left==1:
            return self.reverseN(head,right)
        head.next=self.reverseBetween(head.next,left-1,right-1)
        return head

# leetcode submit region end(Prohibit modification and deletion)
