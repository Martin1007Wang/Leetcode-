
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        length=len(nums)
        left=0
        right=length-1
        while(left<=right):
            mid=left+(right-left)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]<target:
                left=mid+1
            else:
                right=mid-1
        return -1

# leetcode submit region end(Prohibit modification and deletion)
