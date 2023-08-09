<p><code>nums1</code>&nbsp;中数字&nbsp;<code>x</code>&nbsp;的 <strong>下一个更大元素</strong> 是指&nbsp;<code>x</code>&nbsp;在&nbsp;<code>nums2</code> 中对应位置 <strong>右侧</strong> 的 <strong>第一个</strong> 比&nbsp;<code>x</code><strong>&nbsp;</strong>大的元素。</p>

<p>给你两个<strong> 没有重复元素</strong> 的数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code> ，下标从 <strong>0</strong> 开始计数，其中<code>nums1</code>&nbsp;是&nbsp;<code>nums2</code>&nbsp;的子集。</p>

<p>对于每个 <code>0 &lt;= i &lt; nums1.length</code> ，找出满足 <code>nums1[i] == nums2[j]</code> 的下标 <code>j</code> ，并且在 <code>nums2</code> 确定 <code>nums2[j]</code> 的 <strong>下一个更大元素</strong> 。如果不存在下一个更大元素，那么本次查询的答案是 <code>-1</code> 。</p>

<p>返回一个长度为&nbsp;<code>nums1.length</code> 的数组<em> </em><code>ans</code><em> </em>作为答案，满足<em> </em><code>ans[i]</code><em> </em>是如上所述的 <strong>下一个更大元素</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [4,1,2], nums2 = [1,3,4,2].
<strong>输出：</strong>[-1,3,-1]
<strong>解释：</strong>nums1 中每个值的下一个更大元素如下所述：
- 4 ，用加粗斜体标识，nums2 = [1,3,<strong>4</strong>,2]。不存在下一个更大元素，所以答案是 -1 。
- 1 ，用加粗斜体标识，nums2 = [<em><strong>1</strong></em>,3,4,2]。下一个更大元素是 3 。
- 2 ，用加粗斜体标识，nums2 = [1,3,4,<em><strong>2</strong></em>]。不存在下一个更大元素，所以答案是 -1 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [2,4], nums2 = [1,2,3,4].
<strong>输出：</strong>[3,-1]
<strong>解释：</strong>nums1 中每个值的下一个更大元素如下所述：
- 2 ，用加粗斜体标识，nums2 = [1,<em><strong>2</strong></em>,3,4]。下一个更大元素是 3 。
- 4 ，用加粗斜体标识，nums2 = [1,2,3,<em><strong>4</strong></em>]。不存在下一个更大元素，所以答案是 -1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums1.length &lt;= nums2.length &lt;= 1000</code></li> 
 <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums1</code>和<code>nums2</code>中所有整数 <strong>互不相同</strong></li> 
 <li><code>nums1</code> 中的所有整数同样出现在 <code>nums2</code> 中</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以设计一个时间复杂度为 <code>O(nums1.length + nums2.length)</code> 的解决方案吗？</p>

<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 哈希表 | 单调栈</details><br>

<div>👍 1038, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=next-greater-element-i" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

