<p>给定&nbsp;<code>n</code> 个非负整数表示每个宽度为 <code>1</code> 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png" style="height: 161px; width: 412px;" /></p>

<pre>
<strong>输入：</strong>height = [0,1,0,2,1,0,1,3,2,1,2,1]
<strong>输出：</strong>6
<strong>解释：</strong>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>height = [4,2,0,3,2,5]
<strong>输出：</strong>9
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == height.length</code></li> 
 <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 双指针 | 动态规划 | 单调栈</details><br>

<div>👍 4417, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=trapping-rain-water" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 364 页。

对于任意一个位置 `i`，能够装的水为：

```python
water[i] = min(
           # 左边最高的柱子
           max(height[0..i]),
           # 右边最高的柱子
           max(height[i..end])
        ) - height[i]
```

![](https://labuladong.github.io/pictures/接雨水/1.jpg)

**关键在于，如何能够快速计算出某一个位置左侧所有柱子的最大高度和右侧所有柱子的最大高度**。

这道题的解法比较多样，可以预计算数组，可以用 [双指技巧](https://labuladong.github.io/article/fname.html?fname=双指针技巧)，可以用[单调栈技巧](https://labuladong.github.io/article/fname.html?fname=单调栈)，这里就说一个最简单的解法，用预计算的方式求解，优化暴力解法的时间复杂度，更多解法请看详细题解。

**详细题解：[如何高效解决接雨水问题](https://labuladong.github.io/article/fname.html?fname=接雨水)**

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int trap(vector<int>& height) {
        if (height.empty()) {
            return 0;
        }
        int n = height.size();
        int res = 0;
        // 数组充当备忘录
        vector<int> l_max(n);
        vector<int> r_max(n);
        // 初始化 base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左向右计算 l_max
        for (int i = 1; i < n; i++) {
            l_max[i] = max(height[i], l_max[i - 1]);
        }
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = max(height[i], r_max[i + 1]);
        }
        // 计算答案
        for (int i = 1; i < n - 1; i++) {
            res += min(l_max[i], r_max[i]) - height[i];
        }/**<extend up -300>![](https://labuladong.github.io/pictures/接雨水/1.jpg) */
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        n = len(height)
        res = 0
        # 数组充当备忘录
        l_max = [0] * n
        r_max = [0] * n
        # 初始化 base case
        l_max[0] = height[0]
        r_max[n - 1] = height[n - 1]
        # 从左向右计算 l_max
        for i in range(1, n):
            l_max[i] = max(height[i], l_max[i - 1])
        # 从右向左计算 r_max
        for i in range(n - 2, -1, -1):
            r_max[i] = max(height[i], r_max[i + 1])
        # 计算答案
        for i in range(1, n - 1):
            res += min(l_max[i], r_max[i]) - height[i]
            """
            extend up -300
            ![](https://labuladong.github.io/pictures/接雨水/1.jpg)
            """
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;
        // 数组充当备忘录
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        // 初始化 base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左向右计算 l_max
        for (int i = 1; i < n; i++)
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--)
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        // 计算答案
        for (int i = 1; i < n - 1; i++)
            res += Math.min(l_max[i], r_max[i]) - height[i];/**<extend up -300>![](https://labuladong.github.io/pictures/接雨水/1.jpg) */
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func trap(height []int) int {
    if len(height) == 0 {
        return 0
    }
    n := len(height)
    res := 0
    // 数组充当备忘录
    l_max := make([]int, n)
    r_max := make([]int, n)
    // 初始化 base case
    l_max[0] = height[0]
    r_max[n - 1] = height[n - 1]
    // 从左向右计算 l_max
    for i := 1; i < n; i++ {
        l_max[i] = max(height[i], l_max[i - 1])
    }
    // 从右向左计算 r_max
    for i := n - 2; i >= 0; i-- {
        r_max[i] = max(height[i], r_max[i + 1])
    }
    // 计算答案
    for i := 1; i < n - 1; i++ {
        res += min(l_max[i], r_max[i]) - height[i]/**<extend up -300>![](https://labuladong.github.io/pictures/接雨水/1.jpg) */
    } 
    return res;
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b 
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b 
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var trap = function(height) {
  if (height.length == 0) {
    return 0;
  }
  var n = height.length;
  var res = 0;
  // 数组充当备忘录
  var l_max = new Array(n);
  var r_max = new Array(n);
  // 初始化 base case
  l_max[0] = height[0];
  r_max[n - 1] = height[n - 1];
  // 从左向右计算 l_max
  for (var i = 1; i < n; i++) {
    l_max[i] = Math.max(height[i], l_max[i - 1]);
  }
  // 从右向左计算 r_max
  for (var i = n - 2; i >= 0; i--) {
    r_max[i] = Math.max(height[i], r_max[i + 1]);
  }
  // 计算答案
  for (var i = 1; i < n - 1; i++) {
    res += Math.min(l_max[i], r_max[i]) - height[i];
  }/**<extend up -300>![](https://labuladong.github.io/pictures/接雨水/1.jpg) */
  return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_trapping-rain-water" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_trapping-rain-water"></div></div>
</details><hr /><br />

**类似题目**：
  - [11. 盛最多水的容器 🟠](/problems/container-with-most-water)

</details>
</div>



