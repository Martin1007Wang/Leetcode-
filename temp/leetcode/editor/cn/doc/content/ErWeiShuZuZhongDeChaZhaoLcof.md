<p>在一个 n * m 的二维数组中，每一行都按照从左到右&nbsp;<strong>非递减&nbsp;</strong>的顺序排序，每一列都按照从上到下&nbsp;<strong>非递减&nbsp;</strong>的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<p>现有矩阵 matrix 如下：</p>

<pre>
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
</pre>

<p>给定 target&nbsp;=&nbsp;<code>5</code>，返回&nbsp;<code>true</code>。</p>

<p>给定&nbsp;target&nbsp;=&nbsp;<code>20</code>，返回&nbsp;<code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= n &lt;= 1000</code></p>

<p><code>0 &lt;= m &lt;= 1000</code></p>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题与主站 240 题相同：<a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">https://leetcode-cn.com/problems/search-a-2d-matrix-ii/</a></p>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 分治 | 矩阵</details><br>

<div>👍 958, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [240. 搜索二维矩阵 II](/problems/search-a-2d-matrix-ii) 相同。

作为 [74. 搜索二维矩阵](/problems/search-a-2d-matrix) 的进阶题目，这道题不算 [二分搜索算法](https://labuladong.github.io/article/fname.html?fname=二分查找详解)，更像 [一个方法秒杀所有 N 数之和问题](https://labuladong.github.io/article/fname.html?fname=nSum)，因为它们的思想上有些类似。

这道题说 `matrix` 从上到下递增，从左到右递增，显然左上角是最小元素，右下角是最大元素。**我们如果想高效在 `matrix` 中搜索一个元素，肯定需要从某个角开始**，比如说从左上角开始，然后每次只能向右或向下移动，不要走回头路。

如果真从左上角开始的话，就会发现无论向右还是向下走，元素大小都会增加，那么到底向右还是向下？不确定，那只好用类似 [动态规划算法](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶) 的思路穷举了。

但实际上不用这么麻烦，我们不要从左上角开始，而是从右上角开始，规定只能向左或向下移动。

你注意，如果向左移动，元素在减小，如果向下移动，元素在增大，这样的话我们就可以根据当前位置的元素和 `target` 的相对大小来判断应该往哪移动，不断接近从而找到 `target` 的位置。

当然，如果你想从左下角开始，规定只能向右或向上移动也可以，具体看代码吧。

**标签：[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = matrix[0].size();
        // 初始化在右上角
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                // 需要大一点，往下移动
                i++;
            } else {
                // 需要小一点，往左移动
                j--;
            }
        }
        // while 循环中没有找到，则 target 不存在
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        # 初始化在右上角
        i, j = 0, n - 1
        while i < m and j >= 0:
            if matrix[i][j] == target:
                return True
            if matrix[i][j] < target:
                # 需要大一点，往下移动
                i += 1
            else:
                # 需要小一点，往左移动
                j -= 1
        # while 循环中没有找到，则 target 不存在
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 初始化在右上角
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                // 需要大一点，往下移动
                i++;
            } else {
                // 需要小一点，往左移动
                j--;
            }
        }
        // while 循环中没有找到，则 target 不存在
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func searchMatrix(matrix [][]int, target int) bool {
    m, n := len(matrix), len(matrix[0])
    // 初始化在右上角
    i, j := 0, n-1
    for i < m && j >= 0 {
        if matrix[i][j] == target {
            return true
        }
        if matrix[i][j] < target {
            // 需要大一点，往下移动
            i++
        } else {
            // 需要小一点，往左移动
            j--
        }
    }
    // while 循环中没有找到，则 target 不存在
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var searchMatrix = function(matrix, target) {
    const m = matrix.length;
    const n = matrix[0].length;
    // 初始化在右上角
    let i = 0;
    let j = n - 1;
    while (i < m && j >= 0) {
        if (matrix[i][j] === target) {
            return true;
        }
        if (matrix[i][j] < target) {
            // 需要大一点，往下移动
            i++;
        } else {
            // 需要小一点，往左移动
            j--;
        }
    }
    // while 循环中没有找到，则 target 不存在
    return false;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_search-a-2d-matrix-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_search-a-2d-matrix-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer 04. 二维数组中的查找 🟠](/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof)

</details>
</div>





