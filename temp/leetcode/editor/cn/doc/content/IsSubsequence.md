<p>给定字符串 <strong>s</strong> 和 <strong>t</strong> ，判断 <strong>s</strong> 是否为 <strong>t</strong> 的子序列。</p>

<p>字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，<code>"ace"</code>是<code>"abcde"</code>的一个子序列，而<code>"aec"</code>不是）。</p>

<p><strong>进阶：</strong></p>

<p>如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k &gt;= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？</p>

<p><strong>致谢：</strong></p>

<p>特别感谢<strong> </strong><a href="https://leetcode.com/pbrother/">@pbrother&nbsp;</a>添加此问题并且创建所有测试用例。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "abc", t = "ahbgdc"
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "axc", t = "ahbgdc"
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= s.length &lt;= 100</code></li> 
 <li><code>0 &lt;= t.length &lt;= 10^4</code></li> 
 <li>两个字符串都只由小写字符组成。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>双指针 | 字符串 | 动态规划</details><br>

<div>👍 889, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=is-subsequence" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

力扣上的这道题很简单，利用双指针 `i, j` 分别指向 `s, t`，一边前进一边匹配子序列。

![](https://labuladong.github.io/pictures/子序列/1.gif)

但这题的进阶比较有难度，需要利用二分搜索技巧来判断子序列，见详细题解。

**详细题解：[二分查找高效判定子序列](https://labuladong.github.io/article/fname.html?fname=二分查找判定子序列)**

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，子序列**

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
    bool isSubsequence(string s, string t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s[i] == t[j]) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        i, j = 0, 0
        while i < len(s) and j < len(t):
            if s[i] == t[j]:
                i += 1
            j += 1
        return i == len(s)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func isSubsequence(s string, t string) bool {
    i, j := 0, 0
    for i < len(s) && j < len(t) {
        if s[i] == t[j] {
            i++
        }
        j++
    }
    return i == len(s)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
    let i = 0, j = 0;
    while (i < s.length && j < t.length) {
        if (s.charAt(i) === t.charAt(j)) {
            i++;
        }
        j++;
    }
    return i === s.length;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_is-subsequence" data="Gw0fAJwFdsP1gUU4GEriwsZQz3hmLQKy0vOwzXp9s+ZYKVnzU89KZIgAE66kYqZNpuziK3p3bfuv9DpBwAwMnhBO/vf7/U/t9q+yhlTw+xDvDJ1Q9t7nL8ySuJ93vkrCPJplOtNpjdxME8twClQ1iFZI7fs281l1vC3M8dmITRxgjmf1FwZOydlX6xBO6uor/Vqtkinnj3hpGmFaZrkvhf9RxCrN2hEfuKvCD9ru21D4hTYpouZJcT5q/ayiDM90dtpaujjrZQqQJEPoXXmQxjx3uf9xU651Q3mf5RCl1pTLmje36mybVKByWq1062a1A1xPYGxmgJ6KXjt90jLEZf10JZzPCI7upnEhHWMAg6K5Gl08PCO0qsafjVAx9AC5cuPPRVSc0SY/pd/aHMiuG0ZPEOZM+bwve1ZJqaUoEEuJpjshibKnee2USQY6yrbmmCZyJpUvoA7oJ1oZ2/UoZ5UzUs1fOoxg2+2I+qKEncBmXxYUv+rq2+dg3/vD3XdJ7E0vkvWOUEgbiLhiwgC4WrNP02hclIhnfEMJHdNesAlrsnX//jl4uH9vIH9rYlP8O4D8QyGZ8PI/vKrJvzfRP7Ai/96C/K3J/f7vQDLBk0G6kyScktpz7IZXhS3jave3n4P9E4gWDClr3iUcq9n2oPCs8jKpTNBBsV0Wt9uO6NRwrNezc7fJpbKsdPHFB5jj31/7uuKcWX3pjCyqhHHlWll4UaAob+sxSz2N13/kH1PUNItY+QZlWG/DNMNQaRP3cAA85+XlpUoxoZVFYJMCE4F+0087KwGFrZyLoWeDcaZ9ZZHqZNC5reuWO21ZYGA1aL05mCUm3snEUAJkELkHrliW2+5rzxXDrMwk5SOAsiFp8hanXntfA8cC2NJGG3onG7pXY2SvGyDDBLxL5bZg5vCR97l7TQMrONpyaW+e8K2tJLu13lHMFP+pBcmb0gOcMCp7rZWb0gNwVCZzVO9wDmRwdcQFcW0BdgCrlC6T3wUDn/QIdZugYGECORQkSl/lx9c3KUAlngr6yTNqTWPjXG6FJwgNr7K44Q2GGm1GP7n6F/eHhvmeAx3QUu/7YTEU3Dxak9c+6vkN/NAkhRIEjxDn2ahBU6MiBzYNWvfzRGkCm+aaViigzWKoNw52c3GtaZogz24fJFEa+Fluat60oPihrYritfba6ioo0UEoFRhOvbxJIfKobrmnXfB0BEM76MNlH3gLuR2sSyUlELYsIRvyDRiklSnK0wWSJDtkI40VNEncwbYQNg5nXSb6xYgX0riX6jCBKvsu2XlvkeMx3UtpPEkOla7ne8pWfIUSo6wCvFSB9Ap+fH0Dn4ezkUn40AMyTA2NHgkBURlDY9JWKHTbYGVIUZaYZc5GIw0RDIWNNIK1Jgjo0fXW2u5+X1AMB9p+nk9mOxWDoYZcVQ7R7BU1MUTeXqbSatCEVwqEPO7iciu77V9J/JUbf4F4aIPUxDsKfNm/3cby41fDb2Kry12pPrShZXcqtqgi33G0u8sYkl1yeSnQkjmS+jqWpAMVBofQXjMX+4nFS/rWI8ZwxAfkoCX5Fq8P6PaPsEPmjCEhhNQQiO2saP9ws0tPYPaPhT5oySnpEP9bNjeJW1cYKJFUchve+7tDafjgKmzbHXL2F9hwtyPABF2+nazuulxe7sAEOfMusnJTV8KxaXkyDMUwdmFbD2cWcP72Fhdya//YQlOu29o5cTuHHU/XlccNhhhsEz2xCA=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_is-subsequence"></div></div>
</details><hr /><br />

**类似题目**：
  - [792. 匹配子序列的单词数 🟠](/problems/number-of-matching-subsequences)

</details>
</div>



