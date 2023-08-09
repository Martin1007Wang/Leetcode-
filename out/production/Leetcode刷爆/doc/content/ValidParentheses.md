<p>给定一个只包括 <code>'('</code>，<code>')'</code>，<code>'{'</code>，<code>'}'</code>，<code>'['</code>，<code>']'</code>&nbsp;的字符串 <code>s</code> ，判断字符串是否有效。</p>

<p>有效字符串需满足：</p>

<ol> 
 <li>左括号必须用相同类型的右括号闭合。</li> 
 <li>左括号必须以正确的顺序闭合。</li> 
 <li>每个右括号都有一个对应的相同类型的左括号。</li> 
</ol>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "()"
<strong>输出：</strong>true
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>s = "()[]{}"
<strong>输出：</strong>true
</pre>

<p><strong>示例&nbsp;3：</strong></p>

<pre>
<strong>输入：</strong>s = "(]"
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s</code> 仅由括号 <code>'()[]{}'</code> 组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 字符串</details><br>

<div>👍 3982, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=valid-parentheses" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

栈是一种先进后出的数据结构，处理括号问题的时候尤其有用。

遇到左括号就入栈，遇到右括号就去栈中寻找最近的左括号，看是否匹配。

**详细题解：[如何解决括号相关的问题](https://labuladong.github.io/article/fname.html?fname=括号插入)**

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
    bool isValid(string str) {
        stack<char> left;
        for (char c : str) {
            if (c == '(' || c == '{' || c == '[')
                left.push(c);
            else // 字符 c 是右括号
                if (!left.empty() && leftOf(c) == left.top())
                    left.pop();
                else
                    // 和最近的左括号不匹配
                    return false;
        }
        // 是否所有的左括号都被匹配了
        return left.empty();
    }

    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def isValid(self, s: str) -> bool:
        left = []  # 使用栈结构，存储所有待匹配的左括号
        for c in s:
            if c == '(' or c == '{' or c == '[':
                left.append(c)  # 如果字符 c 是左括号，则将其加入左括号栈 left 中
            else:
                if left and self.leftOf(c) == left[-1]:  # 如果字符 c 是右括号，则比较它与最近一次加入栈 left 中的左括号是否匹配
                    left.pop()  # 如果匹配，则将最近的左括号出栈，否则返回 False
                else:
                    return False
        return not left  # 最后判断栈是否为空，如果是则说明所有的左括号都被匹配了，返回 True，否则返回 False

    def leftOf(self, c: str) -> str:
        if c == '}':
            return '{'
        elif c == ')':
            return '('
        else:
            return '['
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isValid(String str) {
        Stack<Character> left = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                left.push(c);
            else // 字符 c 是右括号
                if (!left.isEmpty() && leftOf(c) == left.peek())
                    left.pop();
                else
                    // 和最近的左括号不匹配
                    return false;
        }
        // 是否所有的左括号都被匹配了
        return left.isEmpty();
    }

    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 包名为 main
// 定义一个字节数组栈类型
type Stack []byte

// 入栈操作
func (s *Stack) push(str byte) {
    *s = append(*s, str)
}

// 出栈操作
func (s *Stack) pop() byte {
    if len(*s) == 0 {
        return 0
    }
    res := (*s)[len(*s)-1]
    *s = (*s)[:len(*s)-1]
    return res
}

// 判断给定字符串是否是合法的括号序列
func isValid(str string) bool {
    // 定义一个栈 left 保存左括号
    var left Stack
    // 遍历字符
    for i := range str {
        c := str[i]
        // 当 c 是左括号时，入栈 left
        if c == '(' || c == '[' || c == '{' {
            left.push(c)
        } else { // 当 c 是右括号时
            // 如果栈 left 非空，且栈顶的左括号和当前右括号匹配，则弹出栈顶元素
            if len(left) != 0 && leftOf(c) == left.pop() {
                continue
            } else { // 当前左括号和最近的左括号不匹配
                return false
            }
        }
    }
    // 是否所有的左括号都被匹配了
    return len(left) == 0
}

// 返回左括号
func leftOf(c byte) byte {
    if c == '}' {
        return '{'
    } else if c == ')' {
        return '('
    } else {
        return '['
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var isValid = function(str) {
    // 建立一个栈
    let left = [];
    // 遍历字符串中的每一个字符
    for (let c of str) {
        // 如果是左括号，则入栈
        if (c == '(' || c == '{' || c == '[')
            left.push(c);
        else { // 字符 c 是右括号
            // 如果栈不为空，并且最近入栈的左括号可以匹配，则出栈
            if (left.length && leftOf(c) == left[left.length-1])
                left.pop();
            else
                // 和最近的左括号不匹配
                return false;
        }
    }
    // 是否所有的左括号都被匹配了
    return !left.length;
}

function leftOf(c) {
    if (c == '}') return '{';
    if (c == ')') return '(';
    return '[';
}
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_valid-parentheses" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_valid-parentheses"></div></div>
</details><hr /><br />

**类似题目**：
  - [1541. 平衡括号字符串的最少插入次数 🟠](/problems/minimum-insertions-to-balance-a-parentheses-string)
  - [921. 使括号有效的最少添加 🟠](/problems/minimum-add-to-make-parentheses-valid)

</details>
</div>



