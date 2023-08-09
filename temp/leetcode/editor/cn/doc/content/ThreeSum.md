<p>给你一个整数数组 <code>nums</code> ，判断是否存在三元组 <code>[nums[i], nums[j], nums[k]]</code> 满足 <code>i != j</code>、<code>i != k</code> 且 <code>j != k</code> ，同时还满足 <code>nums[i] + nums[j] + nums[k] == 0</code> 。请</p>

<p>你返回所有和为 <code>0</code> 且不重复的三元组。</p>

<p><strong>注意：</strong>答案中不可以包含重复的三元组。</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,0,1,2,-1,-4]
<strong>输出：</strong>[[-1,-1,2],[-1,0,1]]
<strong>解释：</strong>
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,1]
<strong>输出：</strong>[]
<strong>解释：</strong>唯一可能的三元组和不为 0 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,0]
<strong>输出：</strong>[[0,0,0]]
<strong>解释：</strong>唯一可能的三元组和为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>3 &lt;= nums.length &lt;= 3000</code></li> 
 <li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>

<div>👍 6053, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=3sum" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 319 页。

nSum 系列问题的核心思路就是**排序 + 双指针**。

先给数组从小到大排序，然后双指针 `lo` 和 `hi` 分别在数组开头和结尾，这样就可以控制 `nums[lo]` 和 `nums[hi]` 这两数之和的大小：

如果你想让它俩的和大一些，就让 `lo++`，如果你想让它俩的和小一些，就让 `hi--`。

