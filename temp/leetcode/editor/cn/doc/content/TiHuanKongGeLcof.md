<p>请实现一个函数，把字符串 <code>s</code> 中的每个空格替换成"%20"。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "We are happy."
<strong>输出：</strong>"We%20are%20happy."</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= s 的长度 &lt;= 10000</code></p>

<details><summary><strong>Related Topics</strong></summary>字符串</details><br>

<div>👍 500, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

很简单，只要注意下不同语言中字符串的操作即可。

**标签：字符串**

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
    string replaceSpace(string s) {
        string ans;
        for (char c : s) {
            if (c == ' ') {
                ans += "%20";
            } else {
                ans += c;
            }
        }
        return ans;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def replaceSpace(self, s: str) -> str:
        sb = []
        for c in s:
            if c == ' ':
                sb.append('%20')
            else:
                sb.append(c)
        return ''.join(sb)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @author ylx
 * @date 2021/2/2 19:19
 * @description Go 实现的 LeetCode 剑指 Offer 05. 替换空格
 */
func replaceSpace(s string) string {
    var res strings.Builder
    for i := 0; i < len(s); i++ {
        if s[i] == ' ' {
            res.WriteString("%20")
        } else {
            res.WriteByte(s[i])
        }
    }
    return res.String()
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var replaceSpace = function(s) {
  var sb = [];
  for (var i = 0; i < s.length; i++) {
    var c = s.charAt(i);
    if (c === ' ') {
      sb.push('%20');
    } else {
      sb.push(c);
    }
  }
  return sb.join('');
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_ti-huan-kong-ge-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_ti-huan-kong-ge-lcof"></div></div>
</details><hr /><br />

</details>
</div>



