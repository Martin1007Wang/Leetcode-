//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
//
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 1078, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.HashMap;

public class ZhongJianErChaShuLcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 存储 inorder 中值到索引的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i =0;i<inorder.length;i++){
                valToIndex.put(inorder[i],i);
            }
            return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        }
        TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if(preStart>preEnd){
                return null;
            }
            int rootVal=preorder[preStart];
            int index=valToIndex.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            root.left=build(preorder,preStart+1,preStart+index-inStart,inorder,inStart,index-1);
            root.right=build(preorder,preStart+index-inStart+1,preEnd,inorder,index+1,inEnd);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}