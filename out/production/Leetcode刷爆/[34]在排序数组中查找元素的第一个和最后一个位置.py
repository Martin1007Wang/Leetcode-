
# leetcode submit region begin(Prohibit modification and deletion)

def searchLeftBound(nums:List[int], target:int)->int:
    left,right=0,len(nums)-1
    while(left<=right):
        mid=left+(right-left)//2
        if nums[mid]==target:
            right=mid-1
        elif nums[mid]>target:
            right=mid-1
        else:
            left=mid+1
    if left==len(nums):return -1
    return left if nums[left]==target else -1

def searchRightBound(nums:List[int],target:int)->int:
    left,right=0,len(nums)-1
    while(left<=right):
        mid = left+(right-left)//2
        if nums[mid]==target:
            left=mid+1
        elif nums[mid]>target:
            right=mid-1
        else:
            left=mid+1
    if left-1<0: return -1
    return left-1 if nums[left-1]==target else -1
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        leftBound=searchLeftBound(nums,target)
        rightBound=searchRightBound(nums,target)
        return [leftBound,rightBound]
# leetcode submit region end(Prohibit modification and deletion)
