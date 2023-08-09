
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        dummy=ListNode(-1)
        slow=head
        dummy.next=slow
        fast=head.next
        while fast is not None:
            if slow.val!=fast.val:
                slow=slow.next
                slow.val=fast.val
            fast=fast.next
        slow.next=None#断开与后面的链接
        return dummy.next
# leetcode submit region end(Prohibit modification and deletion)
