<p>给你一个字符串 <code>s</code> ，请你反转字符串中 <strong>单词</strong> 的顺序。</p>

<p><strong>单词</strong> 是由非空格字符组成的字符串。<code>s</code> 中使用至少一个空格将字符串中的 <strong>单词</strong> 分隔开。</p>

<p>返回 <strong>单词</strong> 顺序颠倒且 <strong>单词</strong> 之间用单个空格连接的结果字符串。</p>

<p><strong>注意：</strong>输入字符串 <code>s</code>中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "<span><code>the sky is blue</code></span>"
<strong>输出：</strong>"<span><code>blue is sky the</code></span>"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = " &nbsp;hello world &nbsp;"
<strong>输出：</strong>"world hello"
<strong>解释：</strong>反转后的字符串中不能存在前导空格和尾随空格。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "a good &nbsp; example"
<strong>输出：</strong>"example good a"
<strong>解释：</strong>如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s</code> 包含英文大小写字母、数字和空格 <code>' '</code></li> 
 <li><code>s</code> 中 <strong>至少存在一个</strong> 单词</li> 
</ul>

<ul> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用&nbsp;<code>O(1)</code> 额外空间复杂度的 <strong>原地</strong> 解法。</p>

<details><summary><strong>Related Topics</strong></summary>双指针 | 字符串</details><br>

<div>👍 896, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=reverse-words-in-a-string" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

常规方法是用类似 `split` 再 `reverse` 最后 `join` 的方法得到结果，但更巧妙的方法是我在 [二维数组的花式遍历](https://labuladong.github.io/article/fname.html?fname=花式遍历) 中讲到的：**先把整个字符串进行翻转，再把每个单词中的字母翻转**。

比如说，给你输入这样一个字符串：

```shell
s = "hello world labuladong"
```

那么我们先将整个字符串 `s` 反转：

```shell
s = "gnodalubal dlrow olleh"
```

**然后将每个单词分别反转**：

```shell
s = "labuladong world hello"
```

这样，就实现了原地反转所有单词顺序的目的。

整体的思路应该不难，就是细节比较恶心，直接看我写的代码吧。

**详细题解：[二维数组的花式遍历技巧](https://labuladong.github.io/article/fname.html?fname=花式遍历)**

**标签：字符串，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    string reverseWords(string s) {
        string res;
        // 清洗一下数据，去除多余的空格
        for (int i = 0; i < s.size(); i++) {
            char c = s[i];
            if (c != ' ') {
                // 单词中的字母/数字
                res += c;
            }
 
            else if (res.back() != ' ') {
                // 单词之间保留一个空格
                res += ' ';
            }
        }
        // 末尾如果有空格，清除之
        if (res.back() == ' ') {
            res.pop_back();
        }
 
        // 清洗之后的字符串
        char *chars = new char[res.size() + 1];
        strcpy(chars, res.c_str());
        int n = strlen(chars);
        // 进行单词的翻转，先整体翻转
        reverse(chars, 0, n - 1);
        // 再把每个单词翻转
        for (int i = 0; i < n; ) {
            for (int j = i; j < n; j++) {
                if (j + 1 == n || chars[j + 1] == ' ') {
                    // chars[i..j] 是一个单词，翻转之
                    reverse(chars, i, j);
                    // 把 i 置为下一个单词的首字母
                    i = j + 2;
                    break;
                }
            }
        }
        // 最后得到题目想要的结果
        return chars;
    }
 
    // 翻转 arr[i..j]
    void reverse(char* arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
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
    def reverseWords(self, s: str) -> str:
        sb = []
        # 先清洗一下数据，把多余的空格都删掉
        for c in s:
            if c != ' ':
                # 单词中的字母/数字
                sb.append(c)
            elif sb and sb[-1] != ' ':
                # 单词之间保留一个空格
                sb.append(' ')
        # 末尾如果有空格，清除之
        if sb and sb[-1] == ' ':
            sb.pop()
        
        # 清洗之后的字符串
        chars = sb

        # 进行单词的翻转，先整体翻转
        def reverse(l, r):
            while l < r:
                chars[l], chars[r] = chars[r], chars[l]
                l += 1
                r -= 1
        
        n = len(chars)
        reverse(0, n-1)
        
        # 再把每个单词翻转
        start = end = 0
        while end < n:
            if chars[end] == ' ':
                reverse(start, end-1)
                start = end + 1
            end += 1
        
        # 翻转最后一个单词
        reverse(start, n-1)
        
        # 最后得到题目想要的结果
        return "".join(chars)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // 先清洗一下数据，把多于的空格都删掉
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                // 单词中的字母/数字
                sb.append(c);
            } else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                // 单词之间保留一个空格
                sb.append(' ');
            }
        }
        if (sb.isEmpty()) {
            return "";
        }
        // 末尾如果有空格，清除之
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 清洗之后的字符串
        char[] chars = sb.toString().toCharArray();
        int n = chars.length;
        // 进行单词的翻转，先整体翻转
        reverse(chars, 0, n - 1);
        // 再把每个单词翻转
        for (int i = 0; i < n; ) {
            for (int j = i; j < n; j++) {
                if (j + 1 == n || chars[j + 1] == ' ') {
                    // chars[i..j] 是一个单词，翻转之
                    reverse(chars, i, j);
                    // 把 i 置为下一个单词的首字母
                    i = j + 2;
                    break;
                }
            }
        }
        // 最后得到题目想要的结果
        return new String(chars);
    }

    // 翻转 arr[i..j]
    void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func reverseWords(s string) string {
    sb := strings.Builder{}
    // 先清洗一下数据，把多于的空格都删掉
    for i := 0; i < len(s); i++ {
        c := s[i]
        if c != ' ' {
            // 单词中的字母/数字
            sb.WriteByte(c)
        } else if sb.Len() > 0 && sb.String()[sb.Len()-1] != ' ' {
            // 单词之间保留一个空格
            sb.WriteByte(' ')
        }
    }
    // 末尾如果有空格，清除之
    str := sb.String()
    if len(str) > 0 && str[len(str)-1] == ' ' {
        str = str[:len(str)-1]
    }

    // 清洗之后的字符串
    chars := []byte(str)
    n := len(chars)
    // 进行单词的翻转，先整体翻转
    reverse(chars, 0, n-1)
    // 再把每个单词翻转
    for i := 0; i < n; {
        for j := i; j < n; j++ {
            if j+1 == n || chars[j+1] == ' ' {
                // chars[i..j] 是一个单词，翻转之
                reverse(chars, i, j)
                // 把 i 置为下一个单词的首字母
                i = j + 2
                break
            }
        }
    }
    // 最后得到题目想要的结果
    return string(chars)
}

