<p>给你两个&nbsp;<code>m x n</code>&nbsp;的二进制矩阵&nbsp;<code>grid1</code> 和&nbsp;<code>grid2</code>&nbsp;，它们只包含&nbsp;<code>0</code>&nbsp;（表示水域）和 <code>1</code>&nbsp;（表示陆地）。一个 <strong>岛屿</strong>&nbsp;是由 <strong>四个方向</strong>&nbsp;（水平或者竖直）上相邻的&nbsp;<code>1</code>&nbsp;组成的区域。任何矩阵以外的区域都视为水域。</p>

<p>如果 <code>grid2</code>&nbsp;的一个岛屿，被 <code>grid1</code>&nbsp;的一个岛屿&nbsp;<strong>完全</strong> 包含，也就是说 <code>grid2</code>&nbsp;中该岛屿的每一个格子都被 <code>grid1</code>&nbsp;中同一个岛屿完全包含，那么我们称 <code>grid2</code>&nbsp;中的这个岛屿为 <strong>子岛屿</strong>&nbsp;。</p>

<p>请你返回 <code>grid2</code>&nbsp;中 <strong>子岛屿</strong>&nbsp;的 <strong>数目</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/10/test1.png" style="width: 493px; height: 205px;"> <pre><b>输入：</b>grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
<b>输出：</b>3
<strong>解释：</strong>如上图所示，左边为 grid1 ，右边为 grid2 。
grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
</pre> </img>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/06/03/testcasex2.png" style="width: 491px; height: 201px;"> <pre><b>输入：</b>grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
<b>输出：</b>2 
<strong>解释：</strong>如上图所示，左边为 grid1 ，右边为 grid2 。
grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。
</pre> </img>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == grid1.length == grid2.length</code></li> 
 <li><code>n == grid1[i].length == grid2[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 500</code></li> 
 <li><code>grid1[i][j]</code> 和&nbsp;<code>grid2[i][j]</code>&nbsp;都要么是&nbsp;<code>0</code>&nbsp;要么是&nbsp;<code>1</code>&nbsp;。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 100, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=count-sub-islands" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题属于岛屿系列问题，岛屿系列问题的基本思路框架是 [200. 岛屿数量](/problems/number-of-islands) 这道题，没看过的先看这篇。

**这道题的关键在于，如何快速判断子岛屿**？

什么情况下 `grid2` 中的一个岛屿 `B` 是 `grid1` 中的一个岛屿 `A` 的子岛？

当岛屿 `B` 中所有陆地在岛屿 `A` 中也是陆地的时候，岛屿 `B` 是岛屿 `A` 的子岛。

**反过来说，如果岛屿 `B` 中存在一片陆地，在岛屿 `A` 的对应位置是海水，那么岛屿 `B` 就不是岛屿 `A` 的子岛**。

那么，我们只要遍历 `grid2` 中的所有岛屿，把那些不可能是子岛的岛屿排除掉，剩下的就是子岛。

**详细题解：[一文秒杀所有岛屿题目](https://labuladong.github.io/article/fname.html?fname=岛屿题目)**

**标签：[DFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，二维矩阵**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int m = grid1.size(), n = grid1[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    // 这个岛屿肯定不是子岛，淹掉
                    dfs(grid2, i, j);
                }
            }
        }
        // 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        m, n = len(grid1), len(grid1[0])

        # 遍历 grid2，将非子岛的岛屿淹掉
        for i in range(m):
            for j in range(n):
                if grid1[i][j] == 0 and grid2[i][j] == 1:
                    self.dfs(grid2, i, j)

        # 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
        res = 0
        for i in range(m):
            for j in range(n):
                if grid2[i][j] == 1:
                    res += 1
                    self.dfs(grid2, i, j)

        return res

    # 从 (i, j) 开始，将与之相邻的陆地都变成海水
    def dfs(self, grid: List[List[int]], i: int, j: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            return
        if grid[i][j] == 0:
            return

        grid[i][j] = 0
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j - 1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    // 这个岛屿肯定不是子岛，淹掉
                    dfs(grid2, i, j);
                }
            }
        }
        // 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func countSubIslands(grid1 [][]int, grid2 [][]int) int {
    m, n := len(grid1), len(grid1[0])
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid1[i][j] == 0 && grid2[i][j] == 1 {
                // 这个岛屿肯定不是子岛，淹掉
                dfs(grid2, i, j)
            }
        }
    }
    // 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
    res := 0
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid2[i][j] == 1 {
                res++
                dfs(grid2, i, j)
            }
        }
    }
    return res
}

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
func dfs(grid [][]int, i, j int) {
    m, n := len(grid), len(grid[0])
    if i < 0 || j < 0 || i >= m || j >= n {
        return
    }
    if grid[i][j] == 0 {
        return
    }

    grid[i][j] = 0
    dfs(grid, i+1, j)
    dfs(grid, i, j+1)
    dfs(grid, i-1, j)
    dfs(grid, i, j-1)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[][]} grid1
 * @param {number[][]} grid2
 * @return {number}
 */
var countSubIslands = function(grid1, grid2) {
    const m = grid1.length, n = grid1[0].length;

    // 淹没非子岛屿
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                dfs(grid2, i, j);
            }
        }
    }

    // 计算子岛屿数量
    let res = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid2[i][j] == 1) {
                res++;
                dfs(grid2, i, j);
            }
        }
    }
    return res;
};

// 深度优先遍历
function dfs(grid, i, j) {
    const m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n) {
        return;
    }
    if (grid[i][j] == 0) {
        return;
    }

    grid[i][j] = 0;
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
}
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_count-sub-islands" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_count-sub-islands"></div></div>
</details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>





