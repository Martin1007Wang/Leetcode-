<p>给你一个括号字符串&nbsp;<code>s</code>&nbsp;，它只包含字符&nbsp;<code>'('</code> 和&nbsp;<code>')'</code>&nbsp;。一个括号字符串被称为平衡的当它满足：</p>

<ul> 
 <li>任何左括号&nbsp;<code>'('</code>&nbsp;必须对应两个连续的右括号&nbsp;<code>'))'</code>&nbsp;。</li> 
 <li>左括号&nbsp;<code>'('</code>&nbsp;必须在对应的连续两个右括号&nbsp;<code>'))'</code>&nbsp;之前。</li> 
</ul>

<p>比方说&nbsp;<code>"())"</code>，&nbsp;<code>"())(())))"</code> 和&nbsp;<code>"(())())))"</code>&nbsp;都是平衡的，&nbsp;<code>")()"</code>，&nbsp;<code>"()))"</code> 和&nbsp;<code>"(()))"</code>&nbsp;都是不平衡的。</p>

<p>你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。</p>

<p>请你返回让 <code>s</code>&nbsp;平衡的最少插入次数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "(()))"
<strong>输出：</strong>1
<strong>解释：</strong>第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 ')' 使字符串变成平衡字符串 "(())))" 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = "())"
<strong>输出：</strong>0
<strong>解释：</strong>字符串已经平衡了。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = "))())("
<strong>输出：</strong>3
<strong>解释：</strong>添加 '(' 去匹配最开头的 '))' ，然后添加 '))' 去匹配最后一个 '(' 。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = "(((((("
<strong>输出：</strong>12
<strong>解释：</strong>添加 12 个 ')' 得到平衡字符串。
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>s = ")))))))"
<strong>输出：</strong>5
<strong>解释：</strong>在字符串开头添加 4 个 '(' 并在结尾添加 1 个 ')' ，字符串变成平衡字符串 "(((())))))))" 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10^5</code></li> 
 <li><code>s</code>&nbsp;只包含&nbsp;<code>'('</code> 和&nbsp;<code>')'</code>&nbsp;。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 贪心 | 字符串</details><br>

<div>👍 65, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=minimum-insertions-to-balance-a-parentheses-string" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

遍历字符串，通过一个 `need` 变量记录对右括号的需求数，根据 `need` 的变化来判断是否需要插入。

类似 [921. 使括号有效的最少添加](/problems/minimum-add-to-make-parentheses-valid)，当 `need == -1` 时，意味着我们遇到一个多余的右括号，显然需要插入一个左括号。

另外，当遇到左括号时，若对右括号的需求量为奇数，需要插入 1 个右括号，因为一个左括号需要两个右括号嘛，右括号的需求必须是偶数，这一点也是本题的难点。