// 翻转 arr[i..j]
func reverse(arr []byte, i, j int) {
    for i < j {
        arr[i], arr[j] = arr[j], arr[i]
        i++
        j--
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var reverseWords = function(s) {
    let sb = "";
    // 先清洗一下数据，把多于的空格都删掉
    for (let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        if (c !== ' ') {
            // 单词中的字母/数字
            sb += c;
        } else if (sb !== "" && sb[sb.length - 1] !== ' ') {
            // 单词之间保留一个空格
            sb += ' ';
        }
    }
    // 末尾如果有空格，清除之
    if (sb[sb.length - 1] === ' ') {
        sb = sb.substring(0, sb.length - 1);
    }

    // 清洗之后的字符串
    let chars = sb.split('');
    let n = chars.length;
    // 进行单词的翻转，先整体翻转
    reverse(chars, 0, n - 1);
    // 再把每个单词翻转
    for (let i = 0; i < n;) {
        for (let j = i; j < n; j++) {
            if (j + 1 === n || chars[j + 1] === ' ') {
                // chars[i..j] 是一个单词，翻转之
                reverse(chars, i, j);
                // 把 i 置为下一个单词的首字母
                i = j + 2;
                break;
            }
        }
    }
    // 最后得到题目想要的结果
    return chars.join("");
};

// 翻转 arr[i..j]
function reverse(arr, i, j) {
    while (i < j) {
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
}
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_reverse-words-in-a-string" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-words-in-a-string"></div></div>
</details><hr /><br />

**类似题目**：
  - [1260. 二维网格迁移 🟢](/problems/shift-2d-grid)
  - [48. 旋转图像 🟠](/problems/rotate-image)
  - [54. 螺旋矩阵 🟠](/problems/spiral-matrix)
  - [59. 螺旋矩阵 II 🟠](/problems/spiral-matrix-ii)
  - [剑指 Offer 29. 顺时针打印矩阵 🟢](/problems/shun-shi-zhen-da-yin-ju-zhen-lcof)
  - [剑指 Offer 58 - I. 翻转单词顺序 🟢](/problems/fan-zhuan-dan-ci-shun-xu-lcof)

</details>
</div>



