from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __init__(self):
        self.res=[]
    #路径：记录在track中
    #可选的选择：记录在num中
    #已被选择：通过used数组来表示
    def backtrack(self, nums:List[int],track:List[int],used:List[bool]):
        #当nums中的元素全部在track中出现，即两个数组长度相等时，达到结束条件，开始回溯
        #将当前路径记录斤res中
        if len(nums)==len(track):
            self.res.append(track.copy())
            return
        #对未达到结束条件的情况，遍历nums数组，从中选择一个加入到track中，所选择的一定是track中之前没有的
        for i in range(len(nums)):
            if used[i]==True:continue #若nums[i]已被选择过，则跳过
            #对于未被选择的数，加入track，used标注为True
            track.append(nums[i])
            used[i]=True
            #完成后，进入下一层决策树
            self.backtrack(nums,track,used)

            #当结束条件达到,return以后，开始回溯,track
            #pop() 函数用于移除列表中的一个元素（默认最后一个元素），并且返回该元素的值。
            track.pop()
            used[i]=False

    def permute(self, nums: List[int]) -> List[List[int]]:
        #初始化track和used
        track=[]
        used=[False]*len(nums)
        #执行回溯backtrack
        self.backtrack(nums,track,used)
        return self.res
# leetcode submit region end(Prohibit modification and deletion)
