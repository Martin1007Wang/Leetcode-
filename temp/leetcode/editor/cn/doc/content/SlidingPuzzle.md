<p>在一个 <code>2 x 3</code> 的板上（<code>board</code>）有 5 块砖瓦，用数字 <code>1~5</code> 来表示, 以及一块空缺用&nbsp;<code>0</code>&nbsp;来表示。一次 <strong>移动</strong> 定义为选择&nbsp;<code>0</code>&nbsp;与一个相邻的数字（上下左右）进行交换.</p>

<p>最终当板&nbsp;<code>board</code>&nbsp;的结果是&nbsp;<code>[[1,2,3],[4,5,0]]</code>&nbsp;谜板被解开。</p>

<p>给出一个谜板的初始状态&nbsp;<code>board</code>&nbsp;，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/06/29/slide1-grid.jpg" /></p>

<pre>
<strong>输入：</strong>board = [[1,2,3],[4,0,5]]
<strong>输出：</strong>1
<strong>解释：</strong>交换 0 和 5 ，1 步完成
</pre>

<p><strong>示例 2:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/06/29/slide2-grid.jpg" /></p>

<pre>
<strong>输入：</strong>board = [[1,2,3],[5,4,0]]
<strong>输出：</strong>-1
<strong>解释：</strong>没有办法完成谜板
</pre>

<p><strong>示例 3:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/06/29/slide3-grid.jpg" /></p>

<pre>
<strong>输入：</strong>board = [[4,1,2],[5,0,3]]
<strong>输出：</strong>5
<strong>解释：</strong>
最少完成谜板的最少移动次数是 5 ，
一种移动路径:
尚未移动: [[4,1,2],[5,0,3]]
移动 1 次: [[4,1,2],[0,5,3]]
移动 2 次: [[0,1,2],[4,5,3]]
移动 3 次: [[1,0,2],[4,5,3]]
移动 4 次: [[1,2,0],[4,5,3]]
移动 5 次: [[1,2,3],[4,5,0]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>board.length == 2</code></li> 
 <li><code>board[i].length == 3</code></li> 
 <li><code>0 &lt;= board[i][j] &lt;= 5</code></li> 
 <li><code>board[i][j]</code>&nbsp;中每个值都 <strong>不同</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>广度优先搜索 | 数组 | 矩阵</details><br>

<div>👍 307, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=sliding-puzzle" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 310 页。

这题可以用 BFS 算法解决。BFS 算法并不只是一个寻路算法，而是一种暴力搜索算法，只要涉及暴力穷举的问题，BFS 就可以用，而且可以最快地穷举出答案，关于 BFS 算法原理可以看 [BFS 算法框架](https://labuladong.github.io/article/fname.html?fname=BFS框架)。

**详细题解：[如何用 BFS 算法秒杀各种智力题](https://labuladong.github.io/article/fname.html?fname=BFS解决滑动拼图)**

**标签：[BFS 算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，字符串**

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
    int slidingPuzzle(vector<vector<int>>& board) {
        int m = 2, n = 3;
        string target = "123450";
        // 将 2x3 的数组转化成字符串作为 BFS 的起点
        string start = "";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start += to_string(board[i][j]);
            }
        }

        // 记录一维字符串的相邻索引
        int neighbor[6][3] = {
            {1, 3},
            {0, 4, 2},
            {1, 5},
            {0, 4},
            {3, 1, 5},
            {4, 2}
        };

        /******* BFS 算法框架开始 *******/
        queue<string> q;
        unordered_set<string> visited;
        // 从起点开始 BFS 搜索
        q.push(start);
        visited.insert(start);

        int step = 0;
        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                string cur = q.front();
                q.pop();
                // 判断是否达到目标局面
                if (target == cur) {
                    return step;
                }
                // 找到数字 0 的索引
                int idx = 0;
                for (; cur[idx] != '0'; idx++) ;
                // 将数字 0 和相邻的数字交换位置
                for (int j = 0; j < 3; j++) {
                    int adj = neighbor[idx][j];
                    string new_board = swap(cur, adj, idx);
                    // 防止走回头路
                    if (visited.find(new_board) == visited.end()) {
                        q.push(new_board);
                        visited.insert(new_board);
                    }
                }
            }
            step++;
        }
        /******* BFS 算法框架结束 *******/
        return -1;
    }

    string swap(string str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        return str;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        m, n = 2, 3
        sb = []
        target = "123450"
        # 将 2x3 的数组转化成字符串作为 BFS 的起点
        for i in range(m):
            for j in range(n):
                sb.append(str(board[i][j]))
        start = ''.join(sb)

        # 记录一维字符串的相邻索引
        neighbor = [
            [1, 3],
            [0, 4, 2],
            [1, 5],
            [0, 4],
            [3, 1, 5],
            [4, 2]
        ]

        # BFS 算法框架开始
        q = collections.deque()
        visited = set()
        # 从起点开始 BFS 搜索
        q.append(start)
        visited.add(start)

        step = 0
        while q:
            sz = len(q)
            for i in range(sz):
                cur = q.popleft()
                # 判断是否达到目标局面
                if target == cur:
                    return step
                # 找到数字 0 的索引
                idx = cur.find('0')
                # 将数字 0 和相邻的数字交换位置
                for adj in neighbor[idx]:
                    new_board = self.swap(cur, adj, idx)
                    # 防止走回头路
                    if new_board not in visited:
                        q.append(new_board)
                        visited.add(new_board)
            step += 1
        # BFS 算法框架结束
        return -1

    def swap(self, chars, i, j):
        chars = list(chars)
        chars[i], chars[j] = chars[j], chars[i]
        return ''.join(chars)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
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

        // 记录一维字符串的相邻索引
        int[][] neighbor = new int[][]{
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}
        };

        /******* BFS 算法框架开始 *******/
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        // 从起点开始 BFS 搜索
        q.offer(start);
        visited.add(start);

        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // 判断是否达到目标局面
                if (target.equals(cur)) {
                    return step;
                }
                // 找到数字 0 的索引
                int idx = 0;
                for (; cur.charAt(idx) != '0'; idx++) ;
                // 将数字 0 和相邻的数字交换位置
                for (int adj : neighbor[idx]) {
                    String new_board = swap(cur.toCharArray(), adj, idx);
                    // 防止走回头路
                    if (!visited.contains(new_board)) {
                        q.offer(new_board);
                        visited.add(new_board);
                    }
                }
            }
            step++;
        }
        /******* BFS 算法框架结束 *******/
        return -1;
    }

    private String swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

