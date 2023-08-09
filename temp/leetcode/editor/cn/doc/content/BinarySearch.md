<p>给定一个&nbsp;<code>n</code>&nbsp;个元素有序的（升序）整型数组&nbsp;<code>nums</code> 和一个目标值&nbsp;<code>target</code> &nbsp;，写一个函数搜索&nbsp;<code>nums</code>&nbsp;中的 <code>target</code>，如果目标值存在返回下标，否则返回 <code>-1</code>。</p>

<p><br> <strong>示例 1:</strong></br></p>

<pre><strong>输入:</strong> <span><code>nums</code></span> = [-1,0,3,5,9,12], <span><code>target</code></span> = 9
<strong>输出:</strong> 4
<strong>解释:</strong> 9 出现在 <span><code>nums</code></span> 中并且下标为 4
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> <span><code>nums</code></span> = [-1,0,3,5,9,12], <span><code>target</code></span> = 2
<strong>输出:</strong> -1
<strong>解释:</strong> 2 不存在 <span><code>nums</code></span> 中因此返回 -1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol> 
 <li>你可以假设 <code>nums</code>&nbsp;中的所有元素是不重复的。</li> 
 <li><code>n</code>&nbsp;将在&nbsp;<code>[1, 10000]</code>之间。</li> 
 <li><code>nums</code>&nbsp;的每个元素都将在&nbsp;<code>[-9999, 9999]</code>之间。</li> 
</ol>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 1340, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=binary-search" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[二分搜索核心框架套路](https://www.bilibili.com/video/BV1Gt4y1b79Q)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 71 页。

二分搜索的基本形式，不过并不实用，比如 `target` 重复出现多次，本算法得出的索引位置是不确定的。

更常见的二分搜索形式是搜索左侧边界和右侧边界，即对于 `target` 重复出现多次的情景，计算 `target` 的最小索引和最大索引。

这几种二分搜索的形式的详细探讨见详细题解。

