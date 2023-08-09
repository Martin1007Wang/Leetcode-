from typing import Optional


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        dummy1=ListNode(-1)
        dummy2=ListNode(-1)
        p1,p2=dummy1,dummy2
        p=head
        while p:
            if p.val<x:
                p1.next=p
                p1=p1.next
            elif p.val>=x:
                p2.next=p
                p2=p2.next
            # 断开原链表中的每个节点的 next 指针
            temp=p.next
            p.next=None
            p=temp
        p1.next=dummy2.next
        return dummy1.next


# leetcode submit region end(Prohibit modification and deletion)