[单调栈模板](https://labuladong.github.io/article/fname.html?fname=单调栈) 实现了一个计算下一个更大元素的函数，这里可以直接复用。因为题目说 `nums1` 是 `nums2` 的子集，那么我们先把 `nums2` 中每个元素的下一个更大元素算出来存到一个映射里，然后再让 `nums1` 中的元素去查表即可。

**详细题解：[单调栈结构解决三道算法题](https://labuladong.github.io/article/fname.html?fname=单调栈)**

**标签：单调栈，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

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
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        // 记录 nums2 中每个元素的下一个更大元素
        vector<int> greater = nextGreaterElement(nums2);
        // 转化成映射：元素 x -> x 的下一个最大元素
        map<int, int> greaterMap;
        for (int i = 0; i < nums2.size(); i++) {
            greaterMap[nums2[i]] = greater[i];
        }
        // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        vector<int> res(nums1.size());
        for (int i = 0; i < nums1.size(); i++) {
            res[i] = greaterMap[nums1[i]];
        }
        return res;
    }

    // 计算 nums 中每个元素的下一个更大元素
    vector<int> nextGreaterElement(vector<int>& nums) {
        int n = nums.size();
        // 存放答案的数组
        vector<int> res(n);
        stack<int> s;
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.empty() && s.top() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的下一个更大元素
            res[i] = s.empty() ? -1 : s.top();
            s.push(nums[i]);
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
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # 记录 nums2 中每个元素的下一个更大元素
        greater = self.nextGreater(nums2)
        # 转化成映射：元素 x -> x 的下一个最大元素
        greaterMap = {}
        for i in range(len(nums2)):
            greaterMap[nums2[i]] = greater[i]
        # nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        res = []
        for num in nums1:
            res.append(greaterMap[num])
        return res

    # 计算 nums 中每个元素的下一个更大元素
    def nextGreater(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # 存放答案的数组
        res = [-1] * n
        s = []
        # 倒着往栈里放
        for i in range(n - 1, -1, -1):
            # 判定个子高矮
            while s and s[-1] <= nums[i]:
                # 矮个起开，反正也被挡着了。。。
                s.pop()
            # nums[i] 身后的下一个更大元素
            if s:
                res[i] = s[-1]
            s.append(nums[i])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 记录 nums2 中每个元素的下一个更大元素
        int[] greater = nextGreaterElement(nums2);
        // 转化成映射：元素 x -> x 的下一个最大元素
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }
        // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    // 计算 nums 中每个元素的下一个更大元素
    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的下一个更大元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
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

import "fmt"

func nextGreaterElement(nums1 []int, nums2 []int) []int {
    // 记录 nums2 中每个元素的下一个更大元素
    greater := nextGreater(nums2)
    // 转化成映射：元素 x -> x 的下一个最大元素
    greaterMap := make(map[int]int)
    for i, v := range nums2 {
        greaterMap[v] = greater[i]
    }
    // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
    res := make([]int, len(nums1))
    for i, v := range nums1 {
        res[i] = greaterMap[v]
    }
    return res
}

// 计算 nums 中每个元素的下一个更大元素
func nextGreater(nums []int) []int {
    n := len(nums)
    // 存放答案的数组
    res := make([]int, n)
    s := []int{}
    // 倒着往栈里放
    for i := n - 1; i >= 0; i-- {
        // 判定个子高矮
        for len(s) != 0 && s[len(s)-1] <= nums[i] {
            // 矮个起开，反正也被挡着了。。。
            s = s[:len(s)-1]
        }
        // nums[i] 身后的下一个更大元素
        if len(s) == 0 {
            res[i] = -1
        } else {
            res[i] = s[len(s)-1]
        }
        s = append(s, nums[i])
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var nextGreaterElement = function(nums1, nums2) {
    // 记录 nums2 中每个元素的下一个更大元素
    var greater = nextGreater(nums2);
    // 转化成映射：元素 x -> x 的下一个最大元素
    var greaterMap = new Map();
    for (var i = 0; i < nums2.length; i++) {
        greaterMap.set(nums2[i], greater[i]);
    }
    // nums1 是 nums2 的子集，所以根据 greaterMap 可以得到结果
    var res = new Array(nums1.length);
    for (var i = 0; i < nums1.length; i++) {
        res[i] = greaterMap.get(nums1[i]);
    }
    return res;
};

// 计算 nums 中每个元素的下一个更大元素
var nextGreater = function(nums) {
    var n = nums.length;
    // 存放答案的数组
    var res = new Array(n);
    var s = [];
    // 倒着往栈里放
    for (var i = n - 1; i >= 0; i--) {
        // 判定个子高矮
        while (s.length && s[s.length-1] <= nums[i]) {
            // 矮个起开，反正也被挡着了。。。
            s.pop();
        }
        // nums[i] 身后的下一个更大元素
        res[i] = s.length == 0 ? -1 : s[s.length-1];
        s.push(nums[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_next-greater-element-i" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_next-greater-element-i"></div></div>
</details><hr /><br />

**类似题目**：
  - [503. 下一个更大元素 II 🟠](/problems/next-greater-element-ii)
  - [739. 每日温度 🟠](/problems/daily-temperatures)
  - [剑指 Offer II 038. 每日温度 🟠](/problems/iIQa4I)

</details>
</div>



