<p>给你一个 <strong>升序排列</strong> 的数组 <code>nums</code> ，请你<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 删除重复出现的元素，使每个元素 <strong>只出现一次</strong> ，返回删除后数组的新长度。元素的 <strong>相对顺序</strong> 应该保持 <strong>一致</strong> 。然后返回 <code>nums</code> 中唯一元素的个数。</p>

<p>考虑 <code>nums</code> 的唯一元素的数量为 <code>k</code> ，你需要做以下事情确保你的题解可以被通过：</p>

<ul> 
 <li>更改数组 <code>nums</code> ，使 <code>nums</code> 的前 <code>k</code> 个元素包含唯一元素，并按照它们最初在 <code>nums</code> 中出现的顺序排列。<code>nums</code>&nbsp;的其余元素与 <code>nums</code> 的大小不重要。</li> 
 <li>返回 <code>k</code>&nbsp;。</li> 
</ul>

<p><strong>判题标准:</strong></p>

<p>系统会用下面的代码来测试你的题解:</p>

<pre>
int[] nums = [...]; // 输入数组
int[] expectedNums = [...]; // 长度正确的期望答案

int k = removeDuplicates(nums); // 调用

assert k == expectedNums.length;
for (int i = 0; i &lt; k; i++) {
    assert nums[i] == expectedNums[i];
}</pre>

<p>如果所有断言都通过，那么您的题解将被 <strong>通过</strong>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,2]
<strong>输出：</strong>2, nums = [1,2,_]
<strong>解释：</strong>函数应该返回新的长度 <strong><code>2</code></strong> ，并且原数组 <em>nums </em>的前两个元素被修改为 <strong><code>1</code></strong>, <strong><code>2 </code></strong><span><code>。</code></span>不需要考虑数组中超出新长度后面的元素。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,1,1,1,2,2,3,3,4]
<strong>输出：</strong>5, nums = [0,1,2,3,4]
<strong>解释：</strong>函数应该返回新的长度 <strong><code>5</code></strong> ， 并且原数组 <em>nums </em>的前五个元素被修改为 <strong><code>0</code></strong>, <strong><code>1</code></strong>, <strong><code>2</code></strong>, <strong><code>3</code></strong>, <strong><code>4</code></strong> 。不需要考虑数组中超出新长度后面的元素。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> 已按 <strong>升序</strong> 排列</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 3201, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=remove-duplicates-from-sorted-array" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 371 页。

有序序列去重的通用解法就是我们前文 [双指针技巧](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 中的快慢指针技巧。

我们让慢指针 `slow` 走在后面，快指针 `fast` 走在前面探路，找到一个不重复的元素就告诉 `slow` 并让 `slow` 前进一步。这样当 `fast` 指针遍历完整个数组 `nums` 后，**`nums[0..slow]` 就是不重复元素**。

![](https://labuladong.github.io/pictures/数组去重/1.gif)

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

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
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.size()) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        slow, fast = 0, 0
        while fast < len(nums):
            if nums[fast] != nums[slow]:
                slow += 1
                # 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast]
            fast += 1
        # 数组长度为索引 + 1
        return slow + 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func removeDuplicates(nums []int) int {
    // 如果数组为空，直接返回 0
    if len(nums) == 0 {
        return 0
    }
    // 定义快慢指针，初始化都指向数组头部
    slow, fast := 0, 0
    // 快指针向后遍历数组，直到末尾
    for fast < len(nums) {
        // 如果两个指针指向的元素不相同
        if nums[fast] != nums[slow] {
            // 慢指针向后移动，并且将慢指针位置上的值设为快指针位置上的值
            slow++
            nums[slow] = nums[fast]
        }
        // 快指针继续向后移动
        fast++
    }
    // slow 指向数组的最后一个不重复元素的位置
    // 数组长度为索引 + 1
    return slow + 1
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
var removeDuplicates = function(nums) {
    if (nums.length === 0) {
        return 0;
    }
    let slow = 0, fast = 0;
    while (fast < nums.length) {
        if (nums[fast] !== nums[slow]) {
            slow++;
            // 维护 nums[0..slow] 无重复
            nums[slow] = nums[fast];
        }
        fast++;
    }
    // 数组长度为索引 + 1
    return slow + 1;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_remove-duplicates-from-sorted-array" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-array"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [283. 移动零 🟢](/problems/move-zeroes)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [80. 删除有序数组中的重复项 II 🟠](/problems/remove-duplicates-from-sorted-array-ii)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>



