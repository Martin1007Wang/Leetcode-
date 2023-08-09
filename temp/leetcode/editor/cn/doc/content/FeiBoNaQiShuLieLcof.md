<p>写一个函数，输入 <code>n</code> ，求斐波那契（Fibonacci）数列的第 <code>n</code> 项（即 <code>F(N)</code>）。斐波那契数列的定义如下：</p>

<pre>
F(0) = 0,&nbsp; &nbsp;F(1)&nbsp;= 1
F(N) = F(N - 1) + F(N - 2), 其中 N &gt; 1.</pre>

<p>斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。</p>

<p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 2
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 5
<strong>输出：</strong>5
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>记忆化搜索 | 数学 | 动态规划</details><br>

<div>👍 487, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[动态规划框架套路详解](https://www.bilibili.com/video/BV1XV411Y7oE)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 31 页。

这题本身肯定是没有难度的，但是斐波那契数列可以帮你由浅入深理解动态规划算法的原理，建议阅读详细题解。

另外，剑指 offer 的这道斐波那契和原题 [509. 斐波那契数](/problems/fibonacci-number) 还是有点不一样的，就是要求你对结果求模。

因为结果会让 int 溢出，所以要么你用 long 类型，要么你一边求和一边求模。

加法求模的一个运算法则如下：

```
(a + b) % Q = (a % Q + b % Q) % Q
```

这个等式很容易推导，而且也可以运用到乘法上，具体的推导思路可以查看我的这篇文章 [如何高效进行模幂运算](https://labuladong.github.io/article/fname.html?fname=superPower)。

**详细题解：[动态规划解题套路框架](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶)**

**标签：[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    int fib(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        int Q = 1000000007;
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = (dp_i_1 % Q + dp_i_2 % Q) % Q;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def fib(self, n: int) -> int:
        if n == 0 or n == 1:
            # base case
            return n
        Q = 1000000007
        # 分别代表 dp[i - 1] 和 dp[i - 2]
        dp_i_1, dp_i_2 = 1, 0
        for i in range(2, n + 1):
            # dp[i] = dp[i - 1] + dp[i - 2];
            dp_i = (dp_i_1 % Q + dp_i_2 % Q) % Q
            dp_i_2 = dp_i_1
            dp_i_1 = dp_i
        return dp_i_1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        int Q = 1000000007;
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = (dp_i_1 % Q + dp_i_2 % Q) % Q;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func fib(n int) int {
    if n == 0 || n == 1 {
        // base case
        return n
    }
    Q := 1000000007
    // 分别代表 dp[i - 1] 和 dp[i - 2]
    dp_i_1, dp_i_2 := 1, 0
    for i := 2; i <= n; i++ {
        // dp[i] = dp[i - 1] + dp[i - 2];
        dp_i := (dp_i_1 % Q + dp_i_2 % Q) % Q
        dp_i_2 = dp_i_1
        dp_i_1 = dp_i
    }
    return dp_i_1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
    if (n === 0 || n === 1) {
        // base case
        return n;
    }
    const Q = 1000000007;
    // 分别代表 dp[i - 1] 和 dp[i - 2]
    let dp_i_1 = 1, dp_i_2 = 0;
    for (let i = 2; i <= n; i++) {
        // dp[i] = dp[i - 1] + dp[i - 2];
        const dp_i = (dp_i_1 % Q + dp_i_2 % Q) % Q;
        dp_i_2 = dp_i_1;
        dp_i_1 = dp_i;
    }
    return dp_i_1;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_fei-bo-na-qi-shu-lie-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_fei-bo-na-qi-shu-lie-lcof"></div></div>
</details><hr /><br />

</details>
</div>



