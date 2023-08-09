<p>二维矩阵 <code>grid</code>&nbsp;由 <code>0</code>&nbsp;（土地）和 <code>1</code>&nbsp;（水）组成。岛是由最大的4个方向连通的 <code>0</code>&nbsp;组成的群，封闭岛是一个&nbsp;<code>完全</code> 由1包围（左、上、右、下）的岛。</p>

<p>请返回 <em>封闭岛屿</em> 的数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/10/31/sample_3_1610.png" style="height: 151px; width: 240px;" /></p>

<pre>
<strong>输入：</strong>grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
<strong>输出：</strong>2
<strong>解释：</strong>
灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。</pre>

<p><strong>示例 2：</strong></p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/07/sample_4_1610.png" style="height: 98px; width: 160px;" /></p>

<pre>
<strong>输入：</strong>grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>grid = [[1,1,1,1,1,1,1],
&nbsp;            [1,0,0,0,0,0,1],
&nbsp;            [1,0,1,1,1,0,1],
&nbsp;            [1,0,1,0,1,0,1],
&nbsp;            [1,0,1,1,1,0,1],
&nbsp;            [1,0,0,0,0,0,1],
             [1,1,1,1,1,1,1]]
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= grid.length, grid[0].length &lt;= 100</code></li> 
 <li><code>0 &lt;= grid[i][j] &lt;=1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 216, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=number-of-closed-islands" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

岛屿系列问题的基本思路框架是 [200. 岛屿数量](/problems/number-of-islands) 这道题，没看过的先看这篇。

如何判断「封闭岛屿」呢？其实很简单，把 [200. 岛屿数量](/problems/number-of-islands) 中那些靠边的岛屿排除掉，剩下的不就是「封闭岛屿」了吗？

有了这个思路，就可以直接写出代码了，注意这题规定 `0` 表示陆地，用 `1` 表示海水。

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
    // 主函数：计算封闭岛屿的数量
    int closedIsland(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        for (int j = 0; j < n; j++) {
            // 把靠上边的岛屿淹掉
            dfs(grid, 0, j);
            // 把靠下边的岛屿淹掉
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            // 把靠左边的岛屿淹掉
            dfs(grid, i, 0);
            // 把靠右边的岛屿淹掉
            dfs(grid, i, n - 1);
        }
        // 遍历 grid，剩下的岛屿都是封闭岛屿
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
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
        if (grid[i][j] == 1) {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 1;
        // 淹没上下左右的陆地
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
    def closedIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        for j in range(n):
            # 把靠上边的岛屿淹掉
            self.dfs(grid, 0, j)
            # 把靠下边的岛屿淹掉
            self.dfs(grid, m - 1, j)
        for i in range(m):
            # 把靠左边的岛屿淹掉
            self.dfs(grid, i, 0)
            # 把靠右边的岛屿淹掉
            self.dfs(grid, i, n - 1)
        # 遍历 grid，剩下的岛屿都是封闭岛屿
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    res += 1
                    self.dfs(grid, i, j)
        return res

    # 从 (i, j) 开始，将与之相邻的陆地都变成海水
    def dfs(self, grid: List[List[int]], i: int, j: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            return
        if grid[i][j] == 1:
            # 已经是海水了
            return
        # 将 (i, j) 变成海水
        grid[i][j] = 1
        # 淹没上下左右的陆地
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j - 1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
     // 主函数：计算封闭岛屿的数量
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 0; j < n; j++) {
            // 把靠上边的岛屿淹掉
            dfs(grid, 0, j);
            // 把靠下边的岛屿淹掉
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            // 把靠左边的岛屿淹掉
            dfs(grid, i, 0);
            // 把靠右边的岛屿淹掉
            dfs(grid, i, n - 1);
        }
        // 遍历 grid，剩下的岛屿都是封闭岛屿
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
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
        if (grid[i][j] == 1) {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 1;
        // 淹没上下左右的陆地
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

// 计算封闭岛屿的数量
func closedIsland(grid [][]int) int {
    m, n := len(grid), len(grid[0])
    for j := 0; j < n; j++ {
        // 把靠上边的岛屿淹掉
        dfs(grid, 0, j)
        // 把靠下边的岛屿淹掉
        dfs(grid, m-1, j)
    }
    for i := 0; i < m; i++ {
        // 把靠左边的岛屿淹掉
        dfs(grid, i, 0)
        // 把靠右边的岛屿淹掉
        dfs(grid, i, n-1)
    }
    // 遍历 grid，剩下的岛屿都是封闭岛屿
    res := 0
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == 0 {
                res++
                dfs(grid, i, j)
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
    if grid[i][j] == 1 {
        // 已经是海水了
        return
    }
    // 将 (i, j) 变成海水
    grid[i][j] = 1
    // 淹没上下左右的陆地
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

var closedIsland = function(grid) {
    var m = grid.length, n = grid[0].length;
    for (var j = 0; j < n; j++) {
        // 把靠上边的岛屿淹掉
        dfs(grid, 0, j);
        // 把靠下边的岛屿淹掉
        dfs(grid, m - 1, j);
    }
    for (var i = 0; i < m; i++) {
        // 把靠左边的岛屿淹掉
        dfs(grid, i, 0);
        // 把靠右边的岛屿淹掉
        dfs(grid, i, n - 1);
    }
    // 遍历 grid，剩下的岛屿都是封闭岛屿
    var res = 0;
    for (var i = 0; i < m; i++) {
        for (var j = 0; j < n; j++) {
            if (grid[i][j] === 0) {
                res++;
                dfs(grid, i, j);
            }
        }
    }
    return res;
}

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
function dfs(grid, i, j) {
    var m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n) {
        return;
    }
    if (grid[i][j] === 1) {
        // 已经是海水了
        return;
    }
    // 将 (i, j) 变成海水
    grid[i][j] = 1;
    // 淹没上下左右的陆地
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
}
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_number-of-closed-islands" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_number-of-closed-islands"></div></div>
</details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [130. 被围绕的区域 🟠](/problems/surrounded-regions)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [200. 岛屿数量 🟠](/problems/number-of-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>









