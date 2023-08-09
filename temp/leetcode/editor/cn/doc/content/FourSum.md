<p>给你一个由 <code>n</code> 个整数组成的数组&nbsp;<code>nums</code> ，和一个目标值 <code>target</code> 。请你找出并返回满足下述全部条件且<strong>不重复</strong>的四元组&nbsp;<code>[nums[a], nums[b], nums[c], nums[d]]</code>&nbsp;（若两个四元组元素一一对应，则认为两个四元组重复）：</p>

<ul> 
 <li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li> 
 <li><code>a</code>、<code>b</code>、<code>c</code> 和 <code>d</code> <strong>互不相同</strong></li> 
 <li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li> 
</ul>

<p>你可以按 <strong>任意顺序</strong> 返回答案 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,0,-1,0,-2,2], target = 0
<strong>输出：</strong>[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,2,2,2,2], target = 8
<strong>输出：</strong>[[2,2,2,2]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 200</code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>

<div>👍 1620, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=4sum" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 319 页。

nSum 系列问题的核心思路就是**排序 + 双指针**。

先给数组从小到大排序，然后双指针 `lo` 和 `hi` 分别在数组开头和结尾，这样就可以控制 `nums[lo]` 和 `nums[hi]` 这两数之和的大小：

如果你想让它俩的和大一些，就让 `lo++`，如果你想让它俩的和小一些，就让 `hi--`。

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
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        // n 为 4，从 nums[0] 开始计算和为 target 的四元组
        return nSumTarget(nums, 4, 0, target);
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
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        # n 为 4，从 nums[0] 开始计算和为 target 的四元组
        return self.nSumTarget(nums, 4, 0, target)
        
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
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        // n 为 4，从 nums[0] 开始计算和为 target 的四元组
        return nSumTarget(nums, 4, 0, target);
    }

    /* 注意：调用这个函数之前一定要先给 nums 排序 */
    // n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
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
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
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

func fourSum(nums []int, target int) [][]int {
    sort.Ints(nums)
    // n 为 4，从 nums[0] 开始计算和为 target 的四元组
    return nSumTarget(nums, 4, 0, target)
}

