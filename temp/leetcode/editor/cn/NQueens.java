//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1805, 👎 0 
//
//
//
//

import java.util.ArrayList;
import java.util.List;


public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) sb.append(".");
                board.add(sb.toString());
            }
            backtrack(board, 0);
            return res;
        }

        // 路径：board 中小于 row 的那些行都已经成功放置了皇后
        // 选择列表：第 row 行的所有列都是放置皇后的选择
        // 结束条件：row 超过 board 的最后一行
        public void backtrack(List<String> board, int row) {
            // 触发结束条件(basecase)
            if (row == board.size()) {
                res.add(new ArrayList<>(board));
                return;
            }
            int n = board.get(row).length();
            //尝试在该行的每一列取放棋子，判断放法是否合法，合法则继续到下一行，不合法则跳过
            for (int col = 0; col < n; col++) {
                if (!isValid(board, row, col)) {
                    continue;
                }
                //合法，做选择，修改(row,col)为Q
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());
                backtrack(board, row + 1);
                //撤销选择（回溯）把(row,col)上的Q变回
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }

        }

        public boolean isValid(List<String> board, int row, int col) {
            int n = board.size();
            /* 检查列是否有皇后互相冲突 */
            for (int i = 0; i < n; i++) {
                if (board.get(i).charAt(col) == 'Q') {
                    return false;
                }
            }
            /* 检查右上方是否有皇后互相冲突 */
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board.get(i).charAt(j) == 'Q') return false;
            }
            /* 检查左上方是否有皇后互相冲突 */
            for (int i = row - 1, j = col - 1;
                 i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}