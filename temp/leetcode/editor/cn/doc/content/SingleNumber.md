<p>给你一个 <strong>非空</strong> 整数数组 <code>nums</code> ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。</p>

<p>你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。</p>

<div class="original__bRMd"> 
 <div> 
  <p>&nbsp;</p> 
 </div>
</div>

<p><strong class="example">示例 1 ：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,2,1]
<strong>输出：</strong>1
</pre>

<p><strong class="example">示例 2 ：</strong></p>

<pre>
<strong>输入：</strong>nums = [4,1,2,1,2]
<strong>输出：</strong>4
</pre>

<p><strong class="example">示例 3 ：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>-3 * 10<sup>4</sup> &lt;= nums[i] &lt;= 3 * 10<sup>4</sup></code></li> 
 <li>除了某个元素只出现一次以外，其余每个元素均出现两次。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>位运算 | 数组</details><br>

<div>👍 2888, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=single-number" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这里就可以运用异或运算的性质：

一个数和它本身做异或运算结果为 0，即 `a ^ a = 0`；一个数和 0 做异或运算的结果为它本身，即 `a ^ 0 = a`。

对于这道题目，我们只要把所有数字进行异或，成对儿的数字就会变成 0，落单的数字和 0 做异或还是它本身，所以最后异或的结果就是只出现一次的元素。

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
    int singleNumber(vector<int>& nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
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
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        for n in nums:
            res ^= n
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param nums: List[int]
 * @return: int
 */
func singleNumber(nums []int) int {
    res := 0
    for _, n := range nums {
        res ^= n
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let res = 0;
    for (let n of nums) {
        res ^= n;
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_single-number" data="G8QTIByHsfNkoZn/LqUVLgqRybbs9WX2VeGmUeTMKyIxIiQhyNZxY5vHIYRFa2tr5cfv94tm3s0OJRBpXgKVEJmZ+w9m6fER8foMWFFvkLdtTtsbsgynLYOqBLFa/jCZ/7MIu9mbj92KR2zefJzFDwyckparb4gcDfSRfHtVL5X7H/fKGYZu5lwH/2ciHrtRsjDssVCad5o3xjJCXZPi4lNyFlH9H7ucHzvsu38xZYtFtHa0l+9DFAunthdl4pwg5b57URkYJP+Rs0kYT/rC39O9X5WXgeobm2UU7hUJ45u/jUkOsq0YXNL+lVnEZRhvvPoB3ZaiVaQt6cMSW/wcZu4d5RWnZPKLGxQ/5zpHwvye0tv1Qy6HiHdEME6evuJwX5749+cktwM7IobYAW5Wp44PSs742IwV3uEOjDucB4IchOUdZNroj+MPG/3V3T97J9aNDnLqnyfYmurT99TGuFaRXVpkTVGNea0yu7TMmuLcTFc0bYp981QW/8JiP3D12d+SBM/c93d7YyUfTD3E5p1ekBP0lELAblMjbw1jh0SeYZFL2p6xTaLVLb+3HQPARwfgkTuAXgN4Vzax+2k96RbNeULLhZZYa3E+NmhtMU9hYnvbjaHVlUvusT2OXvoCjmxGDZJ2ehF4Bi0gd/gA65rWXy0sPNju5cnQU0nc9Jl9rSA7YFr3sMIWUUFQ2PMFGV4TIl2C6IAlHl2IROkkWEGlrvWMXAbDsqAp6QPnJ399x8xCCDxWpIZuUI5gI47/7DqvWCwxIh2dPek2KNfeOkt5lQyepUYIhQQLRA8a51KsZQ2GXbKWCC8ZbEAVU+IKcjDrYSB9TogcjJVOUehzQsBoNEVciT1CBPpIWU20QwjbfMGOG4d/IU7seYAJPpTyQBpSYKLY0DecHm1yPDHXNvIkTgi05QEKVVAqjBc1qt6Mk/9FlJ0w0cV95xp/3IBWSsY/nNo4VTEKyYqWD22CqbYaIlI9ARaivvfQFBHw7ddStHXbCkb1j8IbHZHjlVEsJBaHy+jQchBsKwX5ZXRUEvde5JdnISkpDbyQQHg/ra5D9dlSdTKNnLtscuggMRPyHkFZEAqueUmnd1kC/NoH7JyehMEG7utHjhXDMmGIhdAqoNe2Rp4EYEDZVucsag+zW56tC1ZAQ1z64gRibF0nlv7ayFA6Ln1ufyRZNp11phYfqQYTdh0flQrNMX16tAmGpBYUqaT/8sX/8q6N6Ikq6oEhKULbp2KFLgA2/BAraJJw/aRlhKIBqkmCwCMEqmIl9Oz491KQq5Zckp7ZNcUGLGM03uHcWELVNSotXenII7NChlIL5d+0FWOOWNedmjpXnH5NGuJgpBu8vmr4k9wYuJXHyy+vH0PzNVrJ2uy6Kp53WyvpvZUp/q2q/7GxtnZzE7O17PsfUPrfkFrz12/OEB4GNnRfQvTNgJ4NJsi9wE1Q8J9gRQdvNXurS7Is87PZoEY54+DTXv1W5gL6PWZdk6mQWvPuO5ETB+ZVs49oKMDeue3KnRm/L/2UfbHW3pVWILiYeKuf/M+h9JTrvn3DMk423HB6NS8A"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_single-number"></div></div>
</details><hr /><br />

**类似题目**：
  - [191. 位1的个数 🟢](/problems/number-of-1-bits)
  - [231. 2 的幂 🟢](/problems/power-of-two)
  - [268. 丢失的数字 🟢](/problems/missing-number)
  - [剑指 Offer 15. 二进制中1的个数 🟢](/problems/er-jin-zhi-zhong-1de-ge-shu-lcof)

</details>
</div>



