
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        fast,slow=0,0
        count=0
        while fast<len(nums):
            if nums[fast]!=0:
                nums[slow]=nums[fast]
                slow=slow+1
                count=count+1
            fast=fast+1
        for i in range(slow,len(nums)):
            nums[i]=0
# leetcode submit region end(Prohibit modification and deletion)
