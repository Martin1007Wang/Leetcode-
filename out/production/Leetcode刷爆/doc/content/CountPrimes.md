<p>给定整数 <code>n</code> ，返回 <em>所有小于非负整数&nbsp;<code>n</code>&nbsp;的质数的数量</em> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 10
<strong>输出：</strong>4
<strong>解释：</strong>小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 0
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出</strong>：0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= n &lt;= 5 * 10<sup>6</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 枚举 | 数论</details><br>

<div>👍 1069, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=count-primes" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 351 页。

筛数法是常见的计算素数的算法。

因为判断一个数字是否是素数的时间成本较高，所以我们不要一个个判断每个数字是否是素数，而是用排除法，把所有非素数都排除，剩下的就是素数。

**详细题解：[如何高效寻找素数](https://labuladong.github.io/article/fname.html?fname=打印素数)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    int countPrimes(int n) {
        vector<bool> isPrime(n, true); // vector instead of array
        for (int i = 2; i * i < n; i++)
            if (isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i]) count++;

        return count;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def countPrimes(self, n: int) -> int:
        isPrime = [True]*n
        for i in range(2, int(n**0.5)+1):
            if isPrime[i]:
                for j in range(i*i, n, i):
                    isPrime[j] = False

        count = 0
        for i in range(2, n):
            if isPrime[i]:
                count += 1

        return count
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++)
            if (isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i]) count++;

        return count;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func countPrimes(n int) int {
    // create boolean array with default value true
    isPrime := make([]bool, n)
    for i := range isPrime {
        isPrime[i] = true
    }

    // loop through all numbers up to the square root of n
    for i := 2; i*i < n; i++ {
        if isPrime[i] {
            // loop through multiples of i and mark them as not prime
            for j := i * i; j < n; j += i {
                isPrime[j] = false
            }
        }
    }

    // count number of primes
    count := 0
    for i := 2; i < n; i++ {
        if isPrime[i] {
            count++
        }
    }

    return count
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
var countPrimes = function(n) {
    const isPrime = new Array(n).fill(true);
    for (let i = 2; i * i < n; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    let count = 0;
    for (let i = 2; i < n; i++) {
        if (isPrime[i]) count++;
    }
    return count;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_count-primes" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_count-primes"></div></div>
</details><hr /><br />

**类似题目**：
  - [264. 丑数 II 🟠](/problems/ugly-number-ii)
  - [剑指 Offer 49. 丑数 🟠](/problems/chou-shu-lcof)

</details>
</div>



