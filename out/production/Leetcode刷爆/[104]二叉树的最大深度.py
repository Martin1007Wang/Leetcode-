
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
#记录最大深度
res=0
#记录遍历到的节点深度：
depth=0
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # def traverse(self, root:TreeNode)->None:
    #     global res, depth
    #     if not root:
    #         return
    #     # 前序位置
    #     depth += 1
    #     if not root.left and not root.right:
    #         # 到达叶子节点，更新最大深度
    #         res = max(res, depth)
    #     self.traverse(root.left)
    #     self.traverse(root.right)
    #     # 后序位置
    #     depth -= 1
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # #遍历法：
        # self.traverse(root)
        # return res
        # #递归法：
        if not root:
            return 0
        left_max=self.maxDepth(root.left)
        right_max=self.maxDepth(root.right)
        # 整棵树的最大深度等于左右子树的最大深度取最大值，
        # 然后再加上根节点自己
        res=max(left_max,right_max)+1
        return res


# leetcode submit region end(Prohibit modification and deletion)
