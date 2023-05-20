
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        slow,fast=0,1
        length=len(nums)
        while fast<length:
            if nums[slow]!=nums[fast]:
                slow = slow + 1
                nums[slow]=nums[fast]
            fast=fast+1
        return slow+1
# leetcode submit region end(Prohibit modification and deletion)
