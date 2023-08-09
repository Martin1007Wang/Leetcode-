<p>给你一个大小为 <code>m x n</code> 的二进制矩阵 <code>grid</code> ，其中 <code>0</code> 表示一个海洋单元格、<code>1</code> 表示一个陆地单元格。</p>

<p>一次 <strong>移动</strong> 是指从一个陆地单元格走到另一个相邻（<strong>上、下、左、右</strong>）的陆地单元格或跨过 <code>grid</code> 的边界。</p>

<p>返回网格中<strong> 无法 </strong>在任意次数的移动中离开网格边界的陆地单元格的数量。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/enclaves1.jpg" style="height: 200px; width: 200px;" /> 
<pre>
<strong>输入：</strong>grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
<strong>输出：</strong>3
<strong>解释：</strong>有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/enclaves2.jpg" style="height: 200px; width: 200px;" /> 
<pre>
<strong>输入：</strong>grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
<strong>输出：</strong>0
<strong>解释：</strong>所有 1 都在边界上或可以到达边界。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 500</code></li> 
 <li><code>grid[i][j]</code> 的值为 <code>0</code> 或 <code>1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 213, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=number-of-enclaves" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题属于岛屿系列问题，岛屿系列问题的基本思路框架是 [200. 岛屿数量](/problems/number-of-islands) 这道题，没看过的先看这篇。

这道题和 [1254. 统计封闭岛屿的数目](/problems/number-of-closed-islands) 基本一样，只是后者让你算封闭岛屿的数量，这题让你算这些封闭岛屿的陆地总数，稍微改改代码就行了。

注意这题中 `1` 代表陆地，`0` 代表海水。

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
    int numEnclaves(vector<vector<int>>& grid) {

        int m = grid.size(), n = grid[0].size();
        
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }

    void dfs(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
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
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        for i in range(m):
            self.dfs(grid, i, 0)
            self.dfs(grid, i, n - 1)

        for j in range(n):
            self.dfs(grid, 0, j)
            self.dfs(grid, m - 1, j)

        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    res += 1
        return res

    def dfs(self, grid: List[List[int]], i: int, j: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == 0:
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
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
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

// LeetCode 题目链接 https://leetcode-cn.com/problems/number-of-enclaves/
func numEnclaves(grid [][]int) int {
    m, n := len(grid), len(grid[0])

    for i := 0; i < m; i++ {
        dfs(grid, i, 0)
        dfs(grid, i, n-1)
    }

    for j := 0; j < n; j++ {
        dfs(grid, 0, j)
        dfs(grid, m-1, j)
    }

    var res int
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == 1 {
                res += 1
            }
        }
    }
    return res
}

func dfs(grid [][]int, i, j int) {
    m, n := len(grid), len(grid[0])
    if i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 {
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
 * @param {number[][]} grid
 * @return {number}
 */
var numEnclaves = function(grid) {
    var m = grid.length, n = grid[0].length;

    for (var i = 0; i < m; i++) {
        dfs(grid, i, 0);
        dfs(grid, i, n - 1);
    }

    for (var j = 0; j < n; j++) {
        dfs(grid, 0, j);
        dfs(grid, m - 1, j);
    }

    var res = 0;
    for (var row = 0; row < m; row++) {
        for (var col = 0; col < n; col++) {
            if (grid[row][col] === 1) {
                res += 1;
            }
        }
    }
    return res;
};

function dfs(grid, i, j) {
    var m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] === 0) {
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

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_number-of-enclaves" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_number-of-enclaves"></div></div>
</details><hr /><br />

**类似题目**：
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>





