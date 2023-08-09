
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
def findFromEnd(head: ListNode, k: int) -> ListNode:
    p1 = head
    for i in range(k):
        p1=p1.next
    p2=head
    while p1:
        p2=p2.next
        p1=p1.next
    return p2
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        # 虚拟头结点
        dummy = ListNode(-1)
        dummy.next = head
        # 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        x = findFromEnd(dummy, n + 1)
        # 删掉倒数第 n 个节点
        x.next = x.next.next
        return dummy.next
# leetcode submit region end(Prohibit modification and deletion)