/* 注意：调用这个函数之前一定要先给 nums 排序 */
// n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
func nSumTarget(nums []int, n, start, target int) [][]int {
    sz := len(nums)
    res := [][]int{}
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

var fourSum = function(nums, target) {
  nums.sort((a, b) => a - b);
  // n 为 4，从 nums[0] 开始计算和为 target 的四元组
  return nSumTarget(nums, 4, 0, target);
};

/* 注意：调用这个函数之前一定要先给 nums 排序 */
// n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
var nSumTarget = function(nums, n, start, target) {
  var sz = nums.length;
  var res = [];
  // 至少是 2Sum，且数组大小不应该小于 n
  if (n < 2 || sz < n) return res;
  // 2Sum 是 base case
  if (n === 2) {
    // 双指针那一套操作
    var lo = start, hi = sz - 1;
    while (lo < hi) {
      var sum = nums[lo] + nums[hi];
      var left = nums[lo], right = nums[hi];
      if (sum < target) {
        while (lo < hi && nums[lo] === left) lo++;
      } else if (sum > target) {
        while (lo < hi && nums[hi] === right) hi--;
      } else {
        res.push([left, right]);
        while (lo < hi && nums[lo] === left) lo++;
        while (lo < hi && nums[hi] === right) hi--;
      }
    }
  } else {
    // n > 2 时，递归计算 (n-1)Sum 的结果
    for (var i = start; i < sz; i++) {
      var sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
      for (var arr of sub) {
        // (n-1)Sum 加上 nums[i] 就是 nSum
        arr.push(nums[i]);
        res.push(arr);
      }
      while (i < sz - 1 && nums[i] === nums[i + 1]) i++;
    }
  }
  return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_4sum" data="W6BIMzOgxxFG2GNQodx2BXcrPggVXMoMELdDoArqdYhqfWAbyxy7d4HQj47e4FBbu30QcJ9ijqx5ZfRC5dyejhvZ+h3GtGwhn/pYoZ8iL81ywG7avLxIhvLwhXX4zSKS0nVRp9ffG6WEvwLwSA4a5pTQwjmVPVkiFzCmEgacQTpC4Vw+7VTd/gcZyw+CIpj6XVrY26Bpi6S6BJjSrvKv5G+TgY1rCIGQue2r3I7Kiz7OGucbx5DkS/w3bNvYF8wK+36tPHdb/k5xALuiLAoZxcLvvP5v+hgmwPBnAsRq61SA3dpERqrI+L3LlO4+Ecl2CgxsCN11pdQG2Naf0mkYyXhOGteV3VlKqTAA0ztmaATtm+vLeFgwUKmCyBCyNX4UO5vel+Q+Q+CxQ0cAkCx1T7vtBfwCfV+iapUCJHqHBJAQtNhCP3/HmiQhehowGwkZwZaRBI2+b8KoCMDOYA4Zhqi4+MfyOdtXkQOz/NtpkGBMFvoYqt8bRf+Kia9UZxdQR6jGIBVcTgql8PnFar/LofVxHLcmEkXjxyx5CrfxYW1ZMLQDkxSb47EE6bZjYRVIEVYDN/vyTB1JwSCzuc8nV3Qbv3L+T8uH5Kz8ky9f4Jq2fMPMsCAs8zF9QVQM+g+/MUxrPn0guPBXIiaSiSsdS5W+lhcvNbts5JyOGq9JZbp0zKl+8wDi39jvQRH3TLu+Cd8P6bKePpUzj5oNiDCqYnxKli/lYdfC+8vgzUPDHvZ7NPmfQk/J6BykJfSe5mJYcxP14OLfX6Egs91rqFMnsDnx6Mepmtiu3OS4SV/+T2nKi1zqpbSruQVSmlSS1WmFJfq1+tH54YUwJsHb4Zh7rQlE73GrMUeYz91MQeVzeRrzSbTnDJ5qOT7DNO9OYPPpBDRNCMGKm5em2wk3vZ1I01cRjGL/eCxbm7kL5c0Jz0GGtwmCMx4xCSWxx+M28alR+T3Rah+LVLvKIAicmfyLi7eYpuTiypdRdGa6rWtxpGpEH+A9anqh+lA7j0EnUNuNNFRSH1Z6jR26iPJrWtEFutzw2bH0+WblI7DLB5gD8MHDGoAPsAPgY7Aoz+wgANzhv9gRoXGFmQiOS0hdjliAT/yX5V7VrIDY5HhVArN6BW7Sy5WhsyzxMKt2vmIMHcaKrprm1uvR3w9BZPy2/nu2lrTf13013Q93J3D9qE77NWZNVzLOkHPeHEayUkG0Xs89mLATWdjp6Y1fS3yNy+uqWy9QE86z97/QzOvuGS4bU4LLp3CMTmmA64via0ogOXpV6+xTwJz2dDaIW59w/UO+4fU0csuu12iUH2/aD1O/gv3iBxgTWGOtybjdnvuY33uud0ZhF4zwT2JMBxtiDM1+MvBzoYfNBebFrlU0NhbPrg6DOdO77IO5E6XStBEtXaAvonNP2wubR0ykO0I9WReNljqoMkpwneAMjnWaSCMynwY1j6qOop6ii66WSow1lUCgQd8o0tcj8CwJz60ysz0/rjXyG50KMeGeAdpjpSq6eO/GlOs9y6jqsvqg54m+1D31266fSqLjH5TeSq+s+vfFemJWLKkrLOvGQvuKGBau9xNMjbAEJkNkoxz4ZX6DP42xYfF81sqy7FbqTTdr8pgQLawyqbtqr53xRLaJlscferPc7v7on7p9WxkQn8U+l2M+Bb+MVA7ZL9e79Nse6R5Vb+9gx2MsYWtOCYHnCC3T9d5CHmss+qhSXozoawwaw7mNfEPDpEk8daWxjmUtMvSezi3g8WrLkExvYC4Gk18BV6a2H6SBgI7UTmi1AqaA2t7RDJmu3ftI0Nnh2SxBr8zqZ6QxgnZkZXQBh6A50PZeCXZ2RIK9sqifSqOC7Sgaxqh4U9u/uY2bWrZjdetop4fVDXitc7iWU8/XWTfdLC2vuuNmOKgjALL/k+/QbxRn2rB8IexhEhke3DTwGY+Nihgr9o236mgRWiRe7MzaFuAFmVBfO+RLl0A0C2PqCFKJDtaVNr4q+Mj1TpwR54B4x2ONVsJ2dYzb5HPU5xPeKup+u/XWy0k2YmIGV99h/RU+HXaKIL1pIV/Hy602K8ZmtE6nAUNvhbX9nC4MEaBP+mlqd6rOW98XrUANAHy1wHpE0Smcx3RGDn07MJrveMwDh45l7AWlkiFeW3kjxk8Vmt0IIBqAzgBQJ6ZjzYagnTSmBy32bB9Ch3nW0BJKmYCNPZyjalaWO4R9TEemaS4OQDq8ZTgMhckM42nYh+DFLDRamnUMCAQ6cwr9MP+pXFo30AiJActjXOWrCiJOhrY7bQMmhZP0fJxY5+BNOs/S0k166Qa6dIOc6KxjxEhn2x4NZDkNaNqOekIXPVoqCtznBdcZyvxDTxECgOrFEarldINLGX/PvbTEHvCwDW4aUgBBJ4I1Oq3ZFqKqWPyOQa857baCqokmjKkjCFYXE1tB+Q77sReCYQRhAR/sggkRN9c1rsm0uPp39ykzn9qqO+C+bfDnvZoNksFBFhEgGjaBj60wYh8bNCIzctE6ioGhsCKLBmggYuDUjjTSGBGTUoe+8PQY5GGpM8UogusMbebfaHqM5tUoQiuGbxBJwN/7hNwe8LANbhpSAMFMBKn/kaDv3yxuxYy6s9fwAfwQ5Xqzgr3iHPkgbgi2p2iooz+3C/9h8eIR8fATblymgc07kMhDldRc2jfgffzHp7bqDrhvG/wCwGaDZHAQ8YvUIhY2gY+tECIfm4cGsiAXraPL68uVtmaamz1SQTK8gljYBD5MAdOxQWNkIBetc4LRsE51ZxGPUKsxPYyQd9wHrQLxb5jH2TwORsBnW7T3iH+c+mR6OOi5TznSqKiR24vuSFcaK6qddtpGPa0uOlqKdDlXwXWGMv9Wu8JjWML8nmhLJy5dJHALeK1zWNsMPCN7Jbq2yecuz7GELTUEqSQHm5qDXxn1iGIXxojzPokQcTNU2+0BejfHg5+h7X9gppZPbdUdcO+foVSGLqqGNVa0A5eCxpFeaZxoTxNNW6un00VbS6UyDoTgOkMZ7ZP/hScMqHxqq+6A+4RCtBrRONENHBrpk8YT3WnQtJUG+Z0G/I+llF0E1xnaTLqnMqDSqa26A+6zgsYuAig+1wUc2CSJT23VHXAPmrE9OO8MV8J5rjgynduQxgjwEHs+wsGVe1gEPqyCp2sYIxaJI3gQLD7AJsAWoN3wAVYBrmEgSQT3X8MHwSbAGAjNhg+wCmgcryMghk8+CCYB1kBoNXyAVUBaIRAGrDcOGhZ55L5a+INjXSGXwpOUe/voCYLMUqQPz9KC68aSLheUl5HntJhIuCLILEUlNxRcH2o2ETpw3A1su/u9TMgJPMIefkJw05ACx9WeJ+gE6OktAHAs9d8rqDrmIqVF4GEb3DQcs3Af//GprboD7tsGv9C32SAZbs/zEtGwCXzYArabBiopUniEffxSgVwkeGnItvP82eZmfyIZbkcriIZN4MMWsB0bNCIzcvHNOLo5edS8Peo0CC5L4bt4BNfHrc2up2Ef+OlLurlevBwZO2xTdNd19PqJBiAkLDcwOwZ+WTAn8Ah7+AnBTUMKbLa25zwZZMHOhGhe7DUCvUyZjQCr7oD7xkGf92o2SIbXk2ZELGwCH6aA6dhU89JAFuSidRSBoQPnk2bM27PZAcFlKZWkiuD6iSgA0JSZWjq1VXfA/XENeXvmVyC4LHUGjyS43rk2ZUClU1t1B9wf1zBvo79KGq7CVX9huRvoK/3L9Qb6KpQBlU5t1R1wvxsCGyXxqa26A+6bCCK8jXAe/ENmPeQD3pTHI+1HoycZ+OngIyjpoAUBfPJHLMAmwBYgNmjsKQofxYUhBoKEcHcTfBBsAmyBEBs07iQLPx18ruu0P7sddBeIsnLD/J4gyvxQButPcN1Y0uX89hLyptHkbb0sV7T6sVLEmYeC6xQ9vb0nKAHAkf9ieCRfwc6DqPuVoNPOElTVMOWHcbME7ckaaesGXCD04+8F7faAh21Q05ADp5+bc03KnmvfffxHp7bqDrhvHPwpXLNBMrweLxWxsAl8mAKmGweqSxJ4hH38UoFcfCMvWXU3sw8OP/L2QAYguCyVq4ImuH4iCgA0ZaaWTm3VHXB/XEPiHvQHIbosp/0w6V+u2g9TKAMqndqqO+D+wIa8PSd/X7Q6LNUGuCi43rk2ZUClU1t1B9zviLhvlsSntuoOuG8iiPA2wrkJ5y8L5/6CxrwOI/axQePJDrlonRM8Xdc7Btnu7Jb4XyBKyju11RMEmaXc4ESC68aSLkcgG+mRRmftTKM9MchlqT/r8wTXGdrMv2rv9Y0SPQ5hV/hdFtj1UE3fordzGRRS8amtugPuE4o96E0yT1wQostykqJi/Y8oACApKg5lppZObdUdcH9cQ+LuiA0huiyHlULWv1yxUsihDKh0aqvugPvjGubtd/MkXYWr/sJyulvd+per7lZ3KAMqndqqO+B+R0TZmxmd2qo34D6jDtN1pHSWQB/Yb2xjNanQUrS1WoLrxpIuu0/OyOqJebuGDUSXpVos7gqud65NGVDp1FbdAfcHNuTte5XCF60OK4H4kATXKXo/F7LuowyodGqr3oD7tLifC9nSlLWFdGqr7oD7hGJ3svOa9x1oUqGV/kJDC64z/NtLkZH7SMjbt0KYL1odVhrVBhZcp+iRLLLuowyodGqr3oD7tNg7d7Y0ZYGXTm3VHXCfUOxOdgL5vgNNKrQS352jDcF1hq+GaPid2UHfzqe26g64T4tlkGwpJyhv4UNQnr8En38M8jD5WtwwtmG+RU23JwNvuNMtv+P+e2YfGn5XJS7qot5BqJizQgy0vX+mkSwsgt88Nfb/zP79XnnnFPfgEFr38KD9d41Ti71r5rsXW7FjO07sRJS/zmjW5mQEzuJmALVuYFq78w5/EuPhh2CtNme3+IxGSNsE6taYuRQf08cpxkBqphSNENB42YMNRSRtFjxiUzvdYEzxaxllXGBKcjqYVnMeps5dBKk+C2qa92J61baYbNdWZqe9qmG8Z5m6kZopOZdtvHW9mMFKAECafveglfw/2bLJc8PZ1cR13SBtPo3JdHtzAe17on/+1o9W7y2D9uLB3VKIa7z0Q7/7nG8Gp26XZ/ZYofTw0Jphxy02vmlAf7Zx+qdfBRfjgNpE9tEZ6oe6zbX719cYh7Obj3aWdIyni3vojlUIo1MqNnCSQ2VmSlRsyswqvLi1GoXKUa1RgFSJwVdIpX29zlFlcY2uaDpz1MbbjYLVdVZgp+spUpCsUv7l2JRsPln5N9zaTZ1OOb1TD72TZ5Px6pr53YlLWVbpYd/9Ru349sV+9gF25ynl/c4uro+wzVmMr5+rOEfiTUO5rFQPVN64amM7WrPJOudtUQ72STPnY9Tngwg/dXIdjsib2uW2MplaOiNQ+PRAzJlBYQq1qlwHbwUxA6lDkFBFNyionY7LKXUCK0bMTtVmjlZtp53KnU9QM2pxkTS3VG7SHazZcH9zqipL06oXYZzUkrBcjL3VyobD6c2ncpj1SFwq9zjYwAld64PZ2SLsXDumTecTzukWojSH2+xn+tVR9wiNmEEN0wOoluqZqk12VVFSTkXeCI/nru7BzIZ7a85VnGzbTE9Q7omZ6ZTg4p1iiElixLIEa966qRpKjzJyoylW1sbYxamQi7/EwQgPjAp46lIngS65y/MIB8xlrtVwWXdW78vJpjYKYSnJ/RTUSFcynWt1+/Lk+hJXxIp3UslrZ8p15BB6LLkpwkzF0Y4JVpp6uQ2r6Zqge1x/BlWeF6fsnjUpF0QXdS27sr/7NWxecY7L7VWOL1OnOAa7HcYOhrSV3h1BPkPOBd1xGt0urUZnZwRnfJQzu7+WZ8iJsxc5Uo6CfpXrOX9Xcs7MtpaD91TMJdn+pCtYIbnI7+t8a9Z5NHyc3amb3DXcMwRHAXWnvW4GH5yR0pZLQ6J3dfkg7mV8zc1D2rstW6bLvm698NFT3BpWE6yv8y1XoXmN1cuQ7lawbjua9M2EXlX3idEMKbX0sPVXctlVRXaOoH7tpS8qUvPbmL3gAz/87VdFelmn4JEKqtgzR2w+uvPt3aoYVFFS2DBDr+2pcpKburOaolwII6soqScRVB1TWbwtKMlJXTesvOBqF1hOSjTkcrEe3L2+ONiwjlDXnbluNnnFRakorlybjes+6OWoGXuDYQ7Kb4vW7Mqhu+5gBpWIditDKk4RXiSFujdSUPtay9IuLUZqs0kxh9TRSlf1zjsx1tFz57klPYzSC/6v4dxizl7LVTUaGzPk5fDoVTmt157mlpnTcJ2FLReDUo7n6ipvugPco9v7puqY+VinA2G6uGMyrs9YfeHzY5o4i2p9E7hnlKNprFLnwCqiBkuZ/lpWfWpX3VsDo9t0uy7E0pXJk33te1M84wae5VyE8si9MF4ocg6xbyDrjJtm5uhEUjLOWHjK/S0EcdO6uBycrYIj/bZ1uZ1M7rcMxa2O0btFfoDTUWm4WneMbvaQpXBRy8kiGWV91ZObHnOluhWHaHOaOqavRnAm1y+r7t+E7K70rayZWdZWyXWvlVXLV1VVI6Wsx21TUv0o08DUtF3aV6SihDobtW1tWWk4WpRMkh1z+hEtL62CXVqTgggec0gNzmsoGR4joLgQrkqdnojg7IsabK7Te6d/SpUIN1pfNqVhXWHXAmntxo6quW3Kvm7E1qxjPoodJ6ODy37XmRts3/MCa1c6fMP8XNmRWbG50jd1YUb59eCqh4OqGvp4r1LRF9XAM1pumSWlmzrGFZyrpBKZkNrrfaXpMzn3Qu9pdCGnsNwYYxZRV367Lwf3ViwUVWo587qi1x7rucVxOJf6oedKBieuCwg5H8rA4Ap467xwjSfwfQpGMy7uNsGcJK71dUjMqJyKIfWiWV4Nk6CqYOvWyu5mvXqRLJUl5a/qWGmqbh0/lSeYpCqlnRbWV3IZK6B1eXRNhidndDL1+pH6hJhnVMOin7L4TFSnwkVVEcxZtrncfj4IC1st0a7LRqEz8VRvhJW+fZaeMzkzcO40OjTegXNNsJusXtl9Km0z7rk02bV528yFArl6cffcKQuH2jsfjbg6cx9PcCYJ0uusv/Vk3Lt9ugYzuWv7dTnsOGkfne8DwVTzwuljqs4sRHTUD7mqKrKjbZQ1rQR+DWDQcw4ccjInkYXm4udcYH7VdVH2OFo3JvF6XKqpuxmTX/fP0kolqt19ASiwSp+jnv5V+m4C6q1Da53xLA5M1bMhfKcxnaq3v6PLZ/3P/wy4NrLXKXjZ2ycZnBsrjFh6KTQNAuuX/L+bmWFvH5L12sEoAxJGUb0UItaxU9HKkAUPD5PSoCEH9HVwGAP2Uthr38Jhdf/WZ/l6UtB7Y5fMl9TijRr3h6pyV/ZnN0Omv2E830sBzp09yJdPLTS7e00ONLTGLPLA5fJHCm4SSBA1ICmMXEemCGlIA9OpSVLIkRMEu3t1TQo5cnwRTeJKkdbIMQjpJSPhSslTe0Vi09P9nvOn//cI4KrLc+fvxZ3xErbnLKYdB6b3go03fHlgqqLLnAH82YBX9z6no/9cFSXPA7XFJcv2wqqBAAhu94KfP10gwZ7Z39g45auoc0qd4z7Kmlm8jCnw3v+Ar97VadRuy2k3Q8EKl6Q6VuLcw3JB04GlWKqwmGVN7qd8UH6/nEKBuMw5UeW6yUWzT8dAG+QGX+p9eRnYFb3DD8x8eUL1nrh+AA8q1RbcKAUzz8N01wyfBzZ0xcTJI0K1nzOG5RfF2neFC85lV/+bYzOkZO9SVKQV/lvc3Nbk4weuvksh0QX7/axCG0RbfsICYRrx/DDHm/Kv047vSqxJkCXlHgqG7Yyr9dERLJ/u9K8YBWTyVmEU7MvhtDDi/S7HE3HVGd6O/vYryQ3AeB7/4zM+/c8MC/ASkJoUcqMGiMFHFv+F6BpCLkF6hgpnzJmu+2zyDfJUj38U5jrLp5h7gpR+uD/Hmz73PcFdo9HrywKXB1sjIozqvkZNQDt2YyQZXWQvWsiiqSmWbKLlI1oQoikelrShZRhaWKGpEpb8oOUMWqCgKQeWRKBlAVron6n7lYyf5fVZMJ8p8JXUnmXqWXieqeSVHJ4F01ljTunPWfSc5cuZjFwpyFlMnKXBmRBc6b1ZrJult5lIW2mxWeSaJauZgFrppFkcmqWembhZaZhZVJklkpnwWOmLWYyYpYWZKFhpf1nElyV5mWBXaXNZBJclbZmcVmlmWTCWpV+ZxFXpWFlYlSVSmfBUaU5ZtJQlSJlQVOlBWeyTpTuZiFNpNVkkkyUvmcBS6ShZZJIlI5kAUukcWZyRZRaZMFGpD1nEkOUImVhQKQJZ7I+l+5iwT+n3WEyPpfGY6E5p61iMjqXlmChOad9YxI0l2ZhgTenSWPyMpcyYmEzpxlg8jKXAmNRL6blYaIsls5j8SmmsWJCKpaWYJErpnli4iSWYmExJaZFY4IjlipikSCmHWECI5YCY3Eepelh0h+VzmAhHaW1YzIZlaZhgRqliWPiF5V6YuEUpWFhMhWVRmOBEqUpYdITlQ5gIRCk9WJyDZTaYMEOpL1jEguUomFhCKSJY7IFlG1iAwZRSUFIEljhgYQOmKFDCAZYZYNEApgCQeoz+6vOrti+Hfoz46turVi/3fEzy6sKr8i5newzs6qmrji7neQzm6pGrLC5HeGzf6narwC2XdqzY6lurVC3ndOzR6kCr6Cw/c6zMaiyrmKz+8agZx02s0rC6wbIAx+mrQq96u6royomrwq16tbLPxiOrIqzarrK0xreqcqoaqLKZxkuqwqh6obKExvmpgqd6nLJrxpWp6qX6lTJRxiupmqS6kDI8xtWo8qJ6izInxoGomqG6hDIMxhWo6p/6fTLxxamnOp46dzLWxT2nipx6cDK7xdGm4po6azKmxX+m6pkaZjKSxS+mWpjaXzJ5xculypaaWTJgxWelOpVaUzJHxQOlqpMaTTIvxaOkKpL6RjIVxTmkepA6QDL6xM2jyo56OTLfxGOjeo1aNDLLxBOj6osaLrKxxKuiQop6J7KcxFei8ogaIjKCxAOioofaHLJsxJeh8oUaFrJRxCuhSoTaELI8xNmgUoO6C7IoxImgwoF6BbIPxCWgMoCSYv4t2m8KfovpWxbfAvemq7dIvSXnTSBfOniLu1uq3aTrpU+3ELplzU1mXlpyC4xbKtzC36b7tnC3JbhNpl1abAtcW67aJNWlm7Z4tCWjTf5cGmcLMlte2aTKpUe20LEli01AXNphCwhbDtgkwKXztTCvJXZNmFuk3s/rsPz/Q0HmWueanyfq/n5g8JrfRoYolkO88D81V2/7HSf2K2e//kNNydA6BIFboVtp98mcO3uT87k7of165O44aEuxu4ugfTnn9/yj6whWQHf7s6W0u4OffZG7K599sbvTnn05d/c8d8XzfWN2rHX255H7xOf+NYFbofvkzv1J3Mq5/q818P4MqkhTEZVjDYdKqBxrmlSGSlgzTSWsEak0laUS1iypmDUGFVIRFbMm4I5z2gppEPN5WcWd5LQV0CDiDnG2NQAN0qxhUVkqZj1NJawZUGkqZo1IxaxZUCEVUTFrDO78pq2QBjFrQirLmjNndKOV8AVvF7lTm7YSNhgUFbOGTWVYT1MRlbBmispwBja+HLFGRYOoyLFmh0qoHGtMKkMl3FlNWzk2mAxrztwxTVsJX/BOkTuhaSvhDmf6cmwwaO5cpq0cGwxBxVSONb2sGVJp1iMqQ8VUjjU7rLGomDUZ1lxRAZ9XJSpmDYY1LCpgzZA7kmkrTYOYO43Z1qg5gxgvQ4OEO4PZ1uxwxy99EQ1y3MnLtsbiDl36smwwKe68pa0sDRLW78SfdwtUyHpAJVSOFVLTRaWpiMpxRy3bmikaRKxRURGVY80OlVA51phUhkq4U5a2cmwwGdacuQOWthK+4HWRO1tpK+GOVfpybDBo7kSlrRwbDEElrOmhItYzVJbKsUYosqxZFBGVpXKsMaiIO0xpK8sGE1BZ1u+KP28K3DlKWyENstwRyrYGpEGGNSwqpHKsaVFZ1jNUzBoVFVIxazascVExa9JUhvW78Oe9KipmDZrKsKbFnZ60lWWD3xRncNJWljsz6YvZ4CdwxiVtxdxJSV/CBr8lZ0jSVsIG46Ji1qSpDCvH+h9Vf9WSRBKwkeUBERIREbMMScQs0yBCIiJilhkSMcsIREhERMzyW/DsokS2kFLiiknx7pREtoBSIt6dkDTbHCglTeS4vCgQCctgiIjlIZElcizTILIsMyZyLKNlmSWRZhmbyLFMlmWORJrLSwzv7klkiyglx7s7kmYbilJilulhmSkiYHlExETC8iyRYxmTyBA5lskQCZGrmCORIXJc3kYRIZFjGYrIsjxNxCwzRYREzDIKy2wRMcu4iQzLJCxzRcRc3qkmMhVDETHLdBMRywyJhMixPGKZFZGtmBQREjmWORFZLq9gIscyXJZpEmmWZ4gcy6hYxiDSLJMiskRMAxKwz0AZ/rmHl2QCMuRfuVkcQ1p7Jde3wyUISKNTXHzqWgPP2v8alOoOwcyFkJgivN/JcvwxjqFhrgfF8HHmFYpkVfKIrFM4h46Twp287uroHIxcl3C0ezEsHkZWF3xNbN6XbUWApEdssON3k6yHYi8Y7c4cPqef0E6rgrfoCCJ/q0+xhBRiyyjrC3hK+zD42j2rAiso9IjwYjTse1WKWyJsi652RlQ4JXwYJqNadivc8HHBd/Q/5hVIbczVdFtCnz66bPioSDk6ieIWyfDR0UKnDX3iDiJSJvKBEB5IyXGirnUZaMQ3uD5N6gBt504hFrPv8l5xQIpEO6WNn5cXM1o1U85venKlSbbWiKy87DIaurTT4IehF4uPpMxcfGQf2aNNjwAd1QSz6xQNjgzfL70S73anJiOS1s9aO7A1OUZ6ez69LCvYJ4RA1nEWOJNEznLkX6FCIXULoNwMfCTPY5PQt291OvRNGwVBPwuRttmF/5kHH9q34Nio6n2S4eyZs8A9+7aB/8HQRk0gyvj2frm6XjKU8m4gCnAshreHTw9qs6A/Jk1Haa0cvlH6gIt96/tVKrpDVfNCk3UbxQ6Xd8vcqDCMKrKyCvFx1FGlxQf6+huXjeGKdpDvp1dxd31B5GCJDNY87BF/oNCvzL0OgqPDdBXN2EYIXiXe8OTVygq0R81m2tmDEm9/uwf4/qyjNCtYjOnQ9evIAAo+0iB77QrPrlGTlho8ZHo+o11hjBrhMNTbY4iJzMXUsxE0zbMJm7+giKEKU5CaK5z2koOSfAKMpgaOmXMSTRN+wY84si3NoKZDVeJv4zm1Fl6z/fIaZ1g9Ynnir52qkAszYSqRSGXy09aveLQicbmFnzq83/RVHZYHoz3wCw=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_4sum"></div></div>
</details><hr /><br />

**类似题目**：
  - [1. 两数之和 🟢](/problems/two-sum)
  - [15. 三数之和 🟠](/problems/3sum)
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [剑指 Offer II 007. 数组中和为 0 的三个数 🟠](/problems/1fGaJU)

</details>
</div>



