<p>给你一个整数 <code>n</code>，请你判断该整数是否是 2 的幂次方。如果是，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>如果存在一个整数 <code>x</code> 使得&nbsp;<code>n == 2<sup>x</sup></code> ，则认为 <code>n</code> 是 2 的幂次方。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>true
<strong>解释：</strong>2<sup>0</sup> = 1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 16
<strong>输出：</strong>true
<strong>解释：</strong>2<sup>4</sup> = 16
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>false
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>n = 4
<strong>输出：</strong>true
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>n = 5
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能够不使用循环/递归解决此问题吗？</p>

<details><summary><strong>Related Topics</strong></summary>位运算 | 递归 | 数学</details><br>

<div>👍 613, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=power-of-two" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

一个数如果是 2 的指数，那么它的二进制表示一定只含有一个 1。

位运算 `n&(n-1)` 在算法中挺常见的，作用是消除数字 `n` 的二进制表示中的最后一个 1，用这个技巧可以判断 2 的指数。

**详细题解：[常用的位操作](https://labuladong.github.io/article/fname.html?fname=常用的位操作)**

**标签：[位运算](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

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
    bool isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False
        return (n & (n - 1)) == 0
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// Solution to LeetCode problem: Power of Two
// https://leetcode.com/problems/power-of-two/
import "fmt"

func isPowerOfTwo(n int) bool {
    if n <= 0 {
        return false
    }
    return (n & (n - 1)) == 0
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    if (n <= 0) return false;
    return (n & (n - 1)) == 0;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_power-of-two" data="G20MAJwFdvNSwQ4aW8x+ztYY3lIkZSdBXrj+lns7Xf9ptYLoiiqdDhYseVCTLF0jHx5yVHxYtHSlOoJCtgt1UAbVjQgYubeXoTWVCl09yFIv97QuUVWiIixascimuCU1+wNs23BlwPDWjHv/R9GJyLhn4BcGrmjYstohSNbUF9HeZcuZRf7Hvg4jF2Pd4sL/UMTLBpvNw09iaZfLkfH96vP04+liWOVUOAuVMwAclPWfsy0hJHGErcwbN5h+aY99Vs4Xr35+et5l0BbufjidgJeZYKy8fSHMxluBNdRYmX9jAAwdeaK99l6QIHVBTNSvxki1JfUkEyyGBwrufXJkqchVqsZbWqpmXz13i5giv6J8fgbKWRPh/cRAoAbWzIink/F2RH8c5OtvQ6KqTYi145SAfK7ngAISAg8rxRVZKXXol3Bc1BSKnOBkeK7kovM8IuPe1Sp9e+GYgf0NWZSSHqf06hQUKMLrdYiqiMx9sp8qNDaBXXwLPOTK8UWNZwmi3bENPMYYy7mE3KtvxhxjKlkUf5XLDg54AOddc8QUdhLqw7LAP7j3abJLtslTurOUop74Ji+sa/jAAhcq4zbI/fAqdysYgssN836wemglK9r/rPc5WmixlyCRhvX1eFtyVJ895xUmoqGERpQNVofu3TP72MN2TbE+hpAFqsQyWvJSVmheTJUUygEkFDRiEwrlABybL7O15K6BGm6ISTPiFSiiV3g/qfwLOLbnC+pAWUqQHGgwcUXsnZ/f3lZoLYUkcRGCkOfFBaGLrk96JFjXWziekcgytLUv7ltn3IxyN72ATPwsdykrZUIQaf4tnIy7Mgj9BhZ1nwHoLQZhr3mm7TgcJUmyhB6TI0AcINY4PKdsShEaRjDzJMVVweU9n+0yYpCgoUr6zLOS+iBHu3ZJkiLd87aCawEXIXCWSBvBUWSIOsO7MaqPwy+YU86oLI708nuEmNyKElLzEs72WqegoSXsdjXXdnFnN889MtNsYu4JqywRpdd5+1UBG6l1Tyj1dWzHDW2FbflmJihelDofou8h/vz2Fj5OwjJ1UsATEbsuLr8ZgRNYRyQbXQQ8ZQSmMWQPaAjr8a0TaPEVZLMkYQjCmkkimXL0KixojFH3sudCAhVquyE9zi7VwRaPWyjokzVjnSaywNnLvQ/F4o+67aucN+g5R8EvM2OhUs79Dzb8m4539oY1KLUU/OngVHTRsvxjFyGM6+aOJ38XmrmKq+dXAHLJmJUrFyBMr/l6GNf0SknkpJSuZx1uu0Je2qCXKgc2Dx5CJZ4Ux10XvKkbZes23ORDJoI0uR6IZHJzPP4v4u2HAm/cYrfXDZf4qLYXM4cnkM6oXOdkBQ=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_power-of-two"></div></div>
</details><hr /><br />

**类似题目**：
  - [136. 只出现一次的数字 🟢](/problems/single-number)
  - [191. 位1的个数 🟢](/problems/number-of-1-bits)
  - [268. 丢失的数字 🟢](/problems/missing-number)
  - [剑指 Offer 15. 二进制中1的个数 🟢](/problems/er-jin-zhi-zhong-1de-ge-shu-lcof)

</details>
</div>



