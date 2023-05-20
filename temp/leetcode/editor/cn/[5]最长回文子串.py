
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    #left=right：奇数长度回文串
    #left+1=right：偶数长度回文串
    def palindrome(self,s:str,left:int,right:int)->str:
        while left>=0 and right<len(s) and s[left]==s[right]:
            left-=1
            right+=1
        return s[left+1:right]
    def longestPalindrome(self, s: str) -> str:
        res=''
        for i in range(len(s)):
            s1=self.palindrome(s,i,i)
            s2=self.palindrome(s,i,i+1)
            res=res if len(res)>len(s1) else s1
            res=res if len(res)>len(s2) else s2
        return res
# leetcode submit region end(Prohibit modification and deletion)
