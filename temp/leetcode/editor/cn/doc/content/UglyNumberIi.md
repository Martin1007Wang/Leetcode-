<p>给你一个整数 <code>n</code> ，请你找出并返回第 <code>n</code> 个 <strong>丑数</strong> 。</p>

<p><strong>丑数 </strong>就是只包含质因数&nbsp;<code>2</code>、<code>3</code> 和/或&nbsp;<code>5</code>&nbsp;的正整数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 10
<strong>输出：</strong>12
<strong>解释：</strong>[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>1
<strong>解释：</strong>1 通常被视为丑数。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 1690</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 数学 | 动态规划 | 堆（优先队列）</details><br>

<div>👍 1083, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=ugly-number-ii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题很精妙，你看着它好像是道数学题，实际上它却是一个合并多个有序链表的问题，同时用到了筛选素数的思路。

建议你先做一下 [链表双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中讲到的 [21. 合并两个有序链表（简单）](/problems/merge-two-sorted-lists)，然后再做一下 [如何高效寻找素数](https://labuladong.github.io/article/fname.html?fname=打印素数) 中讲的 [204. 计数质数（简单）](/problems/count-primes)，这样的话就能比较容易理解这道题的思路了。

**类似 [如何高效寻找素数](https://labuladong.github.io/article/fname.html?fname=打印素数) 的思路：如果一个数 `x` 是丑数，那么 `x * 2, x * 3, x * 5` 都一定是丑数**。

我们把所有丑数想象成一个从小到大排序的链表，就是这个样子：

```java
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 8 -> ...
```

然后，我们可以把丑数分为三类：2 的倍数、3 的倍数、5 的倍数（按照题目的意思，1 算作特殊的丑数，放在开头），这三类丑数就好像三条有序链表，如下：

能被 2 整除的丑数：

```java
1 -> 1*2 -> 2*2 -> 3*2 -> 4*2 -> 5*2 -> 6*2 -> 8*2 ->...
```

能被 3 整除的丑数：

```java
1 -> 1*3 -> 2*3 -> 3*3 -> 4*3 -> 5*3 -> 6*3 -> 8*3 ->...
```

能被 5 整除的丑数：

```java
1 -> 1*5 -> 2*5 -> 3*5 -> 4*5 -> 5*5 -> 6*5 -> 8*5 ->...
```

我们其实就是想把这三条「有序链表」合并在一起并去重，合并的结果就是丑数的序列。然后求合并后的这条有序链表中第 `n` 个元素是什么。所以这里就和 [链表双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中讲到的合并 `k` 条有序链表的思路基本一样了。

具体思路看注释吧，你也可以对照我在 [21. 合并两个有序链表（简单）](/problems/merge-two-sorted-lists) 中给出的思路代码来看本题的思路代码，就能轻松看懂本题的解法代码了。

**详细题解：[丑数系列算法详解](https://labuladong.github.io/article/fname.html?fname=丑数)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        vector<int> ugly(n + 1, 0);
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表
        while (p <= n) {
            // 取三个链表的最小结点
            int min_val = min(min(product2, product3), product5);
            // 接到结果链表上
            ugly[p] = min_val;
            p++;
            // 前进对应有序链表上的指针
            if (min_val == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min_val == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min_val == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def nthUglyNumber(self,n: int) -> int:
        # 三个指向有序链表头结点的指针
        p2,p3,p5 = 1,1,1
        # 三个有序链表的头节点的值
        product2, product3, product5 = 1, 1, 1
        # 最终合并的有序链表（结果链表）
        ugly = [0] * (n + 1)
        # 结果链表上的指针
        p = 1

        # 开始合并三个有序链表
        while p <= n:
            # 取三个链表的最小结点
            minv = min(product2, product3, product5)
            # 接到结果链表上
            ugly[p] = minv
            p += 1
            # 前进对应有序链表上的指针
            if minv == product2:
                product2 = 2 * ugly[p2]
                p2 += 1
            if minv == product3:
                product3 = 3 * ugly[p3]
                p3 += 1
            if minv == product5:
                product5 = 5 * ugly[p5]
                p5 += 1

        # 返回第 n 个丑数
        return ugly[n]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n + 1];
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表
        while (p <= n) {
            // 取三个链表的最小结点
            int min = Math.min(Math.min(product2, product3), product5);
            // 接到结果链表上
            ugly[p] = min;
            p++;
            // 前进对应有序链表上的指针
            if (min == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func nthUglyNumber(n int) int {
    // 可以理解为三个指向有序链表头结点的指针
    p2, p3, p5 := 1, 1, 1
    // 可以理解为三个有序链表的头节点的值
    product2, product3, product5 := 1, 1, 1
    // 可以理解为最终合并的有序链表（结果链表）
    ugly := make([]int, n+1)
    // 可以理解为结果链表上的指针
    p := 1

    // 开始合并三个有序链表
    for p <= n {
        // 取三个链表的最小结点
        min := min(product2, product3, product5)
        // 接到结果链表上
        ugly[p] = min
        p++
        // 前进对应有序链表上的指针
        if min == product2 {
            product2 = 2 * ugly[p2]
            p2++
        }
        if min == product3 {
            product3 = 3 * ugly[p3]
            p3++
        }
        if min == product5 {
            product5 = 5 * ugly[p5]
            p5++
        }
    }
    // 返回第 n 个丑数
    return ugly[n]
}

// 取三个数的最小值
func min(i, j, k int) int {
    if i < j {
        if i < k {
            return i
        } else {
            return k
        }
    } else {
        if j < k {
            return j
        } else {
            return k
        }
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var nthUglyNumber = function(n) {
    // 可以理解为三个指向有序链表头结点的指针
    let p2 = 1, p3 = 1, p5 = 1;
    // 可以理解为三个有序链表的头节点的值
    let product2 = 1, product3 = 1, product5 = 1;
    // 可以理解为最终合并的有序链表（结果链表）
    let ugly = new Array(n + 1);
    // 可以理解为结果链表上的指针
    let p = 1;
  
    // 开始合并三个有序链表
    while (p <= n) {
        // 取三个链表的最小结点
        let min = Math.min(Math.min(product2, product3), product5);
        // 接到结果链表上
        ugly[p] = min;
        p++;
        // 前进对应有序链表上的指针
        if (min === product2) {
            product2 = 2 * ugly[p2];
            p2++;
        }
        if (min === product3) {
            product3 = 3 * ugly[p3];
            p3++;
        }
        if (min === product5) {
            product5 = 5 * ugly[p5];
            p5++;
        }
    }
    // 返回第 n 个丑数
    return ugly[n];
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_ugly-number-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_ugly-number-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [1201. 丑数 III 🟠](/problems/ugly-number-iii)
  - [263. 丑数 🟢](/problems/ugly-number)
  - [313. 超级丑数 🟠](/problems/super-ugly-number)
  - [剑指 Offer 49. 丑数 🟠](/problems/chou-shu-lcof)

</details>
</div>



