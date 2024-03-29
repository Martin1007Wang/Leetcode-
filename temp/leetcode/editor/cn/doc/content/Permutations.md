<p>给定一个不含重复数字的数组 <code>nums</code> ，返回其 <em>所有可能的全排列</em> 。你可以 <strong>按任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[[0,1],[1,0]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>[[1]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 6</code></li> 
 <li><code>-10 &lt;= nums[i] &lt;= 10</code></li> 
 <li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>

<div>👍 2593, 👎 0<span style='float: right;'></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=permutations" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[回溯算法秒杀所有排列/组合/子集问题](https://www.bilibili.com/video/BV1Yt4y1t7dK)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 43 页。

[回溯算法详解](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版) 中就是拿这个问题来解释回溯模板的，首先画出回溯树来看一看：

![](https://labuladong.github.io/pictures/子集/3.jpg)

写代码遍历这棵回溯树即可。

**详细题解：[回溯算法秒杀所有排列/组合/子集问题](https://labuladong.github.io/article/fname.html?fname=子集排列组合)**

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

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
    vector<vector<int>> res;

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    vector<vector<int>> permute(vector<int>& nums) {
        // 记录「路径」
        deque<int> track;
        // 「路径」中的元素会被标记为 true，避免重复使用
        vector<bool> used(nums.size(), false);
        
        backtrack(nums, track, used);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(vector<int>& nums, deque<int>& track, vector<bool>& used) {
        // 触发结束条件
        if (track.size() == nums.size()) {
            res.push_back(vector<int>(track.begin(), track.end()));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            // 排除不合法的选择
            if (used[i]) {/**<extend up -200>![](https://labuladong.github.io/pictures/backtracking/6.jpg) */
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.push_back(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.pop_back();
            used[i] = false;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def __init__(self):
        self.res = []

    # 主函数，输入一组不重复的数字，返回它们的全排列 
    def permute(self, nums: List[int]) -> List[List[int]]:

        # 记录「路径」
        track = []
        # 「路径」中的元素会被标记为 true，避免重复使用
        used = [False] * len(nums)
        
        self.backtrack(nums, track, used)
        return self.res

    # 路径：记录在 track 中
    # 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    # 结束条件：nums 中的元素全都在 track 中出现
    def backtrack(self, nums: List[int], track: List[int], used: List[bool]) -> None:

        # 触发结束条件
        if len(track) == len(nums):
            self.res.append(track[:])
            return

        for i in range(len(nums)):
            # 排除不合法的选择
            if used[i]:
                # nums[i] 已经在 track 中，跳过
                continue
            # 做选择
            track.append(nums[i])
            used[i] = True
            # 进入下一层决策树
            self.backtrack(nums, track, used)
            # 取消选择
            track.pop()
            used[i] = False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, track, used);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {/**<extend up -200>![](https://labuladong.github.io/pictures/backtracking/6.jpg) */
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func permute(nums []int) [][]int {
    res := [][]int{}
    track := []int{}   // 记录「路径」
    used := make([]bool, len(nums))  // 「路径」中的元素会被标记为 true，避免重复使用

    var backtrack func(int)  // 定义回溯函数

    backtrack = func(level int) {
        if level == len(nums) {   // 触发结束条件
            tmp := make([]int, len(track))
            copy(tmp, track)
            res = append(res, tmp)
            return
        }
        // 枚举出所有可能的选择
        for i := 0; i < len(nums); i++ {
            if used[i] {  // 排除不合法的选择
                continue
            }
            track = append(track, nums[i])  // 做选择
            used[i] = true
            backtrack(level+1)  // 进入下一层决策树
            track = track[:len(track)-1]  // 取消选择
            used[i] = false
        }
    }

    backtrack(0)
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var permute = function(nums) {
    let res = [];
    let track = [];
    let used = new Array(nums.length).fill(false);
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    const backtrack = (nums, track, used) => {
        // 触发结束条件
        if (track.length === nums.length) {
            res.push([...track]);
            return;
        }

        for (let i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.push(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.pop();
            used[i] = false;
        }
    }
    backtrack(nums, track, used);
    return res;
}
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_permutations" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_permutations"></div></div>
</details><hr /><br />

**类似题目**：
  - [216. 组合总和 III 🟠](/problems/combination-sum-iii)
  - [39. 组合总和 🟠](/problems/combination-sum)
  - [40. 组合总和 II 🟠](/problems/combination-sum-ii)
  - [47. 全排列 II 🟠](/problems/permutations-ii)
  - [51. N 皇后 🔴](/problems/n-queens)
  - [77. 组合 🟠](/problems/combinations)
  - [78. 子集 🟠](/problems/subsets)
  - [90. 子集 II 🟠](/problems/subsets-ii)
  - [剑指 Offer II 079. 所有子集 🟠](/problems/TVdhkn)
  - [剑指 Offer II 080. 含有 k 个元素的组合 🟠](/problems/uUsW3B)
  - [剑指 Offer II 081. 允许重复选择元素的组合 🟠](/problems/Ygoe9J)
  - [剑指 Offer II 082. 含有重复元素集合的组合 🟠](/problems/4sjJUc)
  - [剑指 Offer II 083. 没有重复元素集合的全排列 🟠](/problems/VvJkup)
  - [剑指 Offer II 084. 含有重复元素集合的全排列 🟠](/problems/7p8L0Z)

</details>
</div>