**详细题解：[如何解决括号相关的问题](https://labuladong.github.io/article/fname.html?fname=括号插入)**

**标签：括号问题**

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
    int minInsertions(string s) {
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            }

            if (s[i] == ')') {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }

        return res + need;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minInsertions(self, s: str) -> int:
        res = 0
        need = 0
        
        # Traverse through string s
        for i in range(len(s)):
            if s[i] == '(':
                need += 2
                if need % 2 == 1:
                    res += 1
                    need -= 1
            
            if s[i] == ')':
                need -= 1
                if need == -1:
                    res += 1
                    need = 1
        
        return res + need
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int minInsertions(String s) {
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            }

            if (s.charAt(i) == ')') {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }

        return res + need;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func minInsertions(s string) int {
	res := 0
	need := 0

	for i := 0; i < len(s); i++ {
		if s[i] == '(' {
			need += 2
			if need%2 == 1 {
				res++
				need--
			}
		} else if s[i] == ')' {
			need--
			if need == -1 {
				res++
				need = 1
			}
		}
	}

	return res + need
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var minInsertions = function(s) {
    let res = 0, need = 0;

    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) == '(') {
            need += 2;
            if (need % 2 == 1) {
                res++;
                need--;
            }
        }

        if (s.charAt(i) == ')') {
            need--;
            if (need == -1) {
                res++;
                need = 1;
            }
        }
    }
    return res + need;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_minimum-insertions-to-balance-a-parentheses-string" data="G5QYAJyFseOjkIyWdRpjvfBiKbLS8v9+6/v69VXT6kYmGyAhihecyDPw715/43KWJDe/bXAoFhQK+sLJ/2/tFdEj3YCxcaxyoqLARUX/92Zyk5R4C0yzs9lfYFTfyApTp6tdj//L2FTAevRwo6z5Yey0lfuRt1269fsqIZFQa+T+GQZeL12WGhxiSWN9BXr9rMjU8j/8M6YNnbS7ROHuFLGiCRZqEq8K3zQEyFTqs0KCKRH1T4ZNUZvkPmD42W+GtSNO+jdTBgDZT7WaNa13PvLs6+M2QFj7mW4OjcvUyuqXT+js9KbENUNW7r8j96dSkNylP80tpy5kKEiUuuYjZIlo+Gr7p6en7dObWKITmKO8S4icJOCkVWNwIxcUsbq/y57qHWM8Pm4e8C60/HmZdAWPHwOJO7vxLIaoeipnRVLJ8fyoCeG3THyyU9Fh16SGLTGvJKa1B1UsrxHhs4q4vwWKYnXlw8+7Rv3pt0+/IIlOlnRqhXZAzg3Ez8QUr6zoGjC6V+jZa+2oMJkROp1JNz5DhA/fdFcS4mJEjN8Y2g/rYj2dBsRDU5qHFWlAUqR5RNHnNHp6/sYIU1OxWKS9LTFLZU559/+x7EOa4flKLrbFeE7FatDM3RPLLG8yj7OFRf+SSwq5qJKs/GIXhRPNmu3O4fq4SO7/6zAETZZsAO3MnKcChbb5HRsn0LPpnXpnsNCZiRUvAcOmMFtXWIq67SZXwMTLwYyhbOFm2ZwKIzietn4LmxbdQFy0zAdeseKxIoZfQIXMoihnhIjYYF63tlK5J7aIvmLHcDuokAzvQRlI7z2LSRFD46k4zN0gHy572pz9KKVoFTSAtlHJcK7ysWDZdyYnZSq0ovoykXhija5vXG9zoGaHCWTWmEy1qRB5j7kKS9Fg3lLqlLfzWIIxSBmRt/PAMSLyGVR4y1PBkDxgshE96rDVzFY+/xjM1OrRiNuWCoPJU2NjgaCXfP300kCX3gXhrDl9NSJ+BZHyIwgpC6LWlzCLWCLqj6YXewxFbuIAeGTrn3wNMKuSFHrcl+jmL+FHY5Vt7PkhWFSdbdKxjrBwdNZR9L8OQkmnscTQiBI6OtRqMvbexznrajWIYOh0Ld7q4dQeRzVka/zdKMq24FHwVr2Ijiy95cjSLV6avU2oUlKfVyxIgpFj19Otb1Uuv/cNUIPUwVaVwdz32UIwzYLfIjgZuhxdaqQzNNTfkZXodTmc3b9aO6qyCs5uL4AallU/tOdZAMWitfntO0iOTqqBW7K1n6xD7ohWK41lW279+uklfJK5r8ihPCcV1kOHykEtIPaCa3gW4F3HieH3skXLbaofNgcwfNDJC0OeIARa3ioI02fTgl52N1BtlUxUSKgx2OwsD50GLouQTD7xkYNm05zxSyR5t4Zm2mJIuNSW71bLo0pDnqqopb8nG24WOnv/yP3dpFTlUWcmpxKK2qfw0MOzFuE/m/95elZspYSiKIpoZ8XE2phHOV1tv1ug20Y7PQ36YtFh4HN9+tZQ6KQTmYC/mF43rZo8nJ2Gs+Lu3eLk9MQeX5Ta7EVVQAgkErUQHBXkcQOuqcXZD7tIEflDr24X737j9ziuLj2Lh5wP6fWuXz2+qLhb4Mb93a6z02hbdNEKgiW7q43Qn8zjrLibAoJTKfnU+nHV2e10ZldSZOuPwWQO6yN0Rnse"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-insertions-to-balance-a-parentheses-string"></div></div>
</details><hr /><br />

**类似题目**：
  - [20. 有效的括号 🟢](/problems/valid-parentheses)
  - [921. 使括号有效的最少添加 🟠](/problems/minimum-add-to-make-parentheses-valid)

</details>
</div>



