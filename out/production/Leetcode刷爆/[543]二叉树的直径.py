
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def __init__(self):
        self.maxDiameter=0
    #计算二叉树最大深度
    def maxDepth(self,root:TreeNode)->int:
        if not root:
            return 0
        leftMax=self.maxDepth(root.left)
        rightMax=self.maxDepth(root.right)
        return 1+max(leftMax,rightMax)

    #计算直径放在maxdepth的后序位置，改进：
    def maxDepthPro(self,root:TreeNode)->int:
        if root is None:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        # 后序位置，顺便计算最大直径
        myDiameter = leftMax + rightMax
        self.maxDiameter = max(self.maxDiameter, myDiameter)

        return 1 + max(leftMax, rightMax)
    #遍历二叉树
    def tranverse(self,root:TreeNode)->None:
        if not root:
            return
        leftMax=self.maxDepth(root.left)
        rightMax=self.maxDepth(root.right)
        diameter=leftMax+rightMax

        self.maxDiameter=max(self.maxDiameter,diameter)
        self.tranverse(root.left)
        self.tranverse(root.right)


    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        # self.tranverse(root)
        self.maxDepthPro(root)
        return self.maxDiameter
# leetcode submit region end(Prohibit modification and deletion)
