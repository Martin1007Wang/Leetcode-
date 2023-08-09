//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（
//上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 示例 2: 
//
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 示例 3: 
//
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//
// 提示： 
//
// 
// board.length == 2 
// board[i].length == 3 
// 0 <= board[i][j] <= 5 
// board[i][j] 中每个值都 不同 
// 
//
// Related Topics广度优先搜索 | 数组 | 矩阵 
//
// 👍 307, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

import java.util.*;

public class SlidingPuzzle {
    public static void main(String[] args) {
        Solution solution = new SlidingPuzzle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int slidingPuzzle(int[][] board) {
            int m = 2, n = 3;
            StringBuilder sb = new StringBuilder();
            String target = "123450";
            // 将 2x3 的数组转化成字符串作为 BFS 的起点
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
            }
            String start = sb.toString();
            int[][] neighbor = new int[][]{
                    {1, 3},
                    {0, 2, 4},
                    {1, 5},
                    {0, 4},
                    {1, 3, 5},
                    {2, 4}
            };
            /******* BFS 算法框架开始 *******/
            Queue<String> q = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();
            q.offer(start);
            visited.add(start);
            int step = 0;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    String cur = q.poll();
                    if (target.equals(cur)) {
                        return step;
                    }
                    int idx = 0;
                    for (; cur.charAt(idx) != '0'; idx++) ;
                    for (int adj : neighbor[idx]) {
                        String new_board = swap(cur.toCharArray(), adj, idx);
                        if (!visited.contains(new_board)) {
                            q.offer(new_board);
                            visited.add(new_board);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        private String swap(char[] chars, int i, int j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            return new String(chars);
        }

        private int[][] generateNeighborMapping(int m, int n) {
            int[][] neighbor = new int[m * n][];
            for (int i = 0; i < m * n; i++) {
                List<Integer> neighbors = new ArrayList<>();
                if (i % n != 0) neighbors.add(i - 1);
                if (i % n != n - 1) neighbors.add(i + 1);
                if (i - n >= 0) neighbors.add(i - n);
                if (i + n < m * n) neighbors.add(i + n);
                neighbor[i] = neighbors.stream().mapToInt(Integer::intValue).toArray();
            }
            return neighbor;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}