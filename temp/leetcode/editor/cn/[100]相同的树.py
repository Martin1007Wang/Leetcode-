
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.

class TreeNode:
    def __init__(self,val=0,Left=None,Right=None):
        self.val=val
        self.left=Left
        self.right = Right
class Solution:
    def __init__(self):
        self.valp = []
        self.valq = []
    def dfs(self,root:TreeNode,val)->None:
        if not root:
            val.append(None)
            return
        val.append(root.val)
        self.dfs(root.left,val)
        self.dfs(root.right,val)
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        self.dfs(p,self.valp)
        self.dfs(q,self.valq)
        return self.valp==self.valq
# leetcode submit region end(Prohibit modification and deletion)
