<p>给定一个长度为 <code>n</code> 的整数数组&nbsp;<code>height</code>&nbsp;。有&nbsp;<code>n</code>&nbsp;条垂线，第 <code>i</code> 条线的两个端点是&nbsp;<code>(i, 0)</code>&nbsp;和&nbsp;<code>(i, height[i])</code>&nbsp;。</p>

<p>找出其中的两条线，使得它们与&nbsp;<code>x</code>&nbsp;轴共同构成的容器可以容纳最多的水。</p>

<p>返回容器可以储存的最大水量。</p>

<p><strong>说明：</strong>你不能倾斜容器。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg" /></p>

<pre>
<strong>输入：</strong>[1,8,6,2,5,4,8,3,7]
<strong>输出：</strong>49 
<strong>解释：</strong>图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为&nbsp;49。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>height = [1,1]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == height.length</code></li> 
 <li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 双指针</details><br>

<div>👍 4368, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=container-with-most-water" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题前文 [接雨水问题详解](https://labuladong.github.io/article/fname.html?fname=接雨水) 讲过的 [42. 接雨水](/problems/trapping-rain-water) 几乎一模一样。

区别在于：接雨水问题给出的类似一幅直方图，每个横坐标都有宽度，而本题给出的每个坐标是一条竖线，没有宽度。

接雨水问题更难一些，每个坐标对应的矩形通过左右的最大高度的最小值推算自己能装多少水：

![](https://labuladong.github.io/pictures/接雨水/5.jpg)

本题可完全套用接雨水问题的思路，相对还更简单：

**用 `left` 和 `right` 两个指针从两端向中心收缩，一边收缩一边计算 `[left, right]` 之间的矩形面积，取最大的面积值即是答案**。

不过肯定有读者会问，下面这段 if 语句为什么要移动较低的一边：

```java
// 双指针技巧，移动较低的一边
if (height[left] < height[right]) {
    left++;
} else {
    right--;
}
```

**其实也好理解，因为矩形的高度是由 `min(height[left], height[right])` 即较低的一边决定的**：

你如果移动较低的那一边，那条边可能会变高，使得矩形的高度变大，进而就「有可能」使得矩形的面积变大；相反，如果你去移动较高的那一边，矩形的高度是无论如何都不会变大的，所以不可能使矩形的面积变得更大。

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
    int maxArea(vector<int>& height) {
        int left = 0, right = height.size() - 1;
        int res = 0;
        while (left < right) {
            // [left, right] 之间的矩形面积
            int cur_area = min(height[left], height[right]) * (right - left);
            res = max(res, cur_area);
            // 双指针技巧，移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
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
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height)-1
        res = 0
        while left < right:
            # [left, right] 之间的矩形面积
            cur_area = min(height[left], height[right]) * (right - left)
            res = max(res, cur_area)
            # 双指针技巧，移动较低的一边
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            // [left, right] 之间的矩形面积
            int cur_area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cur_area);
            // 双指针技巧，移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
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

func maxArea(height []int) int {
    left, right := 0, len(height)-1
    res := 0
    for left < right {
        // [left, right] 之间的矩形面积
        curArea := func() int {
            if height[left] < height[right] {
                return height[left] * (right - left)
            }
            return height[right] * (right - left)
        }()
        res = func() int {
            if curArea > res {
                return curArea
            }
            return res
        }()
        // 双指针技巧，移动较低的一边
        if height[left] < height[right] {
            left++
        } else {
            right--
        }
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
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let left = 0, right = height.length - 1;
    let res = 0;
    while (left < right) {
        // [left, right] 之间的矩形面积
        const cur_area = Math.min(height[left], height[right]) * (right - left);
        res = Math.max(res, cur_area);
        // 双指针技巧，移动较低的一边
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_container-with-most-water" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_container-with-most-water"></div></div>
</details><hr /><br />

**类似题目**：
  - [42. 接雨水 🔴](/problems/trapping-rain-water)

</details>
</div>



