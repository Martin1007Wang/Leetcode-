import heapq

# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> ListNode:
        import heapq
        # 把lists所有数据入heapq
        heap = []
        for list_1 in lists:
            while list_1:
                heapq.heappush(heap, list_1.val)
                list_1 = list_1.next
        # 从heapq中逐个取数据构建有序链表
        curr_list = ListNode(None)
        head = curr_list
        while heap:
            # 逐个取最小的数据
            temp_node = ListNode(heapq.heappop(heap), None)
            curr_list.next = temp_node
            curr_list = curr_list.next
        return head.next
# leetcode submit region end(Prohibit modification and deletion)
