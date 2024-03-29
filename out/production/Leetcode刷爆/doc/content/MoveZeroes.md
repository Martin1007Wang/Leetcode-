<p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>

<p><strong>请注意</strong>&nbsp;，必须在不复制数组的情况下原地对数组进行操作。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = <span><code>[0,1,0,3,12]</code></span>
<strong>输出:</strong> <span><code>[1,3,12,0,0]</code></span>
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = <span><code>[0]</code></span>
<strong>输出:</strong> <span><code>[0]</code></span></pre>

<p>&nbsp;</p>

<p><strong>提示</strong>:</p> 
<meta charset="UTF-8" />

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-2<sup>31</sup>&nbsp;&lt;= nums[i] &lt;= 2<sup>31</sup>&nbsp;- 1</code></li> 
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b>你能尽量减少完成的操作次数吗？</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 2039, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=move-zeroes" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

可以直接复用 [27. 移除元素](/problems/remove-element) 的解法，先移除所有 0，然后把最后的元素都置为 0，就相当于移动 0 的效果。

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
    void moveZeroes(vector<int>& nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.size(); p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
    int removeElement(vector<int>& nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.size()) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 去除 nums 中的所有 0
        # 返回去除 0 之后的数组长度
        p = self.removeElement(nums, 0)
        # 将 p 之后的所有元素赋值为 0
        for i in range(p, len(nums)):
            nums[i] = 0
            
    # 双指针技巧，复用 [27. 移除元素] 的解法。
    def removeElement(self, nums: List[int], val: int) -> int:
        fast = 0
        slow = 0
        while fast < len(nums):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public void moveZeroes(int[] nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
    int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func moveZeroes(nums []int) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    p := removeElement(nums, 0)
    // 将 p 之后的所有元素赋值为 0
    for ; p < len(nums); p++ {
        nums[p] = 0
    }
}

// 双指针技巧，复用 [27. 移除元素] 的解法。
func removeElement(nums []int, val int) int {
    fast := 0
    slow := 0
    for fast < len(nums) {
        if nums[fast] != val {
            nums[slow] = nums[fast]
            slow++
        }
        fast++
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var moveZeroes = function(nums) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    var p = removeElement(nums, 0);
    // 将 p 之后的所有元素赋值为 0
    for (; p < nums.length; p++) {
        nums[p] = 0;
    }
};

// 双指针技巧，复用 [27. 移除元素] 的解法。
var removeElement = function(nums, val) {
    var fast = 0, slow = 0;
    while (fast < nums.length) {
        if (nums[fast] !== val) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_move-zeroes" data="G3kpAKwObLdpFBwmq5zldQkF0WEngrBtqb40EjsrLiUhdJKFI7QkY5IcnBdynW4mUOPmUv2o2fSolcjK39TXaf2jk5AcD7ozudSCEEJ0uTVdLpQGQZJAQen2ldrN77PVEJ8TzzCtS2J8TkPELOWqu/hvF3Pb7pkbzDX1kDAjzo7w2AjcYmzl+GKsH7VECZxwXM0O/YHAm3lt/u7sE0uvzT/wDAMXKYOUd7AkFeoj5fu30kxJ/oo760nQ135Ci8g7Ray0mfRqHsNV8dmx3IrrqNyTCcoxRSQ6TSmgKr/ddcA2eM7IHmAEoT1AjutAt8elBKL1Rle7bvLWEXaTZ3tYJujcu5UUFfhqJHnlguzbdubZjuF0mdWT3aV1UgZW814seHu58MdsLJsyO9MEK+IL72/lgfpSnq6F9X76FtbL05LwYo6uxjRwOuFKn4i3d8jbv9qyDVnqqUB6SuP7rgCx+RKM4axDgFRGZjt4P6WBnJD6E95HVsKQEzFi51ygLpbdhqyvGKbuV7VFnLWjYoMpOd8pQIJQUQIESTC2Og8VHT8nr60cq9Z5lMdBpvMq8RPYMcHy8CVDyLRDvhwLzYwYLcFjsWdoQfETr+3urOweO1TnYHlibxDzYGSvbIZcODrIQHKBTEbwjv1vO87QB8uQk0Hr/X8UyQ8/ANPd3r7n3/HnhH+N2VDrH0jggASo7GTfyEEUHWCIQpjKRQccXCg60OBCmSEXyEwVGg2FBEN0oMGFfw3A3YVPBChc8ESC4ocBRSHhkNlGDupv18/qeQG4/G9P3TxOXMBsfiwOpuVDK+sQENpPugi722ltbFxmGk1aHNR7MyEIyfnGgAVrhGbNgaH9fpSjPhoDCEsQ0GHrbcv9kARv9AhtWDChRbbW0YFD4nvtIfMr+AQs+FO4ZuBRdjwR3+ejvVOyN/YSVBA3mgaUpumKBv8n1xFLQb3pocgDByHacfza6feh/zMUx6qhkGMNJf8rS8tqGMuvdd2IDmalUcvG6zxOXE6RQE0sO+60jSLNMteS94uLrhNmdK9tiOQdd04FpC5rspNdL9H32U7dS7Emy/1yQVaB7vV7qtz94qbkwc3tzWmVulcfGa73yzZp3di9AmA/dBSm6ml5FD0yGvdrRme9mm7vNATDQlVk8orDk49UVJlOv4ZyD2byga//T1x1Vk3ZNbsTvQlSGLlRdZgSnj8ERR9s3s1fZt63xcJY3750PSZGYnEcy/TT8LnSxjQwqajFTqGHQei6VYwkEsdqUIcLWOgFW7DqIwIrJcB00jXDGOmC7amqbL9oNTdjWLU1Yo6e4ErT0tCx9Rdby87UhZxsVOta/tJ0SiNM3+oMRmJeicK9Q4BFe+xEklvrwcZVxQ7oGyDCSF3iVFXHEpgoYioBfZNYJFEZeWLcN4mFTzWwJlVHFxZBvI+mocmFTfe5jQ/Y5Zepz+b9g1zUrePKeMtElpqBn+7kcMNNVRszilshgEWCKQ/cI0ppYrRmUnOjPuebHMuyxRd5vHmRkYOGKync5iTUZxWl6DkQ/e43+MuddoYrPgwIkV6yZ81DwvJAmUp7DpSk82In5QFylgvO0dj+0fLztKUIBge35KEvj7OUTZlcL48st8AmLQa/WTVaJqlMTdIeNiaKncOWuzbh5hpgL9VUFhV4w6fp5mmkHTTFB5UYhnLSkXu2ZGrh3MmModnyhnH1XEPdssWYy8fZTu/2pVvHqchtq4FLrPZczVsN1TRnkdsmi/Sxk8xkLVTx0A2UvY94+97Z1ruTw42FrosA4KPvG0ik34y5pboKtNRCHP1oQmZgxem2MVhpRqf14V4qm9iUoOPGS2BRrD7nSeFpNS+Id0ubE4SPnKkgAKsqmqK0NwKXru681bep5Xlo0oLcRu71aHqwTyDvBh+mnbmu7x4mNEHh92FX2UZkd6PhG4loIuIbKNWauQzKqR4sFEcBs9RpAoVLEyhD2oGiImCWCE2g4GcC5Ts7UIwDzNKaCRTKTKDsZQeKWIBRkjKBApMdKBcBw38ugajul3QhiPXc6QadbiAS1gwEnGA0pEC4CRyBBI5BAqdBGskkQQIHIIFjkMApkMA5II1kCpDAIUjgGCRwBqSRzAASOAYJYg8ofBM+nCJJQ5eDHmcXmc1ruHPbmy/6RS8wzYCUPpPv7SXw1pzNo3WfXDFjuMjTPVeL7CHSn3axd1mD32Rbv12ZCjb90jZTzjYqk29GSMzL3IGmaYfPDYzCvgTfylgGnnlc9lDPA0coqwlflkVT4untTwfxpmSse1VuUMS80NjDP//I29jsLRRxiczW2WbOn/8f0RLJzYL7PP/w3J3aKiMrtPGXx2u2XoBWdp/pNqvn3oR4TLYUq+HzxGwj7qA90m76tStXkkynma7i/h0UseTb3HCoGmS6nom/IhTtLktlWYf8ydl5gJVBBrjScpSV7/zfQ6dk93xVyp01xoXnTuBsHhkK8CamJ9ISU03qn2s8vtTnUE72hQM="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_move-zeroes"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>



