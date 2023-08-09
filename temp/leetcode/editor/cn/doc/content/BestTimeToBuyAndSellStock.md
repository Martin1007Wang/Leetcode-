<p>给定一个数组 <code>prices</code> ，它的第&nbsp;<code>i</code> 个元素&nbsp;<code>prices[i]</code> 表示一支给定股票第 <code>i</code> 天的价格。</p>

<p>你只能选择 <strong>某一天</strong> 买入这只股票，并选择在 <strong>未来的某一个不同的日子</strong> 卖出该股票。设计一个算法来计算你所能获取的最大利润。</p>

<p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 <code>0</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[7,1,5,3,6,4]
<strong>输出：</strong>5
<strong>解释：</strong>在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [7,6,4,3,1]
<strong>输出：</strong>0
<strong>解释：</strong>在这种情况下, 没有交易完成, 所以最大利润为 0。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 3010, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=best-time-to-buy-and-sell-stock" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

**提示：股票系列问题有共通性，但难度较大，初次接触此类问题的话很难看懂下述思路，建议直接看 [详细题解](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)。**

股票系列问题状态定义：

```python
dp[i][k][0 or 1]
0 <= i <= n - 1, 1 <= k <= K
n 为天数，大 K 为交易数的上限，0 和 1 代表是否持有股票。
```

股票系列问题通用状态转移方程：

```python
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
              max( 今天选择 rest,        今天选择 sell       )

dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
              max( 今天选择 rest,         今天选择 buy         )
```

通用 base case：

```python
dp[-1][...][0] = dp[...][0][0] = 0
dp[-1][...][1] = dp[...][0][1] = -infinity
```

特化到 `k = 1` 的情况，状态转移方程和 base case 如下：

```python
状态转移方程：
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], -prices[i])

base case：
dp[i][0] = 0;
dp[i][1] = -prices[i];
```

详细思路解析和空间复杂度优化的解法见详细题解。

**详细题解：[一个方法团灭 LeetCode 股票买卖问题](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n, vector<int>(2));
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0] * 2 for _ in range(n)]
        for i in range(n):
            if i - 1 == -1:
                # base case
                dp[i][0] = 0
                dp[i][1] = -prices[i]
                continue
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], -prices[i])
        return dp[n - 1][0]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func maxProfit(prices []int) int {
    n := len(prices)
    dp := make([][]int, n)
    for i := 0; i < n; i++ {
        dp[i] = make([]int, 2)
        if i - 1 == -1 {
            // base case
            dp[i][0] = 0
            dp[i][1] = -prices[i]
            continue
        }
        dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
        dp[i][1] = max(dp[i-1][1], -prices[i])
    }
    return dp[n-1][0]
}

func max(a, b int) int {
    if a > b {
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

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    const n = prices.length;
    const dp = new Array(n).map(() => new Array(2));
    for (let i = 0; i < n; i++) {
        if (i - 1 === -1) {
            // base case
            dp[i][0] = 0;
            dp[i][1] = -prices[i];
            continue;
        }
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return dp[n - 1][0];
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_best-time-to-buy-and-sell-stock" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_best-time-to-buy-and-sell-stock"></div></div>
</details><hr /><br />

**类似题目**：
  - [122. 买卖股票的最佳时机 II 🟠](/problems/best-time-to-buy-and-sell-stock-ii)
  - [123. 买卖股票的最佳时机 III 🔴](/problems/best-time-to-buy-and-sell-stock-iii)
  - [188. 买卖股票的最佳时机 IV 🔴](/problems/best-time-to-buy-and-sell-stock-iv)
  - [309. 最佳买卖股票时机含冷冻期 🟠](/problems/best-time-to-buy-and-sell-stock-with-cooldown)
  - [714. 买卖股票的最佳时机含手续费 🟠](/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)
  - [剑指 Offer 63. 股票的最大利润 🟠](/problems/gu-piao-de-zui-da-li-run-lcof)

</details>
</div>