**详细题解：[我写了首诗，把二分搜索算法变成了默写题](https://labuladong.github.io/article/fname.html?fname=二分查找详解)**

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1; // 注意

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1  # 注意

        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1  # 注意
            elif nums[mid] > target:
                right = mid - 1  # 注意

        return -1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func search(nums []int, target int) int {
    left := 0
    right := len(nums) - 1 // 注意

    for left <= right {
        mid := left + (right - left) / 2
        if nums[mid] == target {
            return mid
        } else if nums[mid] < target {
            left = mid + 1 // 注意
        } else if nums[mid] > target {
            right = mid - 1 // 注意
        }
    }
    return -1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var search = function(nums, target) {
    var left = 0;
    var right = nums.length - 1; // 注意

    while (left <= right) {
        var mid = left + Math.floor((right - left) / 2);
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target)
            left = mid + 1; // 注意
        else if (nums[mid] > target)
            right = mid - 1; // 注意
    }
    return -1;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_binary-search" data="G1UYEdWaRwF0JsRjR40p2es98oWWEGOjq1sLkfWsae+8yFNVOfWWg7OtWAgD5tSUdaV8/XOaLqeV62T5K3iouKOBCFAz///3+zbTxNuguicVRKw9CIXKP+fcvzGVxrrvvhHzhEomZGIiRxah8BrNw+mqUaz44erKfyHyLt3NnIOEREocu/ALA++ArEqDQzRprB+KflqJqeY/eOSBWnP3DxL+hyI+cmdm90u86sYcXybq6pEMl5TOXkhGRzwJ2v6EiR2rg0omRxd5H59YJcl+oXiViXZPmB8ag3S/Uas3E4JnhI3zg9XtkQChkf17Mj51uKPbazZcUdH7LaNIDk9cSO/D68riqy13Id0gvSHZsFsZzJJYfPlOUqUKkAqxmp6osNMWq3I2kG3sR+/8OpyWulc11IFIQiRR3vNrU9Wa6wYqd2sOrDi1VWVVu06VQPVzQAdUnwklqLjmcnv/RYaoKLhhpFaMqzZIMDWXH4oKLTFJYxSxbDhHvQCWz2UdIFOcck5Zge6hyMWVkDd6GaIN96Q9bSwyn2+f2Vw/o2r1W0J5afWcmI2R/gk3qRQ4dkhsDpo3KtudJRpsFRal+O8mge3R4pXNCC0mzcCVcMmugJ9rkH93LRv8is2D/fWDswSZXDDGrVj6qP9RCq1Fr8xFzEVKEvt7YFFwAbgoXf6EZ79QdmU2LePhUfduGicnh6LkYGSyWLQeRjna9gwIz9osuBTyAx1zEkVV/pM9sw/G2z5UUO7C23uJC6RxtIvez57ZLHtl8+xtXSPRcOSBbkRskO7YlGq2bCJfEWSktOe4iepVgVWEKdT9eA22zKKRGoPz4yy+Tpu9P3fSUTeJkmhMh+idLylX4o39Xd1ZyaZIiTx7Ht3Tjp47UAdyisYZHtpOFM7Gt2+FZm3JNYyQqas7izgyXKwTSoGdkeddLuKPkbHZB9fLpgKaZjDWMfZ2UzjKKM0tQwV2ssvK4ENAHLK01q3nGrl0SepIyZCNPivLQI3pGNn4iUaxMMIXV3LunUoS3dpYbIiGEi4EQWzKYCIh0JhOWHu4Rqo72biplrnCwKHUNns0BewgDFWuIEpcI6UjY1lAE1B0MghjWQCPXgeolUspoOCdhIHjZQFxr1Hirc9HSG/q6wwqTnMZSQmtpxgsUg/nJ9sST7StlSEkouCQTV7Y2YgCoT7yGdvprUdQbXaaXtyXBfITB5hDxd9wHtNbnaRghRKi5m38g1HrXBtuAXFVOgvULEnDWO+FHJZCcGm2pY8JgMNFYJKMw6eILzqmpXCK2qEaqoe/bLVXQ3HW31N0q8zpldhoDRO6PviMNNWyLbFEQF740mSsjeh7N5KaRN6BIsGlpcGIEgkhtg1NTt0WwapEhEMwRuxBg6jF2Ji5+zEMjc9nVb7ci4IRC25ifG8/xUgsrm/EpMYi3cTyHpEHLhjVWTvhxHkkBwdy2LrxuQvnJ9v4bcwUiybjIgVogCov1SUcOzSFkAAYHvfJBja5RaK9SS29JzRCGhSWkWeiQKjT5HR83agLCt09ZTEVYZWK4eB5dtgNFnODHTQzNiF6YtaEQtsVYVm9EM0r4FlI5flLpxkvZc8xRDnuZ6fa8OeK2Xevka2PeAXCBkQMxZZCGNggIPj1fhhYvRMOvFaRsoBaXS5BVu3Wmfu6wVPl9miIo0xFNxrkFvcOchf3BgXifne7SxKUulXGza19Gn9luQxD7qsWU/1iAvze3SUAANAvy5+HzgM4+7x0A+UgJtPLHZ4eATQLpqcnkEoZcDv7D4SV1JG5eeO+LWmqp4aIa9VYdeqXtDfrdo/QKaOvTgM8MWv8TCTg/Jduh4j3YH7eF9QmG/cS1kyfgHAMhKjUZU5aQAg0B1N+LQfJ+ViwlTvMczT0/94lxx8eIXn0fzZkz/ZOXyO4bz46f2v8liCg4BCoIbsCZCKZuoUMKvXJJ7738halBX/abww="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-search"></div></div>
</details><hr /><br />

**类似题目**：
  - [34. 在排序数组中查找元素的第一个和最后一个位置 🟠](/problems/find-first-and-last-position-of-element-in-sorted-array)
  - [剑指 Offer 53 - I. 在排序数组中查找数字 I 🟢](/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof)

</details>
</div>



