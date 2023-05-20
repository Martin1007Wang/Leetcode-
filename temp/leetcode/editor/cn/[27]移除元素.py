
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        length=len(nums)
        if length == 0:
            return 0
        slow=0
        fast=0
        while fast<length:
            if nums[fast]!=val:
                nums[slow]=nums[fast]
                slow=slow+1
            fast=fast+1
        return slow
# leetcode submit region end(Prohibit modification and deletion)