import "fmt"

func slidingPuzzle(board [][]int) int {
    m, n := 2, 3
    sb := make([]byte, 0, 6)
    target := "123450"
    // 将 2x3 的数组转化成字符串作为 BFS 的起点
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            sb = append(sb, byte(board[i][j]+'0'))
        }
    }
    start := string(sb)

    // 记录一维字符串的相邻索引
    neighbor := [][]int{
        {1, 3},
        {0, 4, 2},
        {1, 5},
        {0, 4},
        {3, 1, 5},
        {4, 2},
    }

    /******* BFS 算法框架开始 *******/
    q := []string{start}
    visited := make(map[string]bool)
    // 从起点开始 BFS 搜索
    visited[start] = true

    step := 0
    for len(q) > 0 {
        sz := len(q)
        for i := 0; i < sz; i++ {
            cur := q[i]
            // 判断是否达到目标局面
            if cur == target {
                return step
            }
            // 找到数字 0 的索引
            idx := 0
            for cur[idx] != '0' {
                idx++
            }
            // 将数字 0 和相邻的数字交换位置
            for _, adj := range neighbor[idx] {
                newBoard := swap([]byte(cur), adj, idx)
                // 防止走回头路
                if !visited[newBoard] {
                    q = append(q, newBoard)
                    visited[newBoard] = true
                }
            }
        }
        q = q[sz:]
        step++
    }
    /******* BFS 算法框架结束 *******/
    return -1
}

func swap(chars []byte, i, j int) string {
    temp := chars[i]
    chars[i] = chars[j]
    chars[j] = temp
    return string(chars)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var slidingPuzzle = function(board) {
  const m = 2, n = 3;
  
  let sb = '';
  const target = '123450';
  // 将 2x3 的数组转化成字符串作为 BFS 的起点
  for (let i = 0; i < m; i++) {
      for (let j = 0; j < n; j++) {
          sb += board[i][j];
      }
  }
  let start = sb.toString();

  // 记录一维字符串的相邻索引
  const neighbor = [
      [1, 3],
      [0, 4, 2],
      [1, 5],
      [0, 4],
      [3, 1, 5],
      [4, 2]
  ];
  
  /******* BFS 算法框架开始 *******/
  let q = [];
  const visited = new Set();
  // 从起点开始 BFS 搜索
  q.push(start);
  visited.add(start);

  let step = 0;
  while (q.length) {
      const sz = q.length;
      for (let i = 0; i < sz; i++) {
          const cur = q.shift();
          // 判断是否达到目标局面
          if (target === cur) {
              return step;
          }
          // 找到数字 0 的索引
          let idx = 0;
          for (; cur.charAt(idx) !== '0'; idx++) ;
          // 将数字 0 和相邻的数字交换位置
          for (const adj of neighbor[idx]) {
              const new_board = swap(cur.slice(0), adj, idx);
              // 防止走回头路
              if (!visited.has(new_board)) {
                  q.push(new_board);
                  visited.add(new_board);
              }
          }
      }
      step++;
  }
  /******* BFS 算法框架结束 *******/
  return -1;
};

var swap = function(chars, i, j) {
  [chars[i], chars[j]] = [chars[j], chars[i]];
  return chars.join('');
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_sliding-puzzle" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_sliding-puzzle"></div></div>
</details><hr /><br />

</details>
</div>



