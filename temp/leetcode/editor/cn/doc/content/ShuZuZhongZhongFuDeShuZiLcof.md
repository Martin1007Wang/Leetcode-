<p>找出数组中重复的数字。</p>

<p><br> 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。</br></p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
[2, 3, 1, 0, 2, 5, 3]
<strong>输出：</strong>2 或 3 
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>2 &lt;= n &lt;= 100000</code></p>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 排序</details><br>

<div>👍 1185, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [442. 数组中重复的数据](/problems/find-all-duplicates-in-an-array) 几乎一样，可以先去看看我写的那道题的思路。

这道题唯一的区别就是不需要做索引偏移了，而且需要把 0 拿出来单独处理，直接看解法吧。

**标签：哈希表，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int findRepeatNumber(vector<int>& nums) {
        for (int num : nums) {
            if (nums[abs(num)] < 0) {
                // 之前已经把对应索引的元素变成负数了，
                // 这说明 num 重复出现了两次
                return abs(num);
            } else {
                // 把索引 num 的元素置为负数
                nums[abs(num)] *= -1;
            }
        }
        // 如果没有在 for 循环中返回，说明重复的那个元素是 0
        return 0;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        for num in nums:
            if nums[abs(num)] < 0:
                # 之前已经把对应索引的元素变成负数了，
                # 这说明 num 重复出现了两次
                return abs(num)
            else:
                # 把索引 num 的元素置为负数
                nums[abs(num)] *= -1
        # 如果没有在 for 循环中返回，说明重复的那个元素是 0
        return 0
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int num : nums) {
            if (nums[Math.abs(num)] < 0) {
                // 之前已经把对应索引的元素变成负数了，
                // 这说明 num 重复出现了两次
                return Math.abs(num);
            } else {
                // 把索引 num 的元素置为负数
                nums[Math.abs(num)] *= -1;
            }
        }
        // 如果没有在 for 循环中返回，说明重复的那个元素是 0
        return 0;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func findRepeatNumber(nums []int) int {
    for _, num := range nums {
        if nums[abs(num)] < 0 {
            // 之前已经把对应索引的元素变成负数了，
            // 这说明 num 重复出现了两次
            return abs(num)
        } else {
            // 把索引 num 的元素置为负数
            nums[abs(num)] *= -1
        }
    }
    // 如果没有在 for 循环中返回，说明重复的那个元素是 0
    return 0
}

func abs(num int) int {
    if num < 0 {
        return -num
    }
    return num
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
var findRepeatNumber = function(nums) {
    for (let num of nums) {
        if (nums[Math.abs(num)] < 0) {
            // 之前已经把对应索引的元素变成负数了，
            // 这说明 num 重复出现了两次
            return Math.abs(num);
        } else {
            // 把索引 num 的元素置为负数
            nums[Math.abs(num)] *= -1;
        }
    }
    // 如果没有在 for 循环中返回，说明重复的那个元素是 0
    return 0;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_shu-zu-zhong-zhong-fu-de-shu-zi-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_shu-zu-zhong-zhong-fu-de-shu-zi-lcof"></div></div>
</details><hr /><br />

</details>
</div>



