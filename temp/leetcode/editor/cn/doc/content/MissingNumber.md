<p>给定一个包含 <code>[0, n]</code>&nbsp;中&nbsp;<code>n</code>&nbsp;个数的数组 <code>nums</code> ，找出 <code>[0, n]</code> 这个范围内没有出现在数组中的那个数。</p>

<ul> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,0,1]
<strong>输出：</strong>2
<b>解释：</b>n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>2
<b>解释：</b>n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [9,6,4,2,3,5,7,0,1]
<strong>输出：</strong>8
<b>解释：</b>n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>1
<b>解释：</b>n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == nums.length</code></li> 
 <li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= nums[i] &lt;= n</code></li> 
 <li><code>nums</code> 中的所有数字都 <strong>独一无二</strong></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?</p>

<details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 哈希表 | 数学 | 二分查找 | 排序</details><br>

<div>👍 740, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=missing-number" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

假设 `nums = [0,3,1,4]`：

![](https://labuladong.github.io/pictures/缺失元素/1.jpg)

我们先把索引补一位，然后让每个元素和自己相等的索引相对应：

![](https://labuladong.github.io/pictures/缺失元素/2.jpg)

这样做了之后，就可以发现除了缺失元素之外，所有的索引和元素都组成一对儿了，现在如果把这个落单的索引 2 找出来，也就找到了缺失的那个元素。

如何找？只要把所有的元素和索引做异或运算，成对儿的数字都会消为 0，只有这个落单的元素会剩下。

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
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int res = 0;
        // 先和新补的索引异或一下
        res ^= n;
        // 和其他的元素、索引做异或
        for (int i = 0; i < n; i++)
            res ^= i ^ nums[i];
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
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        # 先和新补的索引异或一下
        res ^= n
        # 和其他的元素、索引做异或
        for i in range(n):
            res ^= i ^ nums[i]
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 先和新补的索引异或一下
        res ^= n;
        // 和其他的元素、索引做异或
        for (int i = 0; i < n; i++)
            res ^= i ^ nums[i];
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/*
 * @lc app=leetcode id=268 lang=golang
 *
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (49.34%)
 * Total Accepted:    321.9K
 * Total Submissions: 647.5K
 * Testcase Example:  '[3,0,1]'
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * Example 1:
 *
 *
 * Input: [3,0,1]
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 */

func missingNumber(nums []int) int {
    n := len(nums)
    res := 0
    // 先和新补的索引异或一下
    res ^= n
    // 和其他的元素、索引做异或
    for i := 0; i < n; i++ {
        res ^= i ^ nums[i]
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var missingNumber = function(nums) {
    let n = nums.length;
    let res = 0;
    // 先和新补的索引异或一下
    res ^= n;
    // 和其他的元素、索引做异或
    for (let i = 0; i < n; i++)
        res ^= i ^ nums[i];
    return res;
}
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_missing-number" data="G2gYERWb/yC0OLCNZQbfwujOFSdvI6UiyD/SUBjqVojcT/dVtXm/2vNAlDNfEUHDJMOEL3ZSdNWqqhMhcfXYSZoG4bXg6NLJxvfmMOTqBYNJ0GDaBusLiwaI37ffa6KIq5BufIUltOjKwr+Z2dwAoSqR7L59BST1XaMrXI9nZ6pdZAkeY5oW7X0MfxoNd4bfPYi7wYu310ECItKte/AHA3dcvFQaGmJGI73RzqtKS81+xvUCoqku/oOC/52IlUrXTI6iVdEudi0cT8oO9U6aS1A9e0AEUl0BlhsOu5asfgCSqdFd3pcoloFUxypfUHJ32HXbeBKGUyo50T6QnvPzcOvbttlA5+XclLR/zUTL6nd7hlvjccv4ksNr2QOahvFFWF+WszFSic5kCGtG80PjpRru4+my+bRtt4pEzMsUdt2+kfXh5mWo89ip6cv+F2x+0eaPrQPCyZaT+qtpAmleOanEo1/VOQBPmFCEnx/Inuw5BSPBsM+xGIlTzkELMwVm0bbT4/8NIHjLrx9xY3PYhKxqc1rxTMyJhctXazuP+3X9Bb9+Na3TkITWT/CsWrwvuegzpmzGHm3Oy4QRirDM/g+Zivnl4BcR3Reb3deg7vuA3XLojxgM/tiRwd8wGHwfqFsOHx/qy1X/NWTdyne/Xp6s7a/WHh+VYz+gLu1U8uVL0geq90WK8yjET18V8xGmOFlMCVeuCsXJEul+JmlJu+e8J3mhNk3QtazuWMUnlEiuzSLbFuusINPpt/CQ97Y1Gq6ZNkGethiVlrleLocbs2FXLXtSalfpPg/ZzrehLa2AxFd5yO2eewYsgrisrjubnyhOYslehmoy3fVsya0BCMbxxlUi0AOTJSDk4i7P8woXXUeGXWMo2QI09SzdatF/BH+2CAKddhwCHqClgMoW6qmxpFCZckkfbjAHDaDCSdxCdWV9MxtZjz7WGpXL89RP7KVdGAtpPZsgyEAE5djxX/seraQNZr5qo7GXMhC0qH/W3DE1JlwbLmJJHGEMau2aieYO06hKsJavqREdR6YSTRzgel9xCsWFzMyUQRoRigugETonlEpYBQBjZzGQ1xfQexdeyNrjz6GJXJzhgzdKuEBBqyciS+9zuLc6wmkmvsL+8jAzc+hARPEyMEyVFHNXaYKY2b5sNbm4Hzrkpw10qRZ9ikOgSZ2igDGY7Pyr6P1DKklOex1WQtnCh84k4Pd7iRoPa8h4me+FbxMUpoU2pabi4GmLWYmiWkOZY5p7Q+rfsXxDGaI1xuCYKWPnV2h2YTr75hE6YeYCqwO0FWWKTJ3wCf1s04u1i7uz4vA0SCKaPE1uuLlq3yIwjsYFkW6M0dq/ZBIQGZts39RQzbLZWQvnIqTsr12j/uxHLXIVmH1Ako/qGsX3aOyntG2ErVP3rIOv+cNPNFb3xh7uraLhFG9UBoUuvVQ0KZr2upZ6aEgDWzdLGPbOKGPKcosxkoDrTQmLgNaScM2JAaisUheMfxYFBXbvvA0FapYp4oCZ6KrcMboJmBRtdNaYe2LOBGVAmYjb3gV6vJ1Jnar7mGOrhEZtY4xP1XXnpYbfzk3VpTnWMsLlB+sPxPgVhbBifYDKL/bDiqU7Vf3/2o+Kr1pRLoF8zuXK3Zcv9yB/nUdTOYJHU7XMNB1oiJzm3tQEHtxXXbpKkpO6VFj+8Qpp/L3xwkV9u2d/9wUlSZKgnSSUfKBp4Oz72M6RHW/q0lc/8c0nuVe7D3+o97TvY8vjP/eT90MPVuuxzLROXHEFi1K0tXVL6R33ymp03QLSaMHe2Vl/ML64wVvT2UTvxFecId+abrjyQt85HAtt9Yjs5cXK/yraOT91TnGyiwfRG1fOHTleEew8exf5br2DDvraEaMpTSAse1QNAA=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_missing-number"></div></div>
</details><hr /><br />

**类似题目**：
  - [136. 只出现一次的数字 🟢](/problems/single-number)
  - [191. 位1的个数 🟢](/problems/number-of-1-bits)
  - [231. 2 的幂 🟢](/problems/power-of-two)
  - [剑指 Offer 15. 二进制中1的个数 🟢](/problems/er-jin-zhi-zhong-1de-ge-shu-lcof)

</details>
</div>



