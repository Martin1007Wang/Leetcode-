<p>给你一个只包含 <code>'('</code>&nbsp;和 <code>')'</code>&nbsp;的字符串，找出最长有效（格式正确且连续）括号子串的长度。</p>

<p>&nbsp;</p>

<div class="original__bRMd"> 
 <div> 
  <p><strong>示例 1：</strong></p> 
 </div>
</div>

<pre>
<strong>输入：</strong>s = "(()"
<strong>输出：</strong>2
<strong>解释：</strong>最长有效括号子串是 "()"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = ")()())"
<strong>输出：</strong>4
<strong>解释：</strong>最长有效括号子串是 "()()"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = ""
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>s[i]</code> 为 <code>'('</code> 或 <code>')'</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 字符串 | 动态规划</details><br>

<div>👍 2292, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

如果你看过前文 [手把手解决三道括号相关的算法题](https://labuladong.github.io/article/fname.html?fname=括号插入)，就知道一般判断括号串是否合法的算法如下：

```java
Stack<Integer> stk = new Stack<>();
for (int i = 0; i < s.length(); i++) {
    if (s.charAt(i) == '(') {
        // 遇到左括号，记录索引
        stk.push(i);
    } else {
        // 遇到右括号
        if (!stk.isEmpty()) {
            // 配对的左括号对应索引，[leftIndex, i] 是一个合法括号子串
            int leftIndex = stk.pop();
            // 这个合法括号子串的长度
            int len = 1 + i - leftIndex;
        } else {
            // 没有配对的左括号
        }
    }
}
```

但如果多个合法括号子串连在一起，会形成一个更长的合法括号子串，而上述算法无法适配这种情况。

所以需要一个 `dp` 数组，记录 `leftIndex` 相邻合法括号子串的长度，才能得出题目想要的正确结果。

**标签：括号问题，[栈](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121993002939219969)**

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
    int longestValidParentheses(string s) {
        stack<int> stk;
        // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
        vector<int> dp(s.length() + 1, 0);
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(') {
                // 遇到左括号，记录索引
                stk.push(i);
                // 左括号不可能是合法括号子串的结尾
                dp[i + 1] = 0;
            } else {
                // 遇到右括号
                if (!stk.empty()) {
                    // 配对的左括号对应索引
                    int leftIndex = stk.top();
                    stk.pop();
                    // 以这个右括号结尾的最长子串长度
                    int len = 1 + i - leftIndex + dp[leftIndex];
                    dp[i + 1] = len;
                } else {
                    // 没有配对的左括号
                    dp[i + 1] = 0;
                }
            }
        }
        // 计算最长子串的长度
        int res = 0;
        for (int i = 0; i < dp.size(); i++) {
            res = max(res, dp[i]);
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
    def longestValidParentheses(self, s: str) -> int:
        stk = []
        # dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
        dp = [0] * (len(s) + 1)
        for i in range(len(s)):
            if s[i] == '(':
                # 遇到左括号，记录索引
                stk.append(i)
                # 左括号不可能是合法括号子串的结尾
                dp[i + 1] = 0
            else:
                # 遇到右括号
                if stk:
                    # 配对的左括号对应索引
                    leftIndex = stk.pop()
                    # 以这个右括号结尾的最长子串长度
                    length = 1 + i - leftIndex + dp[leftIndex]
                    dp[i + 1] = length
                else:
                    # 没有配对的左括号
                    dp[i + 1] = 0
        # 计算最长子串的长度
        res = 0
        for i in range(len(dp)):
            res = max(res, dp[i])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 遇到左括号，记录索引
                stk.push(i);
                // 左括号不可能是合法括号子串的结尾
                dp[i + 1] = 0;
            } else {
                // 遇到右括号
                if (!stk.isEmpty()) {
                    // 配对的左括号对应索引
                    int leftIndex = stk.pop();
                    // 以这个右括号结尾的最长子串长度
                    int len = 1 + i - leftIndex + dp[leftIndex];
                    dp[i + 1] = len;
                } else {
                    // 没有配对的左括号
                    dp[i + 1] = 0;
                }
            }
        }
        // 计算最长子串的长度
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
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

func longestValidParentheses(s string) int {
    stk := make([]int, 0)
    // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
    dp := make([]int, len(s)+1)
    for i := 0; i < len(s); i++ {
        if s[i] == '(' {
            // 遇到左括号，记录索引
            stk = append(stk, i)
            // 左括号不可能是合法括号子串的结尾
            dp[i+1] = 0
        } else {
            // 遇到右括号
            if len(stk) != 0 {
                // 配对的左括号对应索引
                leftIndex := stk[len(stk)-1]
                stk = stk[:len(stk)-1]
                // 以这个右括号结尾的最长子串长度
                len := 1 + i - leftIndex + dp[leftIndex]
                dp[i+1] = len
            } else {
                // 没有配对的左括号
                dp[i+1] = 0
            }
        }
    }
    // 计算最长子串的长度
    res := 0
    for i := 0; i < len(dp); i++ {
        res = max(res, dp[i])
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var longestValidParentheses = function(s) {
    let stk = [];
    // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
    let dp = new Array(s.length + 1).fill(0);
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) === '(') {
            // 遇到左括号，记录索引
            stk.push(i);
            // 左括号不可能是合法括号子串的结尾
            dp[i + 1] = 0;
        } else {
            // 遇到右括号
            if (stk.length > 0) {
                // 配对的左括号对应索引
                let leftIndex = stk.pop();
                // 以这个右括号结尾的最长子串长度
                let len = 1 + i - leftIndex + dp[leftIndex];
                dp[i + 1] = len;
            } else {
                // 没有配对的左括号
                dp[i + 1] = 0;
            }
        }
    }
    // 计算最长子串的长度
    let res = 0;
    for (let i = 0; i < dp.length; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_longest-valid-parentheses" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-valid-parentheses"></div></div>
</details><hr /><br />

</details>
</div>



