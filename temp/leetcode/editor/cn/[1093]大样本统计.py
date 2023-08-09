
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        n=len(count)#有n个值
        total=sum(count)#有total个数
        mean=0.0
        median=0.0
        min_num=256.0
        max_num=0.0
        mode=0.0

        left=(total+1)//2#左中值在排序后数组的位置
        right=(total+2)//2#右中值在排序后数组的位置
        cnt=0
        max_freq=0
        sum_=0
        for i in range(n):
            sum_+=i*count[i]
            if count[i]>max_freq:
                max_freq=count[i]
                mode=i
            if count[i]>0:
                if min_num==256:
                    min_num=i
                max_num=i
            if cnt<right and cnt+count[i]>=right:
                median+=i
            if cnt<left and cnt+count[i]>=left:
                median+=i
            cnt+=count[i]
        mean=sum_/total
        median=median/2.0
        return [min_num,max_num,mean,median,mode]

# leetcode submit region end(Prohibit modification and deletion)