![](https://labuladong.github.io/pictures/nSum/1.jpeg)

基于两数之和可以得到一个万能函数 `nSumTarget`，扩展出 n 数之和的解法，具体分析见详细题解。

**详细题解：[一个方法团灭 nSum 问题](https://labuladong.github.io/article/fname.html?fname=nSum)**

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，递归**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">cpp🟢</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">java🤖</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item active" data-tab-group="default"><div class="highlight">

```cpp
class Solution {
    public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        // n 为 3，从 nums[0] 开始计算和为 0 的三元组
        return nSumTarget(nums, 3, 0, 0);
    }

    /* 注意：调用这个函数之前一定要先给 nums 排序 */
    // n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
    vector<vector<int>> nSumTarget(
            vector<int>& nums, int n, int start, int target) {

        int sz = nums.size();
        vector<vector<int>> res;
        // 至少是 2Sum，且数组大小不应该小于 n
        if (n < 2 || sz < n) return res;
        // 2Sum 是 base case
        if (n == 2) {
            // 双指针那一套操作
            int lo = start, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    res.push_back({left, right});
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
        } else {
            // n > 2 时，递归计算 (n-1)Sum 的结果
            for (int i = start; i < sz; i++) {
                vector<vector<int>>
                        sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (vector<int>& arr : sub) {
                    // (n-1)Sum 加上 nums[i] 就是 nSum
                    arr.push_back(nums[i]);
                    res.push_back(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        # n 为 3，从 nums[0] 开始计算和为 0 的三元组
        return self.nSumTarget(nums, 3, 0, 0)

    # 注意：调用这个函数之前一定要先给 nums 排序
    # n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
    def nSumTarget(self, nums: List[int], n: int, start: int, target: int) -> List[List[int]]:
        sz = len(nums)
        res = []
        # 至少是 2Sum，且数组大小不应该小于 n
        if n < 2 or sz < n:
            return res
        # 2Sum 是 base case
        if n == 2:
            # 双指针那一套操作
            lo, hi = start, sz - 1
            while lo < hi:
                s = nums[lo] + nums[hi]
                left, right = nums[lo], nums[hi]
                if s < target:
                    while lo < hi and nums[lo] == left:
                        lo += 1
                elif s > target:
                    while lo < hi and nums[hi] == right:
                        hi -= 1
                else:
                    res.append([left, right])
                    while lo < hi and nums[lo] == left:
                        lo += 1
                    while lo < hi and nums[hi] == right:
                        hi -= 1
        else:
            # n > 2 时，递归计算 (n-1)Sum 的结果
            for i in range(start, sz):
                sub = self.nSumTarget(nums, n - 1, i + 1, target - nums[i])
                for arr in sub:
                    # (n-1)Sum 加上 nums[i] 就是 nSum
                    arr.append(nums[i])
                    res.append(arr)
                while i < sz - 1 and nums[i] == nums[i + 1]:
                    i += 1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item " data-tab-group="default"><div class="highlight">

```java
// 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // n 为 3，从 nums[0] 开始计算和为 0 的三元组
        return nSumTarget(nums, 3, 0, 0);
    }

    /* 注意：调用这个函数之前一定要先给 nums 排序 */
    // n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
    public List<List<Integer>> nSumTarget(
            int[] nums, int n, int start, int target) {

        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 至少是 2Sum，且数组大小不应该小于 n
        if (n < 2 || sz < n) return res;
        // 2Sum 是 base case
        if (n == 2) {
            // 双指针那一套操作
            int lo = start, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
        } else {
            // n > 2 时，递归计算 (n-1)Sum 的结果
            for (int i = start; i < sz; i++) {
                List<List<Integer>>
                        sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    // (n-1)Sum 加上 nums[i] 就是 nSum
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func threeSum(nums []int) [][]int {
    sort.Ints(nums)
    // n 为 3，从 nums[0] 开始计算和为 0 的三元组
    return nSumTarget(nums, 3, 0, 0)
}

/* 注意：调用这个函数之前一定要先给 nums 排序 */
// n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
func nSumTarget(nums []int, n int, start int, target int) [][]int {
    sz := len(nums)
    var res [][]int
    // 至少是 2Sum，且数组大小不应该小于 n
    if n < 2 || sz < n {
        return res
    }
    // 2Sum 是 base case
    if n == 2 {
        // 双指针那一套操作
        lo, hi := start, sz-1
        for lo < hi {
            sum := nums[lo] + nums[hi]
            left, right := nums[lo], nums[hi]
            if sum < target {
                for lo < hi && nums[lo] == left {
                    lo++
                }
            } else if sum > target {
                for lo < hi && nums[hi] == right {
                    hi--
                }
            } else {
                res = append(res, []int{left, right})
                for lo < hi && nums[lo] == left {
                    lo++
                }
                for lo < hi && nums[hi] == right {
                    hi--
                }
            }
        }
    } else {
        // n > 2 时，递归计算 (n-1)Sum 的结果
        for i := start; i < sz; i++ {
            sub := nSumTarget(nums, n-1, i+1, target-nums[i])
            for _, arr := range sub {
                // (n-1)Sum 加上 nums[i] 就是 nSum
                arr = append(arr, nums[i])
                res = append(res, arr)
            }
            for i < sz-1 && nums[i] == nums[i+1] {
                i++
            }
        }
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var threeSum = function(nums) {
  nums.sort((a, b) => a - b);
  // n 为 3，从 nums[0] 开始计算和为 0 的三元组
  return nSumTarget(nums, 3, 0, 0);
}

/* 注意：调用这个函数之前一定要先给 nums 排序 */
// n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
var nSumTarget = function(nums, n, start, target) {
  var sz = nums.length;
  var res = [];
  // 至少是 2Sum，且数组大小不应该小于 n
  if (n < 2 || sz < n) return res;
  // 2Sum 是 base case
  if (n == 2) {
    // 双指针那一套操作
    var lo = start, hi = sz - 1;
    while (lo < hi) {
      var sum = nums[lo] + nums[hi];
      var left = nums[lo], right = nums[hi];
      if (sum < target) {
        while (lo < hi && nums[lo] == left) lo++;
      } else if (sum > target) {
        while (lo < hi && nums[hi] == right) hi--;
      } else {
        res.push([left, right]);
        while (lo < hi && nums[lo] == left) lo++;
        while (lo < hi && nums[hi] == right) hi--;
      }
    }
  } else {
    // n > 2 时，递归计算 (n-1)Sum 的结果
    for (var i = start; i < sz; i++) {
      var sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
      for (var j = 0; j < sub.length; j++) {
        // (n-1)Sum 加上 nums[i] 就是 nSum
        sub[j].push(nums[i]);
        res.push(sub[j]);
      }
      while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
    }
  }
  return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_3sum" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_3sum"></div></div>
</details><hr /><br />

**类似题目**：
  - [1. 两数之和 🟢](/problems/two-sum)
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [18. 四数之和 🟠](/problems/4sum)
  - [剑指 Offer II 007. 数组中和为 0 的三个数 🟠](/problems/1fGaJU)

</details>
</div>





